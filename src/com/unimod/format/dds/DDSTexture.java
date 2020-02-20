/*
 * Copyright (C) 2017 Thinh Pham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.unimod.format.dds;

import com.badlogic.gdx.graphics.GL20;
import com.openitvn.unicore.world.resource.IPixelFormat;
import com.openitvn.unicore.world.resource.ICubeMap;
import com.openitvn.unicore.world.resource.ITexture;
import com.openitvn.unicore.data.DataStream;
import com.openitvn.util.FileHelper;
import java.awt.Dimension;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Thinh Pham
 */
public class DDSTexture extends ITexture {
    
    private DXHeader header; // common header
    private DX10Header headerDX10; // extended header for DX10
    private byte[][][] imageBuffers; // byte[imageCount][mipmapCount][]
    
    public DDSTexture(DataStream ds) {
        // read header
        header = new DXHeader(ds);
        if (header.ddspf == DDSPixelFormat.D3DFMT_DX10)
            headerDX10 = new DX10Header(ds);
        int numFaces = getFaceCount();
        int numMips = getMipCount();
        IPixelFormat format = getPixelFormat();
        
        // copy image buffers
        imageBuffers = new byte[numFaces][numMips][];
        for (int i = 0; i < numFaces; i++) {
            for (int j = 0; j < numMips; j++) {
                Dimension imageSize = computeMipMapSize(header.dwWidth, header.dwHeight, j);
                int bufferSize = format.computeImageBufferSize(imageSize);
                imageBuffers[i][j] = new byte[bufferSize];
                ds.get(imageBuffers[i][j]);
            }
        }
        setName(FileHelper.getFileName(ds.getLastPath()));
    }
    
    @Override
    public byte[] compileTexture(ITexture src) {
        // build header
        // try save as DirectX 10 first
        // when fail, fall back to DirectX legacy
        // if fail again, throw unsupported
        DX10PixelFormat dxgi = DX10PixelFormat.fromFormat(src.getPixelFormat());
        if (dxgi == DX10PixelFormat.DXGI_FORMAT_UNKNOWN) {
            header = new DXHeader(src.getWidth(), src.getHeight(), src.getPixelFormat());
        } else {
            headerDX10 = new DX10Header();
            headerDX10.dxgiFormat = dxgi;
            headerDX10.resourceDimension = DX10ResourceDimension.D3D10_RESOURCE_DIMENSION_TEXTURE2D;
            headerDX10.arraySize = src.getFaceCount();
            header = new DXHeader(src.getWidth(), src.getHeight(), headerDX10);
        }
        header.setMipMapCount(src.getMipCount());
        header.setCubeMap(src.getCubeMapHeader());
        // copy buffer from source
        int numFaces = src.getFaceCount();
        int numMips = header.getMipMapCount();
        imageBuffers = new byte[numFaces][numMips][];
        for (int i = 0; i < numFaces; i++) {
            for (int j = 0; j < numMips; j++) {
                imageBuffers[i][j] = src.getImageBuffer(i, j);
            }
        }
        
        // allocate file size
        int imgCount = getFaceCount();
        int fileSize = header.dwSize + 4;
        if (header.ddspf == DDSPixelFormat.D3DFMT_DX10)
            fileSize += 20;
        for (int i = 0; i < imgCount; i++) {
            for (int j = 0; j < header.getMipMapCount(); j++) {
                fileSize += imageBuffers[i][j].length;
            }
        }
        ByteBuffer bb = ByteBuffer.allocate(fileSize).order(ByteOrder.LITTLE_ENDIAN);
        // writeTo header
        header.writeTo(bb);
        // writeTo DX10 extended header
        if (header.ddspf == DDSPixelFormat.D3DFMT_DX10)
            headerDX10.writeTo(bb);
        // writeTo image buffer
        for (int i = 0; i < imgCount; i++) {
            for (int j = 0; j < header.getMipMapCount(); j++) {
                bb.put(imageBuffers[i][j]);
            }
        }
        return bb.array();
    }
    
    @Override
    public byte[][] getPalette() {
        return null;
    }
    
    @Override
    public byte[] getImageBuffer(int face, int mipLevel) {
        return imageBuffers[face][mipLevel];
    }
    
    @Override
    public int getWidth() {
        return header.dwWidth;
    }

    @Override
    public int getHeight() {
        return header.dwHeight;
    }
    
    @Override
    public final int getFaceCount() {
        return header.isCubeMap() ? header.getCubeMap().getFaceCount() : 1;
    }

    @Override
    public final int getMipCount() {
        return header.getMipMapCount();
    }
    
    @Override
    public int getUWrap() {
        return GL20.GL_CLAMP_TO_EDGE;
    }

    @Override
    public int getVWrap() {
        return GL20.GL_CLAMP_TO_EDGE;
    }
    
    @Override
    public ICubeMap getCubeMapHeader() {
        return header.getCubeMap();
    }
    
    @Override
    public final IPixelFormat getPixelFormat() {
        return (header.ddspf == DDSPixelFormat.D3DFMT_DX10) ?
                headerDX10.dxgiFormat.format :
                header.ddspf.format;
    }
}
