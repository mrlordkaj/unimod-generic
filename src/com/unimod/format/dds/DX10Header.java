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

import com.openitvn.unicore.data.DataStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 *
 * @author Thinh Pham
 */
public class DX10Header {
    protected DX10PixelFormat dxgiFormat;
    protected DX10ResourceDimension resourceDimension;
    protected int miscFlag;
    protected int arraySize;
    protected int miscFlags2;
    
    protected DX10Header() {
        dxgiFormat = DX10PixelFormat.DXGI_FORMAT_UNKNOWN;
        resourceDimension = DX10ResourceDimension.D3D10_RESOURCE_DIMENSION_UNKNOWN;
    }
    
    protected DX10Header(DataStream ds) {
        dxgiFormat = DX10PixelFormat.fromValue(ds.getInt());
        resourceDimension = DX10ResourceDimension.fromValue(ds.getInt());
        miscFlag = ds.getInt();
        arraySize = ds.getInt();
        miscFlags2 = ds.getInt();
    }
    
    void writeTo(ByteBuffer bb) {
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putInt(dxgiFormat.value);
        bb.putInt(resourceDimension.value);
        bb.putInt(miscFlag);
        bb.putInt(arraySize);
        bb.putInt(miscFlags2);
    }
}
