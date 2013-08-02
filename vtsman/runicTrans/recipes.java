package vtsman.runicTrans;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipes {
public static void init(){
	GameRegistry.addShapedRecipe(new ItemStack(modItems.chalk, 1), " c ", "cgc", " c ", 'c', Item.clay, 'g', Block.gravel);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.enriched, 1), " i ", "ici", " i ", 'i', Item.ingotIron, 'c', modItems.chalk);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.pulse, 1), " r ", "rer", " r ", 'r', Item.redstone, 'e', modItems.enriched);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.dull, 1), "ioi", "idi", "ioi", 'i', Item.ingotIron, 'o', Block.obsidian, 'd', modItems.infused);
	GameRegistry.addShapedRecipe(new ItemStack(modBlocks.cap, 1), "gig", "did", "gig", 'g', Block.glowStone, 'i', modItems.infused, 'd', Item.diamond);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.enlight, 1), "ggg", "bfb", "ggg", 'g', Item.glowstone, 'f', modItems.forge, 'b', Item.book);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.forge, 1), " a ", "cpc", " a ", 'a', Block.anvil, 'c', Block.workbench, 'p', modItems.pulse);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.eStone, 1), " e ", "ede", " e ", 'd', Item.diamond, 'e', modItems.enlight);
	GameRegistry.addShapedRecipe(new ItemStack(modBlocks.chargeNode, 1), " e ", " o ", "oeo", 'o', Block.obsidian, 'e', modItems.enriched);
}
}
