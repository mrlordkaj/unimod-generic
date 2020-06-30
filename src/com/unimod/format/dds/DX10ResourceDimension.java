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

/**
 *
 * @author Thinh Pham
 */
public enum DX10ResourceDimension {
    D3D10_RESOURCE_DIMENSION_UNKNOWN    (0),
    D3D10_RESOURCE_DIMENSION_BUFFER     (1),
    D3D10_RESOURCE_DIMENSION_TEXTURE1D  (2),
    D3D10_RESOURCE_DIMENSION_TEXTURE2D  (3),
    D3D10_RESOURCE_DIMENSION_TEXTURE3D  (4);
    
    protected final int value;
    
    private DX10ResourceDimension(int value) {
        this.value = value;
    }
    
    protected static DX10ResourceDimension fromValue(int value) {
        for (DX10ResourceDimension dim : values()) {
            if (value == dim.value)
                return dim;
        }
        return D3D10_RESOURCE_DIMENSION_UNKNOWN;
    }
}
