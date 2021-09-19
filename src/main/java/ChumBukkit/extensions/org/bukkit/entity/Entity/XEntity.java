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

package ChumBukkit.extensions.org.bukkit.entity.Entity;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.entity.Entity;

@Extension
public class XEntity {
  public static void explode(@This Entity self, float power, boolean breakBlocks) {
    self.getWorld().createExplosion(self.getLocation(), power, false, breakBlocks);
  }
  
  public static void explode(@This Entity self) {
    self.explode(3f, false);
  }
}