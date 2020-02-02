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
package com.openitvn.format.dds;

import com.openitvn.unicore.data.DataStream;
import com.openitvn.maintain.DumpEntry;
import com.openitvn.unicore.world.resource.ITexture;
import com.openitvn.unicore.world.resource.ITexturePack;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Thinh Pham
 */
public class DDSTexturePack extends ITexturePack {
    
    @Override
    public void fromSource(ITexturePack src) throws UnsupportedOperationException {
        try {
            DDSTexture tex = new DDSTexture();
            tex.replace(src.textures.get(0));
            addTexture(tex);
        } catch(IndexOutOfBoundsException ex) {
            throw new UnsupportedOperationException("Can't copy from empty source file.");
        }
    }
    
    @Override
    public void decode(DataStream ds) {
        super.addTexture(new DDSTexture(ds));
    }
    
    @Override
    public Collection<DumpEntry> dump(DataStream ds) {
        return new ArrayList();
    }

    @Override
    public byte[] unwrap() {
        return textures.get(0).unwrap();
    }
    
    @Override
    public void addTexture(ITexture tex) {
        if (textures.size() > 0)
            throw new UnsupportedOperationException("DDS Texture format does not support array operations.");
        else
            super.addTexture(tex);
    }
}
