/*
 * Copyright (C) 2020 Thinh Pham
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
package com.unimod.format.img;

import com.badlogic.gdx.graphics.GL20;
import com.openitvn.unicore.raster.ICubeMapHeader;
import com.openitvn.unicore.raster.IPixelFormat;
import com.openitvn.unicore.raster.IRaster;
import com.openitvn.unicore.raster.TextureHelper;
import com.openitvn.unicore.world.resource.ITexture;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Thinh Pham
 */
public class GenericImage extends ITexture {
    
    private final int width, height;
    private final byte[] data;

    GenericImage(BufferedImage img) {
        width = img.getWidth();
        height = img.getHeight();
        // make sure ABGR type
        BufferedImage norImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        norImg.getGraphics().drawImage(img, 0, 0, null);
        byte[] tmp = ((DataBufferByte)norImg.getRaster().getDataBuffer()).getData();
        // build data
        int numPixels = width * height;
        data = new byte[numPixels * 4];
        ByteBuffer rgba = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer abgr = ByteBuffer.wrap(tmp).order(ByteOrder.BIG_ENDIAN);
        for (int i = 0; i < numPixels; i++) {
            rgba.putInt(abgr.getInt());
        }
    }
    
    @Override
    public byte[] compilePatch(ITexture srcImg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public byte[] getImageBuffer(int faceId, int mipLevel) {
        return data;
    }

    @Override
    public void decodeImage(IRaster dstImg, int faceId, int mipLevel) {
        ByteBuffer bb = ByteBuffer.wrap(data);
        TextureHelper.decodeImage(dstImg, width, height, IPixelFormat.D3DFMT_A8B8G8R8, bb);
    }
    
    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getFaceCount() {
        return 1;
    }

    @Override
    public int getMipCount() {
        return 1;
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
    public ICubeMapHeader getCubeMapHeader() {
        return null;
    }

    @Override
    public IPixelFormat getPixelFormat() {
        return IPixelFormat.D3DFMT_A8B8G8R8;
    }
}
