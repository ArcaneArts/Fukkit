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

package Fukkit.extensions.org.bukkit.entity.LivingEntity;

import com.volmit.fukkit.builders.PotionApplier;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffectType;

@Extension
public class XLivingEntity {
  public static Block targetBlock(@This LivingEntity self) {
    return self.getTargetBlockExact(256);
  }

  public static Block targetBlock(@This LivingEntity self, int max) {
    return self.getTargetBlockExact(max);
  }

  public static PotionApplier potion(@This LivingEntity self) {
    return new PotionApplier(self);
  }

  public static PotionApplier blind(@This LivingEntity self) {
    return new PotionApplier(self).type(PotionEffectType.BLINDNESS);
  }

  public static PotionApplier poison(@This LivingEntity self) {
    return new PotionApplier(self).type(PotionEffectType.POISON);
  }

  public static PotionApplier confusion(@This LivingEntity self) {
    return new PotionApplier(self).type(PotionEffectType.CONFUSION);
  }

  public static PotionApplier nightVision(@This LivingEntity self) {
    return new PotionApplier(self).type(PotionEffectType.NIGHT_VISION);
  }
}