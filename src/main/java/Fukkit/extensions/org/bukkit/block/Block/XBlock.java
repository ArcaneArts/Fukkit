package Fukkit.extensions.org.bukkit.block.Block;

import art.arcane.amulet.geometry.Vec;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;

@Extension
public class XBlock {
    public static Block relativeUp(@This Block self) {
        return self.getRelative(BlockFace.UP);
    }

    public static Block relativeDown(@This Block self) {
        return self.getRelative(BlockFace.DOWN);
    }
}
