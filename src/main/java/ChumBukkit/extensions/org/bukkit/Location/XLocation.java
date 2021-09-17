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

package ChumBukkit.extensions.org.bukkit.Location;

import art.arcane.amulet.geometry.Vec;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Location;

@Extension
public abstract class XLocation implements Vec {
    public static Vec vec(@This Location self) {
        return Vec.of(self.getX(), self.getY(), self.getZ());
    }

    public static double x(@This Location l) {
        return l.getX();
    }

    public static Location x(@This Location l, double v) {
        l.setX(v);
        return l;
    }

    public static double y(@This Location l) {
        return l.getY();
    }

    public static Location y(@This Location l, double v) {
        l.setY(v);
        return l;
    }

    public static double z(@This Location l) {
        return l.getZ();
    }

    public static Location z(@This Location l, double v) {
        l.setZ(v);
        return l;
    }
}