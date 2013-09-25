package vtsman.runicTrans.TE;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import vtsman.runicTrans.stackUtils;
import vtsman.runicTrans.aspect.AspectRegistry;
import vtsman.runicTrans.items.mixedDust;
import vtsman.runicTrans.items.modItems;

public class recipe_mortar {
	public static List<IMorter> recipes = new ArrayList<IMorter>();

	public static ItemStack getStack(ItemStack[] stack) {
		if (recipes.size() > 0) {
			for (int i = 0; i < recipes.size(); i++) {
				IMorter m = recipes.get(i);
				if (m != null) {
					if (m.canCraft(stack)) {
						return m.getResult(stack);
					}
				}
			}
		}

		if (AspectRegistry.allAspect(stack)
				&& stackUtils.getNonNull(stack).length != 0) {
			ItemStack out = new ItemStack(modItems.mixDust, 1);
			out.stackTagCompound = new NBTTagCompound();
			mixedDust.writeToNBT(out.stackTagCompound,
					stackUtils.setOne(stackUtils.getNonNull(stack)));
			return out;
		}
		return null;
	}

	public static void init() {
		recipes.add(new shapelessMortar(new ItemStack(modItems.pulse, 1),
				new ItemStack(Item.redstone, 1),
				new ItemStack(Item.redstone, 1),
				new ItemStack(Item.redstone, 1),
				new ItemStack(Item.redstone, 1), new ItemStack(
						modItems.enriched, 1)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.chalk, 1),
				new ItemStack(Item.clay, 1), new ItemStack(Item.clay, 1),
				new ItemStack(Item.clay, 1), new ItemStack(Item.clay, 1),
				new ItemStack(Block.gravel, 1)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.dark, 1),
				new ItemStack(Item.magmaCream, 1), new ItemStack(
						Item.magmaCream, 1), new ItemStack(Item.magmaCream, 1),
				new ItemStack(Item.magmaCream, 1), new ItemStack(
						modItems.infused, 1)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.sorce, 1),
				new ItemStack(Block.blockDiamond, 1), new ItemStack(
						Item.netherStar, 1), new ItemStack(modItems.myst)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.forge, 1),
				new ItemStack(Block.anvil, 1),
				new ItemStack(Item.bucketLava, 1), new ItemStack(
						modItems.pulse, 1)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.enlight, 1),
				new ItemStack(Block.glowStone, 1), new ItemStack(
						Block.glowStone, 1), new ItemStack(Block.glowStone, 1),
				new ItemStack(modItems.forge, 1)));
		recipes.add(new shapelessMortar(new ItemStack(modItems.enriched, 1),
				new ItemStack(Item.ingotIron, 1), new ItemStack(Item.ingotIron,
						1), new ItemStack(Item.ingotIron, 1), new ItemStack(
						Item.ingotIron, 1), new ItemStack(modItems.chalk, 1)));
		recipes.add(new shapelessMortar(new ItemStack(Item.glowstone, 4),
				new ItemStack(Block.glowStone)));
		recipes.add(new shapelessMortar(new ItemStack(Block.blockSnow),
				new ItemStack(Block.ice)));
	}
}
