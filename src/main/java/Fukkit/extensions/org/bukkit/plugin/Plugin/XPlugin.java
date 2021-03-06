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

package Fukkit.extensions.org.bukkit.plugin.Plugin;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;

@Extension
public class XPlugin {
  public static void unload(@This Plugin self) {
    Bukkit.getPluginManager().unload(self);
  }

  public static void delete(@This Plugin self) {
    Bukkit.getPluginManager().delete(self);
  }

  public static File jar(@This Plugin self) {
    return self.getClass().jarFile();
  }
}