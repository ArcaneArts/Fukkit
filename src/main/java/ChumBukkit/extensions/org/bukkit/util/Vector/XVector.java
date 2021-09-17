/*
 * ChumBukkit is an extension api for Minecraft Bukkit Servers
 * Copyright (c) 2021 Arcane Arts (Volmit Software)
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
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ChumBukkit.extensions.org.bukkit.util.Vector;

import art.arcane.amulet.geometry.Vec;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.util.Vector;

@Extension
public abstract class XVector implements Vec {
    public static Vec vec(@This Vector self) {
        return Vec.of(self.x, self.y, self.z);
    }

    public static double x(@This Vector l) {
        return l.getX();
    }

    public static Vector x(@This Vector l, double v) {
        l.setX(v);
        return l;
    }

    public static double y(@This Vector l) {
        return l.getY();
    }

    public static Vector y(@This Vector l, double v) {
        l.setY(v);
        return l;
    }

    public static double z(@This Vector l) {
        return l.getZ();
    }

    public static Vector z(@This Vector l, double v) {
        l.setZ(v);
        return l;
    }

}