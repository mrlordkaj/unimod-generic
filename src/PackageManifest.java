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


import com.unimod.format.dds.DDSTexturePack;
import com.unimod.format.obj.ObjWorld;
import com.openitvn.unicore.plugin.FileType;
import com.openitvn.unicore.plugin.PanelLocation;
import com.openitvn.unicore.plugin.PluginManifest;
import com.unimod.plugin.panel.TestPanel;

/**
 *
 * @author Thinh Pham
 */
public final class PackageManifest extends PluginManifest {
    
    public PackageManifest() {
        // TODO: define your supported file extensions here
        putFileView("DirectDraw Surface", loadIcon("/_dds.png"), FileType.Texture, DDSTexturePack.class, "dds");
        putFileView("Wavefront OBJ",      loadIcon("/_obj.png"), FileType.World,   ObjWorld.class,       "obj");
        
        // TODO: define your custom control panel here
        putControlPanel("Test", PanelLocation.Sidebar, TestPanel.class, true);
    }

    @Override
    public String getId() {
        // TODO: define package identity here
        return "com.unimod.generic";
    }

    @Override
    public String getName() {
        // TODO: define package name here
        return "Unimod Generic";
    }

    @Override
    public String getVersion() {
        // TODO: define package version here
        return "1.0.0";
    }
}
