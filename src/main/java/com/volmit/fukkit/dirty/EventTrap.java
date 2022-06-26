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

package com.volmit.fukkit.dirty;

import art.arcane.amulet.functional.Consume;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

@SuppressWarnings("unchecked")
public interface EventTrap extends Listener
{
    static <T extends Event> void once(Class<T> event, Consume.One<T> latch)
    {
        once(event, EventPriority.NORMAL, latch);
    }

    static <T extends Event> void once(Class<T> event, EventPriority p, Consume.One<T> latch)
    {
        Listener bait = new EventTrap() {};
        Bukkit.getPluginManager().registerEvent(event, bait, p, (listener, event1) -> {
            latch.accept((T) event1);
            HandlerList.unregisterAll(bait);
        }, Bukkit.getPluginManager().anyPlugin());
    }

    static <T extends Event> Listener listen(Class<T> event, Consume.One<T> latch)
    {
        return listen(event, EventPriority.NORMAL, latch);
    }

    static <T extends Event> Listener listen(Class<T> event, EventPriority p, Consume.One<T> latch)
    {
        Listener bait = new EventTrap() {};
        Bukkit.getPluginManager().registerEvent(event, bait, p, (listener, event1) -> {
            latch.accept((T) event1);
        }, Bukkit.getPluginManager().anyPlugin());
        return bait;
    }
}
