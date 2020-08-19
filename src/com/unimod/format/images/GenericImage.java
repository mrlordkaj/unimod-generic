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
package com.unimod.format.images;

import com.openitvn.unicore.data.DataStream;
import com.openitvn.unicore.world.resource.IPixelFormat;
import com.openitvn.unicore.world.resource.ITexture;
import com.openitvn.helper.FileHelper;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.imageio.ImageIO;

/**
 *
 * @author Thinh Pham
 */
public class GenericImage extends ITexture {
    
    GenericImage(DataStream ds) throws IOException {
        super(FileHelper.getFileName(ds.getLastPath()));
        BufferedImage img = ImageIO.read(ds);
        width = img.getWidth();
        height = img.getHeight();
        format = IPixelFormat.D3DFMT_A8B8G8R8;
        // make sure ABGR type
        BufferedImage norImg = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
        norImg.getGraphics().drawImage(img, 0, 0, null);
        byte[] tmp = ((DataBufferByte)norImg.getRaster().getDataBuffer()).getData();
        // build data
        int numPixels = width * height;
        imageBuffers = new byte[1][1][numPixels * 4];
        ByteBuffer rgba = ByteBuffer.wrap(imageBuffers[0][0]).order(ByteOrder.LITTLE_ENDIAN);
        ByteBuffer abgr = ByteBuffer.wrap(tmp).order(ByteOrder.BIG_ENDIAN);
        for (int i = 0; i < numPixels; i++) {
            rgba.putInt(abgr.getInt());
        }
    }
    
    @Override
    public byte[] compileTexture(ITexture srcImg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
