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

import com.openitvn.unicore.raster.IPixelFormat;
import com.openitvn.unicore.raster.ICubeMapHeader;
import com.openitvn.util.StringHelper;
import com.openitvn.unicore.data.DataStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Thinh Pham
 */

public class DXHeader {
    
    // dwFlags
    protected static final int DDS_HEADER_FLAGS_TEXTURE    = 0x001007; // DDSD_CAPS | DDSD_HEIGHT | DDSD_WIDTH | DDSD_PIXELFORMAT;
    protected static final int DDS_HEADER_FLAGS_MIPMAP     = 0x020000; // DDSD_MIPMAPCOUNT
    protected static final int DDS_HEADER_FLAGS_VOLUME     = 0x800000; // DDSD_DEPTH
    protected static final int DDS_HEADER_FLAGS_PITCH      = 0x000008; // DDSD_PITCH
    protected static final int DDS_HEADER_FLAGS_LINEARSIZE = 0x080000; // DDSD_LINEARSIZE
    protected static final int DDS_FOURCC     = 0x00004; // DDPF_FOURCC
    protected static final int DDS_RGB        = 0x00040; // DDPF_RGB
    protected static final int DDS_RGBA       = 0x00041; // DDPF_RGB | DDPF_ALPHAPIXELS;
    protected static final int DDS_LUMINANCE  = 0x20000; // DDPF_LUMINANCE
    protected static final int DDS_LUMINANCEA = 0x20001; // DDPF_LUMINANCE | DDPF_ALPHAPIXELS;
    protected static final int DDS_ALPHA      = 0x00002; // DDPF_ALPHA
    protected static final int DDS_PAL8       = 0x00020; // DDPF_PALETTEINDEXED8;
    
    // dwCaps
    protected static final int DDS_SURFACE_FLAGS_TEXTURE = 0x001000; // DDSCAPS_TEXTURE
    protected static final int DDS_SURFACE_FLAGS_CUBEMAP = 0x001008; // DDSCAPS_TEXTURE | DDSCAPS_COMPLEX
    protected static final int DDS_SURFACE_FLAGS_MIPMAP  = 0x401008; // DDSCAPS_TEXTURE | DDSCAPS_COMPLEX | DDSCAPS_MIPMAP;
    
    // dwCaps2
    protected static final int DDSCAPS2_CUBEMAP      = 0x00000200; // Required for a cube map.
    protected static final int DDSCAPS2_VOLUME       = 0x00200000; // Required for a volume texture.
    protected static final int DDS_CUBEMAP_POSITIVEX = 0x00000600; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_POSITIVEX
    protected static final int DDS_CUBEMAP_NEGATIVEX = 0x00000a00; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_NEGATIVEX
    protected static final int DDS_CUBEMAP_POSITIVEY = 0x00001200; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_POSITIVEY
    protected static final int DDS_CUBEMAP_NEGATIVEY = 0x00002200; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_NEGATIVEY
    protected static final int DDS_CUBEMAP_POSITIVEZ = 0x00004200; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_POSITIVEZ
    protected static final int DDS_CUBEMAP_NEGATIVEZ = 0x00008200; // DDSCAPS2_CUBEMAP | DDSCAPS2_CUBEMAP_NEGATIVEZ
    protected static final int DDS_CUBEMAP_ALLFACES  = DDS_CUBEMAP_POSITIVEX | DDS_CUBEMAP_NEGATIVEX | DDS_CUBEMAP_POSITIVEY | DDS_CUBEMAP_NEGATIVEY | DDS_CUBEMAP_POSITIVEZ | DDS_CUBEMAP_NEGATIVEZ;
    // Note: Although Direct3D 9 supports partial cube-maps, Direct3D 10, 10.1, and 11 require that you define all six cube-map faces (that is, you must set DDS_CUBEMAP_ALLFACES).
    
    private final int dwMagic = StringHelper.makeFourCC("DDS ");
    protected final int dwSize = 124;
    private int dwFlags = DDS_HEADER_FLAGS_TEXTURE;
    protected final int dwHeight;
    protected final int dwWidth;
    protected final int dwPitchOrLinearSize;
    private int dwDepth;
    private int dwMipMapCount = 1;
    private final int[] dwReserved1 = new int[11];
    protected final DDSPixelFormat ddspf;
    private int dwCaps = DDS_SURFACE_FLAGS_TEXTURE;
    private int dwCaps2;
    private int dwCaps3;
    private int dwCaps4;
    private int dwReserved2;
    
