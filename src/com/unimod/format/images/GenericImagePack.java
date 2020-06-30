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
import com.openitvn.unicore.world.resource.ITexturePack;
import java.io.IOException;

/**
 *
 * @author Thinh Pham
 */
public class GenericImagePack extends ITexturePack {

    @Override
    public void decode(DataStream ds) {
        try {
            textures.add(new GenericImage(ds));
        } catch (IOException ex) {
            throw new UnsupportedOperationException(ex);
        }
    }

    @Override
    public byte[] encode() {
        return new byte[0];
    }
    
}
