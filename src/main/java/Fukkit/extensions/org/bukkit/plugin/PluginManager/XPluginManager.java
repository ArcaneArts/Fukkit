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

package Fukkit.extensions.org.bukkit.plugin.PluginManager;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredListener;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URLClassLoader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

@Extension
public class XPluginManager {
  public static boolean delete(@This PluginManager self, Plugin plugin)
  {
    File file = plugin.jar();
    unload(self, plugin);
    return file.delete();
  }

  public static Plugin anyPlugin(@This PluginManager self)
  {
    return self.getPlugins()[0];
  }

  public static void unload(@This PluginManager self, Plugin plugin) {
    String name = plugin.getName();
    SimpleCommandMap commandMap = null;
    List<Plugin> plugins = null;
    Map<String, Plugin> names = null;
    Map<String, Command> commands = null;
    Map<Event, SortedSet<RegisteredListener>> listeners = null;
    boolean reloadlisteners = true;

    self.disablePlugin(plugin);

    try {

      Field pluginsField = Bukkit.getPluginManager().getClass().getDeclaredField("plugins");
      pluginsField.setAccessible(true);
      plugins = (List<Plugin>) pluginsField.get(self);

      Field lookupNamesField = Bukkit.getPluginManager().getClass().getDeclaredField("lookupNames");
      lookupNamesField.setAccessible(true);
      names = (Map<String, Plugin>) lookupNamesField.get(self);

      try {
        Field listenersField = Bukkit.getPluginManager().getClass().getDeclaredField("listeners");
        listenersField.setAccessible(true);
        listeners = (Map<Event, SortedSet<RegisteredListener>>) listenersField.get(self);
      } catch (Exception e) {
      }

      Field commandMapField = Bukkit.getPluginManager().getClass().getDeclaredField("commandMap");
      commandMapField.setAccessible(true);
      commandMap = (SimpleCommandMap) commandMapField.get(self);

      Field knownCommandsField = SimpleCommandMap.class.getDeclaredField("knownCommands");
      knownCommandsField.setAccessible(true);
      commands = (Map<String, Command>) knownCommandsField.get(commandMap);

    } catch (NoSuchFieldException | IllegalAccessException e) {
      e.printStackTrace();
      return;
    }

    self.disablePlugin(plugin);

    if (plugins != null)
      plugins.remove(plugin);

    if (names != null)
      names.remove(name);

    if (listeners != null) {
      for (SortedSet<RegisteredListener> set : listeners.values()) {
        set.removeIf(value -> value.getPlugin() == plugin);
      }
    }

    if (commandMap != null) {
      for (Iterator<Map.Entry<String, Command>> it = commands.entrySet().iterator(); it.hasNext(); ) {
        Map.Entry<String, Command> entry = it.next();
        if (entry.getValue() instanceof PluginCommand) {
          PluginCommand c = (PluginCommand) entry.getValue();
          if (c.getPlugin() == plugin) {
            c.unregister(commandMap);
            it.remove();
          }
        }
      }
    }

    ClassLoader cl = plugin.getClass().getClassLoader();

    if (cl instanceof URLClassLoader) {
      try {
        ((URLClassLoader) cl).close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    System.gc();
  }
}