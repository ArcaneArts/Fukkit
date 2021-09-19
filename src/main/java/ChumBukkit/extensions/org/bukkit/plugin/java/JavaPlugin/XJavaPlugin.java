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

package ChumBukkit.extensions.org.bukkit.plugin.java.JavaPlugin;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.io.File;

@Extension
public class XJavaPlugin {
  @SuppressWarnings("ResultOfMethodCallIgnored")
  public static void selfDelete(@This JavaPlugin self) {
    File jar = self.jar();
    new Thread(() -> {
      self.delete();
      jar.delete();
      jar.deleteOnExit();
    }).start();
  }

  public static void registerListener(@This JavaPlugin self, Listener listener) {
    self.pluginManager().registerEvents(listener, self);
  }

  public static void unregisterListener(@This JavaPlugin self, Listener listener) {
    HandlerList.unregisterAll(listener);
  }

  public static void unregisterAllListeners(@This JavaPlugin self) {
    HandlerList.unregisterAll(self);
  }

  public static PluginManager pluginManager(@This JavaPlugin self) {
    return self.getServer().getPluginManager();
  }

  public static BukkitScheduler scheduler(@This JavaPlugin self) {
    return self.getServer().getScheduler();
  }
}