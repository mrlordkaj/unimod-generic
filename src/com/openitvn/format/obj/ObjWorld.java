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
package com.openitvn.format.obj;

import com.openitvn.unicore.data.DataStream;
import com.openitvn.unicore.world.IMesh;
import com.openitvn.unicore.world.IVertex;
import com.openitvn.unicore.world.IWorld;
import java.util.ArrayList;

/**
 *
 * @author Thinh Pham
 */
public class ObjWorld extends IWorld {
    
    private final ArrayList<IVertex> vs = new ArrayList<>();
    private final ArrayList<float[]> vts = new ArrayList<>();
    private final ArrayList<float[]> vns = new ArrayList<>();
    
    @Override
    public void fromData(DataStream ds) {
        ArrayList<IMesh> meshes = new ArrayList<>();
        String line;
        while ((line = ds.readLine()) != null) {
            String[] args = line.trim().split("[\\s]+");
            switch (args[0]) {
                case "v":
                    IVertex v = new IVertex(
                            Float.parseFloat(args[0]),
                            Float.parseFloat(args[1]),
                            Float.parseFloat(args[2]));
                    vs.add(v);
                    break;
                    
                case "vt":
                    float[] vt = new float[args.length - 1];
                    for (int i = 0; i < vt.length; i++)
                        vt[i] = Float.parseFloat(args[i + 1]);
                    vts.add(vt);
                    break;
                    
                case "vn":
                    float[] vn = new float[args.length - 1];
                    for (int i = 0; i < vn.length; i++)
                        vn[i] = Float.parseFloat(args[i + 1]);
                    vns.add(vn);
                    break;
                    
                case "g":
                    IMesh m = parseMesh(ds);
//                    m.name = args[1];
                    meshes.add(m);
                    break;
            }
        }
    }
    
    private IMesh parseMesh(DataStream ds) {
        IMesh mesh = new IMesh();
        String line;
        while ((line = ds.readLine()) != null) {
            String[] args = line.trim().split("[\\s]+");
            switch (args[0]) {
                case "f":
                    for (int i = 0; i < 3; i++) {
                        String[] coms = args[i + 1].split("/");
                        short index = (short)(Short.decode(coms[0]) - 1);
                        
                    }
                    break;
            }
        }
        return mesh;
    }
}
