package vtsman.runicTrans;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vtsman.runicTrans.items.modItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipes {
public static void init(){
	GameRegistry.addShapedRecipe(new ItemStack(modItems.chalk, 1), " c ", "cgc", " c ", 'c', Item.clay, 'g', Block.gravel);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.enriched, 1), " i ", "ici", " i ", 'i', Item.ingotIron, 'c', modItems.chalk);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.pulse, 1), " r ", "rer", " r ", 'r', Item.redstone, 'e', modItems.enriched);
}
}
