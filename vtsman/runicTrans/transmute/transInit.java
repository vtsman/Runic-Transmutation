package vtsman.runicTrans.transmute;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class transInit {
	public static void init() {
		transmuteManager.add(4, new ItemStack(Block.cobblestone, 1, 0));
		transmuteManager.add(4, new ItemStack(Block.dirt, 1, 0));
		transmuteManager.add(4, new ItemStack(Block.sand, 1, 0));
		transmuteManager.add(64, new ItemStack(Block.wood, 1, 0));
		transmuteManager.add(64, new ItemStack(Block.wood, 1, 1));
		transmuteManager.add(64, new ItemStack(Block.wood, 1, 2));
		transmuteManager.add(64, new ItemStack(Block.wood, 1, 3));
		transmuteManager.add(16, new ItemStack(Block.planks, 1, 0));
		transmuteManager.add(16, new ItemStack(Block.planks, 1, 1));
		transmuteManager.add(16, new ItemStack(Block.planks, 1, 2));
		transmuteManager.add(16, new ItemStack(Block.planks, 1, 3));
		transmuteManager.add(6, new ItemStack(Block.plantRed, 1, 0));
		transmuteManager.add(6, new ItemStack(Block.plantYellow, 1, 0));
	}
}
