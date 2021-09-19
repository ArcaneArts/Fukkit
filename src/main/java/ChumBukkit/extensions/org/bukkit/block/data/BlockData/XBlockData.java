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

package ChumBukkit.extensions.org.bukkit.block.data.BlockData;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Waterlogged;

@Extension
public class XBlockData {
  public static boolean isAir(@This BlockData self) {
    return self.getMaterial().isAir();
  }

  /**
   * Strip all custom properties (copy)
   * @return the stripped copy
   */
  public static BlockData strip(@This BlockData self) {
    return self.getMaterial().createBlockData();
  }

  public static boolean isWater(@This BlockData self) {
    return self.getMaterial().equals(Material.WATER);
  }

  public static boolean isLava(@This BlockData self) {
    return self.getMaterial().equals(Material.LAVA);
  }

  public static boolean isFluid(@This BlockData self) {
    return self.getMaterial().equals(Material.WATER) || self.getMaterial().equals(Material.LAVA);
  }

  public static boolean isWaterLogged(@This BlockData self) {
    return self instanceof Waterlogged && ((Waterlogged)self).isWaterlogged();
  }
}