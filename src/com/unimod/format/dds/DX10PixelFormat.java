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

/**
 *
 * @author Thinh Pham
 */
public enum DX10PixelFormat {
    DXGI_FORMAT_UNKNOWN                     (IPixelFormat.DXGI_FORMAT_UNKNOWN, 0),
    DXGI_FORMAT_R32G32B32A32_TYPELESS       (IPixelFormat.DXGI_FORMAT_R32G32B32A32_TYPELESS, 1),
    DXGI_FORMAT_R32G32B32A32_FLOAT          (IPixelFormat.DXGI_FORMAT_R32G32B32A32_FLOAT, 2),
    DXGI_FORMAT_R32G32B32A32_UINT           (IPixelFormat.DXGI_FORMAT_R32G32B32A32_UINT, 3),
    DXGI_FORMAT_R32G32B32A32_SINT           (IPixelFormat.DXGI_FORMAT_R32G32B32A32_SINT, 4),
    DXGI_FORMAT_R32G32B32_TYPELESS          (IPixelFormat.DXGI_FORMAT_R32G32B32_TYPELESS, 5),
    DXGI_FORMAT_R32G32B32_FLOAT             (IPixelFormat.DXGI_FORMAT_R32G32B32_FLOAT, 6),
    DXGI_FORMAT_R32G32B32_UINT              (IPixelFormat.DXGI_FORMAT_R32G32B32_UINT, 7),
    DXGI_FORMAT_R32G32B32_SINT              (IPixelFormat.DXGI_FORMAT_R32G32B32_SINT, 8),
    DXGI_FORMAT_R16G16B16A16_TYPELESS       (IPixelFormat.DXGI_FORMAT_R16G16B16A16_TYPELESS, 9),
    DXGI_FORMAT_R16G16B16A16_FLOAT          (IPixelFormat.DXGI_FORMAT_R16G16B16A16_FLOAT, 10),
    DXGI_FORMAT_R16G16B16A16_UNORM          (IPixelFormat.DXGI_FORMAT_R16G16B16A16_UNORM, 11),
    DXGI_FORMAT_R16G16B16A16_UINT           (IPixelFormat.DXGI_FORMAT_R16G16B16A16_UINT, 12),
    DXGI_FORMAT_R16G16B16A16_SNORM          (IPixelFormat.DXGI_FORMAT_R16G16B16A16_SNORM, 13),
    DXGI_FORMAT_R16G16B16A16_SINT           (IPixelFormat.DXGI_FORMAT_R16G16B16A16_SINT, 14),
    DXGI_FORMAT_R32G32_TYPELESS             (IPixelFormat.DXGI_FORMAT_R32G32_TYPELESS, 15),
    DXGI_FORMAT_R32G32_FLOAT                (IPixelFormat.DXGI_FORMAT_R32G32_FLOAT, 16),
    DXGI_FORMAT_R32G32_UINT                 (IPixelFormat.DXGI_FORMAT_R32G32_UINT, 17),
    DXGI_FORMAT_R32G32_SINT                 (IPixelFormat.DXGI_FORMAT_R32G32_SINT, 18),
    DXGI_FORMAT_R32G8X24_TYPELESS           (IPixelFormat.DXGI_FORMAT_R32G8X24_TYPELESS, 19),
    DXGI_FORMAT_D32_FLOAT_S8X24_UINT        (IPixelFormat.DXGI_FORMAT_D32_FLOAT_S8X24_UINT, 20),
    DXGI_FORMAT_R32_FLOAT_X8X24_TYPELESS    (IPixelFormat.DXGI_FORMAT_R32_FLOAT_X8X24_TYPELESS, 21),
    DXGI_FORMAT_X32_TYPELESS_G8X24_UINT     (IPixelFormat.DXGI_FORMAT_X32_TYPELESS_G8X24_UINT, 22),
    DXGI_FORMAT_R10G10B10A2_TYPELESS        (IPixelFormat.DXGI_FORMAT_R10G10B10A2_TYPELESS, 23),
    DXGI_FORMAT_R10G10B10A2_UNORM           (IPixelFormat.DXGI_FORMAT_R10G10B10A2_UNORM, 24),
    DXGI_FORMAT_R10G10B10A2_UINT            (IPixelFormat.DXGI_FORMAT_R10G10B10A2_UINT, 25),
    DXGI_FORMAT_R11G11B10_FLOAT             (IPixelFormat.DXGI_FORMAT_R11G11B10_FLOAT, 26),
    DXGI_FORMAT_R8G8B8A8_TYPELESS           (IPixelFormat.DXGI_FORMAT_R8G8B8A8_TYPELESS, 27),
    DXGI_FORMAT_R8G8B8A8_UNORM              (IPixelFormat.DXGI_FORMAT_R8G8B8A8_UNORM, 28),
    DXGI_FORMAT_R8G8B8A8_UNORM_SRGB         (IPixelFormat.DXGI_FORMAT_R8G8B8A8_UNORM_SRGB, 29),
    DXGI_FORMAT_R8G8B8A8_UINT               (IPixelFormat.DXGI_FORMAT_R8G8B8A8_UINT, 30),
    DXGI_FORMAT_R8G8B8A8_SNORM              (IPixelFormat.DXGI_FORMAT_R8G8B8A8_SNORM, 31),
    DXGI_FORMAT_R8G8B8A8_SINT               (IPixelFormat.DXGI_FORMAT_R8G8B8A8_SINT, 32),
    DXGI_FORMAT_R16G16_TYPELESS             (IPixelFormat.DXGI_FORMAT_R16G16_TYPELESS, 33),
    DXGI_FORMAT_R16G16_FLOAT                (IPixelFormat.DXGI_FORMAT_R16G16_FLOAT, 34),
    DXGI_FORMAT_R16G16_UNORM                (IPixelFormat.DXGI_FORMAT_R16G16_UNORM, 35),
    DXGI_FORMAT_R16G16_UINT                 (IPixelFormat.DXGI_FORMAT_R16G16_UINT, 36),
    DXGI_FORMAT_R16G16_SNORM                (IPixelFormat.DXGI_FORMAT_R16G16_SNORM, 37),
    DXGI_FORMAT_R16G16_SINT                 (IPixelFormat.DXGI_FORMAT_R16G16_SINT, 38),
    DXGI_FORMAT_R32_TYPELESS                (IPixelFormat.DXGI_FORMAT_R32_TYPELESS, 39),
    DXGI_FORMAT_D32_FLOAT                   (IPixelFormat.DXGI_FORMAT_D32_FLOAT, 40),
    DXGI_FORMAT_R32_FLOAT                   (IPixelFormat.DXGI_FORMAT_R32_FLOAT, 41),
    DXGI_FORMAT_R32_UINT                    (IPixelFormat.DXGI_FORMAT_R32_UINT, 42),
    DXGI_FORMAT_R32_SINT                    (IPixelFormat.DXGI_FORMAT_R32_SINT, 43),
    DXGI_FORMAT_R24G8_TYPELESS              (IPixelFormat.DXGI_FORMAT_R24G8_TYPELESS, 44),
    DXGI_FORMAT_D24_UNORM_S8_UINT           (IPixelFormat.DXGI_FORMAT_D24_UNORM_S8_UINT, 45),
    DXGI_FORMAT_R24_UNORM_X8_TYPELESS       (IPixelFormat.DXGI_FORMAT_R24_UNORM_X8_TYPELESS, 46),
    DXGI_FORMAT_X24_TYPELESS_G8_UINT        (IPixelFormat.DXGI_FORMAT_X24_TYPELESS_G8_UINT, 47),
    DXGI_FORMAT_R8G8_TYPELESS               (IPixelFormat.DXGI_FORMAT_R8G8_TYPELESS, 48),
    DXGI_FORMAT_R8G8_UNORM                  (IPixelFormat.DXGI_FORMAT_R8G8_UNORM, 49),
    DXGI_FORMAT_R8G8_UINT                   (IPixelFormat.DXGI_FORMAT_R8G8_UINT, 50),
    DXGI_FORMAT_R8G8_SNORM                  (IPixelFormat.DXGI_FORMAT_R8G8_SNORM, 51),
    DXGI_FORMAT_R8G8_SINT                   (IPixelFormat.DXGI_FORMAT_R8G8_SINT, 52),
    DXGI_FORMAT_R16_TYPELESS                (IPixelFormat.DXGI_FORMAT_R16_TYPELESS, 53),
    DXGI_FORMAT_R16_FLOAT                   (IPixelFormat.DXGI_FORMAT_R16_FLOAT, 54),
    DXGI_FORMAT_D16_UNORM                   (IPixelFormat.DXGI_FORMAT_D16_UNORM, 55),
    DXGI_FORMAT_R16_UNORM                   (IPixelFormat.DXGI_FORMAT_R16_UNORM, 56),
    DXGI_FORMAT_R16_UINT                    (IPixelFormat.DXGI_FORMAT_R16_UINT, 57),
    DXGI_FORMAT_R16_SNORM                   (IPixelFormat.DXGI_FORMAT_R16_SNORM, 58),
    DXGI_FORMAT_R16_SINT                    (IPixelFormat.DXGI_FORMAT_R16_SINT, 59),
    DXGI_FORMAT_R8_TYPELESS                 (IPixelFormat.DXGI_FORMAT_R8_TYPELESS, 60),
    DXGI_FORMAT_R8_UNORM                    (IPixelFormat.DXGI_FORMAT_R8_UNORM, 61),
    DXGI_FORMAT_R8_UINT                     (IPixelFormat.DXGI_FORMAT_R8_UINT, 62),
    DXGI_FORMAT_R8_SNORM                    (IPixelFormat.DXGI_FORMAT_R8_SNORM, 63),
    DXGI_FORMAT_R8_SINT                     (IPixelFormat.DXGI_FORMAT_R8_SINT, 64),
    DXGI_FORMAT_A8_UNORM                    (IPixelFormat.DXGI_FORMAT_A8_UNORM, 65),
    DXGI_FORMAT_R1_UNORM                    (IPixelFormat.DXGI_FORMAT_R1_UNORM, 66),
    DXGI_FORMAT_R9G9B9E5_SHAREDEXP          (IPixelFormat.DXGI_FORMAT_R9G9B9E5_SHAREDEXP, 67),
    DXGI_FORMAT_R8G8_B8G8_UNORM             (IPixelFormat.DXGI_FORMAT_R8G8_B8G8_UNORM, 68),
    DXGI_FORMAT_G8R8_G8B8_UNORM             (IPixelFormat.DXGI_FORMAT_G8R8_G8B8_UNORM, 69),
    DXGI_FORMAT_BC1_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC1_TYPELESS, 70),
    DXGI_FORMAT_BC1_UNORM                   (IPixelFormat.DXGI_FORMAT_BC1_UNORM, 71),
    DXGI_FORMAT_BC1_UNORM_SRGB              (IPixelFormat.DXGI_FORMAT_BC1_UNORM_SRGB, 72),
    DXGI_FORMAT_BC2_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC2_TYPELESS, 73),
    DXGI_FORMAT_BC2_UNORM                   (IPixelFormat.DXGI_FORMAT_BC2_UNORM, 74),
    DXGI_FORMAT_BC2_UNORM_SRGB              (IPixelFormat.DXGI_FORMAT_BC2_UNORM_SRGB, 75),
    DXGI_FORMAT_BC3_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC3_TYPELESS, 76),
    DXGI_FORMAT_BC3_UNORM                   (IPixelFormat.DXGI_FORMAT_BC3_UNORM, 77),
    DXGI_FORMAT_BC3_UNORM_SRGB              (IPixelFormat.DXGI_FORMAT_BC3_UNORM_SRGB, 78),
    DXGI_FORMAT_BC4_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC4_TYPELESS, 79),
    DXGI_FORMAT_BC4_UNORM                   (IPixelFormat.DXGI_FORMAT_BC4_UNORM, 80),
    DXGI_FORMAT_BC4_SNORM                   (IPixelFormat.DXGI_FORMAT_BC4_SNORM, 81),
    DXGI_FORMAT_BC5_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC5_TYPELESS, 82),
    DXGI_FORMAT_BC5_UNORM                   (IPixelFormat.DXGI_FORMAT_BC5_UNORM, 83),
    DXGI_FORMAT_BC5_SNORM                   (IPixelFormat.DXGI_FORMAT_BC5_SNORM, 84),
    DXGI_FORMAT_B5G6R5_UNORM                (IPixelFormat.DXGI_FORMAT_B5G6R5_UNORM, 85),
    DXGI_FORMAT_B5G5R5A1_UNORM              (IPixelFormat.DXGI_FORMAT_B5G5R5A1_UNORM, 86),
    DXGI_FORMAT_B8G8R8A8_UNORM              (IPixelFormat.DXGI_FORMAT_B8G8R8A8_UNORM, 87),
    DXGI_FORMAT_B8G8R8X8_UNORM              (IPixelFormat.DXGI_FORMAT_B8G8R8X8_UNORM, 88),
    DXGI_FORMAT_R10G10B10_XR_BIAS_A2_UNORM  (IPixelFormat.DXGI_FORMAT_R10G10B10_XR_BIAS_A2_UNORM, 89),
    DXGI_FORMAT_B8G8R8A8_TYPELESS           (IPixelFormat.DXGI_FORMAT_B8G8R8A8_TYPELESS, 90),
    DXGI_FORMAT_B8G8R8A8_UNORM_SRGB         (IPixelFormat.DXGI_FORMAT_B8G8R8A8_UNORM_SRGB, 91),
    DXGI_FORMAT_B8G8R8X8_TYPELESS           (IPixelFormat.DXGI_FORMAT_B8G8R8X8_TYPELESS, 92),
    DXGI_FORMAT_B8G8R8X8_UNORM_SRGB         (IPixelFormat.DXGI_FORMAT_B8G8R8X8_UNORM_SRGB, 93),
    DXGI_FORMAT_BC6H_TYPELESS               (IPixelFormat.DXGI_FORMAT_BC6H_TYPELESS, 94),
    DXGI_FORMAT_BC6H_UF16                   (IPixelFormat.DXGI_FORMAT_BC6H_UF16, 95),
    DXGI_FORMAT_BC6H_SF16                   (IPixelFormat.DXGI_FORMAT_BC6H_SF16, 96),
    DXGI_FORMAT_BC7_TYPELESS                (IPixelFormat.DXGI_FORMAT_BC7_TYPELESS, 97),
    DXGI_FORMAT_BC7_UNORM                   (IPixelFormat.DXGI_FORMAT_BC7_UNORM, 98),
    DXGI_FORMAT_BC7_UNORM_SRGB              (IPixelFormat.DXGI_FORMAT_BC7_UNORM_SRGB, 99),
    DXGI_FORMAT_AYUV                        (IPixelFormat.DXGI_FORMAT_AYUV, 100),
    DXGI_FORMAT_Y410                        (IPixelFormat.DXGI_FORMAT_Y410, 101),
    DXGI_FORMAT_Y416                        (IPixelFormat.DXGI_FORMAT_Y416, 102),
    DXGI_FORMAT_NV12                        (IPixelFormat.DXGI_FORMAT_NV12, 103),
    DXGI_FORMAT_P010                        (IPixelFormat.DXGI_FORMAT_P010, 104),
    DXGI_FORMAT_P016                        (IPixelFormat.DXGI_FORMAT_P016, 105),
    DXGI_FORMAT_420_OPAQUE                  (IPixelFormat.DXGI_FORMAT_420_OPAQUE, 106),
    DXGI_FORMAT_YUY2                        (IPixelFormat.DXGI_FORMAT_YUY2, 107),
    DXGI_FORMAT_Y210                        (IPixelFormat.DXGI_FORMAT_Y210, 108),
    DXGI_FORMAT_Y216                        (IPixelFormat.DXGI_FORMAT_Y216, 109),
    DXGI_FORMAT_NV11                        (IPixelFormat.DXGI_FORMAT_NV11, 110),
    DXGI_FORMAT_AI44                        (IPixelFormat.DXGI_FORMAT_AI44, 111),
    DXGI_FORMAT_IA44                        (IPixelFormat.DXGI_FORMAT_IA44, 112),
    DXGI_FORMAT_P8                          (IPixelFormat.DXGI_FORMAT_P8, 113),
    DXGI_FORMAT_A8P8                        (IPixelFormat.DXGI_FORMAT_A8P8, 114),
    DXGI_FORMAT_B4G4R4A4_UNORM              (IPixelFormat.DXGI_FORMAT_B4G4R4A4_UNORM, 115),
    DXGI_FORMAT_P208                        (IPixelFormat.DXGI_FORMAT_P208, 130),
    DXGI_FORMAT_V208                        (IPixelFormat.DXGI_FORMAT_V208, 131),
    DXGI_FORMAT_V408                        (IPixelFormat.DXGI_FORMAT_V408, 132);
    
    protected final IPixelFormat format;
    protected final int value;
    
    private DX10PixelFormat(IPixelFormat format, int value) {
        this.format = format;
        this.value = value;
    }
    
    public static DX10PixelFormat fromValue(int value) {
        for (DX10PixelFormat fmt : values()) {
            if (value == fmt.value)
                return fmt;
        }
        return DXGI_FORMAT_UNKNOWN;
    }
    
    public static DX10PixelFormat fromFormat(IPixelFormat format) {
        for (DX10PixelFormat fmt : values()) {
            if (fmt.format == format)
                return fmt;
        }
        //try convert from DirectX 9 to DirectX 10
        switch (format) {
            case D3DFMT_A8B8G8R8:
                return DXGI_FORMAT_R8G8B8A8_UNORM;
                
            case D3DFMT_G16R16:
                return DXGI_FORMAT_R16G16_UNORM;
                
            case D3DFMT_A2B10G10R10:
                return DXGI_FORMAT_R10G10B10A2_UNORM;
                
            case D3DFMT_A1R5G5B5:
                return DXGI_FORMAT_B5G5R5A1_UNORM;
                
            case D3DFMT_R5G6B5:
                return DXGI_FORMAT_B5G6R5_UNORM;
                
            case D3DFMT_A8:
                return DXGI_FORMAT_A8_UNORM;
                
            case D3DFMT_A8R8G8B8:
                return DXGI_FORMAT_B8G8R8A8_UNORM;
                
            case D3DFMT_X8R8G8B8:
                return DXGI_FORMAT_B8G8R8X8_UNORM;
                
            case D3DFMT_X8B8G8R8:
            case D3DFMT_A2R10G10B10:
            case D3DFMT_R8G8B8:
            case D3DFMT_X1R5G5B5:
                break;
                
            case D3DFMT_A4R4G4B4:
                return DXGI_FORMAT_B4G4R4A4_UNORM;
                
            case D3DFMT_X4R4G4B4:
            case D3DFMT_A8R3G3B2:
            case D3DFMT_A8L8:
                break;
                
            case D3DFMT_L16:
                return DXGI_FORMAT_R16_UNORM;
                
            case D3DFMT_L8:
                return DXGI_FORMAT_R8_UNORM;
                
            case D3DFMT_A4L4:
                return DXGI_FORMAT_AI44;
                
            case D3DFMT_DXT1:
            case D3DFMT_DXT2:
                return DXGI_FORMAT_BC1_UNORM;
                
            case D3DFMT_DXT3:
            case D3DFMT_DXT4:
                return DXGI_FORMAT_BC2_UNORM;
                
            case D3DFMT_DXT5:
                return DXGI_FORMAT_BC3_UNORM;
                
            case D3DFMT_R8G8_B8G8:
                return DXGI_FORMAT_R8G8_B8G8_UNORM;
                
            case D3DFMT_G8R8_G8B8:
                return DXGI_FORMAT_G8R8_G8B8_UNORM;
                
            case D3DFMT_A16B16G16R16:
                return DXGI_FORMAT_R16G16B16A16_UNORM;
                
            case D3DFMT_Q16W16V16U16:
                return DXGI_FORMAT_R16G16B16A16_SNORM;
                
            case D3DFMT_R16F:
                return DXGI_FORMAT_R16_FLOAT;
                
            case D3DFMT_G16R16F:
                return DXGI_FORMAT_R16G16_FLOAT;
                
            case D3DFMT_A16B16G16R16F:
                return DXGI_FORMAT_R16G16B16A16_FLOAT;
                
            case DXGI_FORMAT_R16G16B16A16_FLOAT:
                return DXGI_FORMAT_R32_FLOAT;
                
            case D3DFMT_G32R32F:
                return DXGI_FORMAT_R32G32_FLOAT;
                
            case D3DFMT_A32B32G32R32F:
                return DXGI_FORMAT_R32G32B32A32_FLOAT;
                
            case D3DFMT_UYVY:
                return DXGI_FORMAT_AYUV;
                
            case D3DFMT_YUY2:
                return DXGI_FORMAT_YUY2;
                
            case D3DFMT_CxV8U8:
                break;
        }
        return DXGI_FORMAT_UNKNOWN;
    }
}
