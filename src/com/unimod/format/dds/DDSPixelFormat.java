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

import com.openitvn.unicore.world.resource.IPixelFormat;
import com.openitvn.helper.StringHelper;
import com.openitvn.unicore.data.DataStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Thinh Pham
 */
public enum DDSPixelFormat {
    D3DFMT_A8B8G8R8         (IPixelFormat.D3DFMT_A8B8G8R8,       DXHeader.DDS_RGBA,      32, 0x000000ff, 0x0000ff00, 0x00ff0000, 0xff000000),
    D3DFMT_G16R16           (IPixelFormat.D3DFMT_G16R16,         DXHeader.DDS_RGB,       32, 0x0000ffff, 0xffff0000, 0x00000000, 0x00000000),
    D3DFMT_A2B10G10R10      (IPixelFormat.D3DFMT_A2B10G10R10,    DXHeader.DDS_RGBA,      32, 0x000003ff, 0x000ffc00, 0x3ff00000, 0x00000000),
    D3DFMT_A1R5G5B5         (IPixelFormat.D3DFMT_A1R5G5B5,       DXHeader.DDS_RGBA,      16, 0x7c00, 0x03e0, 0x001f, 0x8000),
    D3DFMT_R5G6B5           (IPixelFormat.D3DFMT_R5G6B5,         DXHeader.DDS_RGB,       16, 0xf800, 0x07e0, 0x001f, 0x0000),
    D3DFMT_A8               (IPixelFormat.D3DFMT_A8,             DXHeader.DDS_ALPHA,      8, 0x00, 0x00, 0x00, 0xff),
    D3DFMT_A8R8G8B8         (IPixelFormat.D3DFMT_A8R8G8B8,       DXHeader.DDS_RGBA,      32, 0x00ff0000, 0x0000ff00, 0x000000ff, 0xff000000),
    D3DFMT_X8R8G8B8         (IPixelFormat.D3DFMT_X8R8G8B8,       DXHeader.DDS_RGB,       32, 0x00ff0000, 0x0000ff00, 0x000000ff, 0x00000000),
    D3DFMT_X8B8G8R8         (IPixelFormat.D3DFMT_X8B8G8R8,       DXHeader.DDS_RGB,       32, 0x000000ff, 0x0000ff00, 0x00ff0000, 0x00000000),
    D3DFMT_A2R10G10B10      (IPixelFormat.D3DFMT_A2R10G10B10,    DXHeader.DDS_RGBA,      32, 0x3ff00000, 0x000ffc00, 0x000003ff, 0xc0000000),
    D3DFMT_R8G8B8           (IPixelFormat.D3DFMT_R8G8B8,         DXHeader.DDS_RGB,       24, 0xff0000, 0x00ff00, 0x0000ff, 0x000000),
    D3DFMT_X1R5G5B5         (IPixelFormat.D3DFMT_X1R5G5B5,       DXHeader.DDS_RGBA,      16, 0x7c00, 0x03e0, 0x001f, 0x0000),
    D3DFMT_A4R4G4B4         (IPixelFormat.D3DFMT_A4R4G4B4,       DXHeader.DDS_RGBA,      16, 0x0f00, 0x00f0, 0x000f, 0xf000),
    D3DFMT_X4R4G4B4         (IPixelFormat.D3DFMT_X4R4G4B4,       DXHeader.DDS_RGB,       16, 0x0f00, 0x00f0, 0x000f, 0x0000),
    D3DFMT_A8R3G3B2         (IPixelFormat.D3DFMT_A8R3G3B2,       DXHeader.DDS_RGBA,      16, 0x00e0, 0x001c, 0x0003, 0xff00),
    D3DFMT_A8L8             (IPixelFormat.D3DFMT_A8L8,           DXHeader.DDS_LUMINANCE, 16, 0x00ff, 0x0000, 0x0000, 0xff00),
    D3DFMT_L16              (IPixelFormat.D3DFMT_L16,            DXHeader.DDS_LUMINANCE, 16, 0xffff, 0x0000, 0x0000, 0x0000),
    D3DFMT_L8               (IPixelFormat.D3DFMT_L8,             DXHeader.DDS_LUMINANCE,  8, 0xff, 0x00, 0x00, 0x00),
    D3DFMT_A4L4             (IPixelFormat.D3DFMT_A4L4,           DXHeader.DDS_LUMINANCE,  8, 0x0f, 0x00, 0x00, 0xf0),
    D3DFMT_DXT1             (IPixelFormat.D3DFMT_DXT1,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DXT1")),
    D3DFMT_DXT2             (IPixelFormat.D3DFMT_DXT2,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DXT2")),
    D3DFMT_DXT3             (IPixelFormat.D3DFMT_DXT3,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DXT3")),
    D3DFMT_DXT4             (IPixelFormat.D3DFMT_DXT4,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DXT4")),
    D3DFMT_DXT5             (IPixelFormat.D3DFMT_DXT5,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DXT5")),
    D3DFMT_R8G8_B8G8        (IPixelFormat.D3DFMT_R8G8_B8G8,      DXHeader.DDS_FOURCC, StringHelper.makeFourCC("RGBG")),
    D3DFMT_G8R8_G8B8        (IPixelFormat.D3DFMT_G8R8_G8B8,      DXHeader.DDS_FOURCC, StringHelper.makeFourCC("RGBG")),
    D3DFMT_A16B16G16R16     (IPixelFormat.D3DFMT_A16B16G16R16,   DXHeader.DDS_FOURCC, 36),
    D3DFMT_Q16W16V16U16     (IPixelFormat.D3DFMT_Q16W16V16U16,   DXHeader.DDS_FOURCC, 110),
    D3DFMT_R16F             (IPixelFormat.D3DFMT_R16F,           DXHeader.DDS_FOURCC, 111),
    D3DFMT_G16R16F          (IPixelFormat.D3DFMT_G16R16F,        DXHeader.DDS_FOURCC, 112),
    D3DFMT_A16B16G16R16F    (IPixelFormat.D3DFMT_A16B16G16R16F,  DXHeader.DDS_FOURCC, 113),
    D3DFMT_R32F             (IPixelFormat.D3DFMT_R32F,           DXHeader.DDS_FOURCC, 114),
    D3DFMT_G32R32F          (IPixelFormat.D3DFMT_G32R32F,        DXHeader.DDS_FOURCC, 115),
    D3DFMT_A32B32G32R32F    (IPixelFormat.D3DFMT_A32B32G32R32F,  DXHeader.DDS_FOURCC, 116),
    D3DFMT_UYVY             (IPixelFormat.D3DFMT_UYVY,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("UYVY")),
    D3DFMT_YUY2             (IPixelFormat.D3DFMT_YUY2,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("YUY2")),
    D3DFMT_CxV8U8           (IPixelFormat.D3DFMT_CxV8U8,         DXHeader.DDS_FOURCC, 117),
    D3DFMT_DX10             (IPixelFormat.D3DFMT_DX10,           DXHeader.DDS_FOURCC, StringHelper.makeFourCC("DX10")),
    D3DFMT_UNKNOW;
    
    protected final IPixelFormat format;
    protected final int dwSize = 32;
    protected final int dwFlags;
    protected final int dwFourCC;
    protected final int dwRGBBitCount;
    protected final int dwRBitMask;
    protected final int dwGBitMask;
    protected final int dwBBitMask;
    protected final int dwABitMask;
    
    private DDSPixelFormat(IPixelFormat format, int dwFlags, int dwRGBBitCount, int dwRBitMask, int dwGBitMask, int dwBBitMask, int dwABitMask) {
        this.format = format;
        this.dwFlags = dwFlags;
        this.dwFourCC = 0;
        this.dwRGBBitCount = dwRGBBitCount;
        this.dwRBitMask = dwRBitMask;
        this.dwGBitMask = dwGBitMask;
        this.dwBBitMask = dwBBitMask;
        this.dwABitMask = dwABitMask;
    }
    
    private DDSPixelFormat(IPixelFormat format, int dwFlags, int dwFourCC) {
        this.format = format;
        this.dwFlags = dwFlags;
        this.dwFourCC = dwFourCC;
        this.dwRGBBitCount = 0;
        this.dwRBitMask = 0;
        this.dwGBitMask = 0;
        this.dwBBitMask = 0;
        this.dwABitMask = 0;
    }
    
    private DDSPixelFormat() {
        this.format = IPixelFormat.D3DFMT_UNKNOW;
        this.dwFlags = 0;
        this.dwFourCC = 0;
        this.dwRGBBitCount = 0;
        this.dwRBitMask = 0;
        this.dwGBitMask = 0;
        this.dwBBitMask = 0;
        this.dwABitMask = 0;
    }
    
    public byte[] toBuffer() {
        ByteBuffer data = ByteBuffer.allocate(dwSize).order(ByteOrder.LITTLE_ENDIAN);
        data.putInt(dwSize);
        data.putInt(dwFlags);
        data.putInt(dwFourCC);
        data.putInt(dwRGBBitCount);
        data.putInt(dwRBitMask);
        data.putInt(dwGBitMask);
        data.putInt(dwBBitMask);
        data.putInt(dwABitMask);
        return data.array();
    }
    
    public static DDSPixelFormat fromData(DataStream ds) {
        int dwSize = ds.getInt();
        int dwFlags = ds.getInt();
        int dwFourCC = ds.getInt();
        int dwRGBBitCount = ds.getInt();
        int dwRBitMask = ds.getInt();
        int dwGBitMask = ds.getInt();
        int dwBBitMask = ds.getInt();
        int dwABitMask = ds.getInt();
        
        switch (dwFlags) {
            case DXHeader.DDS_FOURCC:
                for (DDSPixelFormat fmt : values()) {
                    if (dwFourCC == fmt.dwFourCC)
                        return fmt;
                }
                break;
            
            case DXHeader.DDS_RGB:
            case DXHeader.DDS_RGBA:
                for (DDSPixelFormat fmt : values()) {
                    if (dwRGBBitCount == fmt.dwRGBBitCount && dwRBitMask == fmt.dwRBitMask && dwGBitMask == fmt.dwGBitMask && dwBBitMask == fmt.dwBBitMask && dwABitMask == fmt.dwABitMask)
                        return fmt;
                }
                break;
                
            case DXHeader.DDS_ALPHA:
                for (DDSPixelFormat fmt : values()) {
                    if (dwRGBBitCount == fmt.dwRGBBitCount && dwABitMask == fmt.dwABitMask)
                        return fmt;
                }
                break;
                
            case DXHeader.DDS_LUMINANCE:
            case DXHeader.DDS_LUMINANCEA:
                for (DDSPixelFormat fmt : values()) {
                    if (dwRGBBitCount == fmt.dwRGBBitCount && dwRBitMask == fmt.dwRBitMask && dwABitMask == fmt.dwABitMask)
                        return fmt;
                }
                break;
        }
        return DDSPixelFormat.D3DFMT_UNKNOW;
    }
    
    public static DDSPixelFormat fromFormat(IPixelFormat format) {
        for (DDSPixelFormat fmt : values()) {
            if (fmt.format == format)
                return fmt;
        }
        return DDSPixelFormat.D3DFMT_UNKNOW;
    }
}
