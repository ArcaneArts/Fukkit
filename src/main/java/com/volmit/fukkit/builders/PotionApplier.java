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

package com.volmit.fukkit.builders;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;
import manifold.ext.rt.api.Self;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Data
@Accessors(chain = true, fluent = true)
@Getter(AccessLevel.NONE)
public class PotionApplier {
    private PotionEffectType type;
    private int duration = 200;
    private int amp = 0;
    private boolean ambient = true;
    private boolean particles = false;
    private boolean icon = false;
    private LivingEntity entity;

    public PotionApplier(LivingEntity entity)
    {
        this.entity = entity;
    }

    public @Self PotionApplier forever()
    {
        return duration(Integer.MAX_VALUE);
    }

    public LivingEntity apply()
    {
        entity.addPotionEffect(new PotionEffect(type, duration, amp, ambient, particles, icon));
        return entity;
    }
}