    protected DXHeader(int width, int height, IPixelFormat fmt) throws UnsupportedOperationException {
        this.dwHeight = height;
        this.dwWidth = width;
        this.ddspf = DDSPixelFormat.fromFormat(fmt);
        this.dwPitchOrLinearSize = fmt.computePitchOrLinearSize(dwWidth);
        
        if (ddspf == DDSPixelFormat.D3DFMT_UNKNOW)
            throw new UnsupportedOperationException(String.format("Unable convert %1$s to DDSPixelFormat", fmt));
    }
    
    protected DXHeader(int width, int height, DX10Header headerDX10) throws UnsupportedOperationException {
        this.dwHeight = height;
        this.dwWidth = width;
        this.ddspf = DDSPixelFormat.D3DFMT_DX10;
        this.dwPitchOrLinearSize = headerDX10.dxgiFormat.format.computePitchOrLinearSize(width);
    }
    
    protected DXHeader(DataStream ds) {
        ds.position(8); //skip magic, dwSize
        dwFlags = ds.getInt();
        dwHeight = ds.getInt();
        dwWidth = ds.getInt();
        dwPitchOrLinearSize = ds.getInt();
        dwDepth = ds.getInt();
        dwMipMapCount = ds.getInt();
        for (int i = 0; i < 11; i++)
            dwReserved1[i] = ds.getInt();
        ddspf = DDSPixelFormat.fromData(ds);
        dwCaps = ds.getInt();
        dwCaps2 = ds.getInt();
        dwCaps3 = ds.getInt();
        dwCaps4 = ds.getInt();
        ds.position(ds.position() + 4); // skip dwReserved2
    }
    
    void writeTo(ByteBuffer bb) {
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putInt(dwMagic);
        bb.putInt(dwSize);
        bb.putInt(dwFlags);
        bb.putInt(dwHeight);
        bb.putInt(dwWidth);
        bb.putInt(dwPitchOrLinearSize);
        bb.putInt(dwDepth);
        bb.putInt(dwMipMapCount);
        for (int i = 0; i < 11; i++)
            bb.putInt(dwReserved1[i]);
        bb.put(ddspf.toBuffer());
        bb.putInt(dwCaps);
        bb.putInt(dwCaps2);
        bb.putInt(dwCaps3);
        bb.putInt(dwCaps4);
        bb.putInt(dwReserved2);
    }
    
    protected void setMipMapCount(int value) {
        dwMipMapCount = value;
        if (dwMipMapCount > 1) {
            dwFlags |= DDS_HEADER_FLAGS_MIPMAP;
            if (!isCubeMap())
                dwCaps = DDS_SURFACE_FLAGS_MIPMAP;
        }
    }
    
    public int getMipMapCount() {
        return ((dwFlags & DDS_HEADER_FLAGS_MIPMAP) != 0) ? dwMipMapCount : 1;
    }
    
    protected void setCubeMap(ICubeMapHeader cubeMap) {
        if (cubeMap.getFaceCount() > 0) {
            dwCaps = DDS_SURFACE_FLAGS_CUBEMAP;
            if (cubeMap.hasPX) dwCaps2 |= DDS_CUBEMAP_POSITIVEX;
            if (cubeMap.hasNX) dwCaps2 |= DDS_CUBEMAP_NEGATIVEX;
            if (cubeMap.hasPY) dwCaps2 |= DDS_CUBEMAP_POSITIVEY;
            if (cubeMap.hasNY) dwCaps2 |= DDS_CUBEMAP_NEGATIVEY;
            if (cubeMap.hasPZ) dwCaps2 |= DDS_CUBEMAP_POSITIVEZ;
            if (cubeMap.hasNZ) dwCaps2 |= DDS_CUBEMAP_NEGATIVEZ;
        }
    }
    
    protected boolean isCubeMap() {
        return (dwCaps == DDS_SURFACE_FLAGS_CUBEMAP);
    }
    
    protected ICubeMapHeader getCubeMap() {
        ICubeMapHeader cm = new ICubeMapHeader();
        if (isCubeMap()) {
            cm.hasPX = (dwCaps2 & DDS_CUBEMAP_POSITIVEX) != 0;
            cm.hasPY = (dwCaps2 & DDS_CUBEMAP_POSITIVEY) != 0;
            cm.hasPZ = (dwCaps2 & DDS_CUBEMAP_POSITIVEZ) != 0;
            cm.hasNX = (dwCaps2 & DDS_CUBEMAP_NEGATIVEX) != 0;
            cm.hasNY = (dwCaps2 & DDS_CUBEMAP_NEGATIVEY) != 0;
            cm.hasNZ = (dwCaps2 & DDS_CUBEMAP_NEGATIVEZ) != 0;
        }
        return cm;
    }
}
