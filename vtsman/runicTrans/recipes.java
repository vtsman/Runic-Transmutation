package vtsman.runicTrans;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class recipes {
public static void init(){
	GameRegistry.addShapedRecipe(new ItemStack(modItems.chalk, 1), " c ", "cgc", " c ", 'c', Item.clay, 'g', Block.gravel);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.enriched, 1), " i ", "ici", " i ", 'i', Item.ingotIron, 'c', modItems.chalk);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.pulse, 1), " r ", "rer", " r ", 'r', Item.redstone, 'e', modItems.enriched);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.dull, 1), "ioi", "idi", "ioi", 'i', Item.ingotIron, 'o', Block.obsidian, 'd', modItems.infused);
	GameRegistry.addShapedRecipe(new ItemStack(modBlocks.cap, 1), "gig", "did", "gig", 'g', Block.glowStone, 'i', modItems.pulse, 'd', Item.diamond);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.enlight, 1), "ggg", "bfb", "ggg", 'g', Item.glowstone, 'f', modItems.forge, 'b', Item.book);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.forge, 1), " a ", "cpc", " a ", 'a', Block.anvil, 'c', Block.workbench, 'p', modItems.pulse);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.eStone, 1), " e ", "ede", " e ", 'd', Item.diamond, 'e', modItems.enlight);
	GameRegistry.addShapedRecipe(new ItemStack(modBlocks.chargeNode, 1), " e ", " o ", "oeo", 'o', Block.obsidian, 'e', modItems.enriched);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.dark, 1), "sbs", "bib", "sbs", 's', modItems.fGem, 'b', Item.bone, 'i', modItems.infused);
	GameRegistry.addShapelessRecipe(new ItemStack(modItems.sorce, 1), Block.blockDiamond, Item.netherStar, modItems.myst);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.fGem, 1), "fmf", "mdm", "fmf", 'd', Item.diamond, 'f', Item.fireballCharge, 'm', Item.magmaCream);
	ItemStack fRod = new ItemStack(modItems.fWand, 1);
	fRod.stackTagCompound = new NBTTagCompound();
	fRod.stackTagCompound.setInteger("cap", 0);
	GameRegistry.addShapedRecipe(fRod, "if", "bi", 'f', modItems.fGem, 'i', modItems.infused, 'b', Item.blazeRod);
	ItemStack tWand = new ItemStack(modItems.transWand, 1);
	tWand.stackTagCompound = new NBTTagCompound();
	tWand.stackTagCompound.setInteger("cap", 0);
	GameRegistry.addShapedRecipe(tWand, " id", "ibi", "ei ", 'd', Item.diamond, 'i', modItems.infused, 'b', Item.blazeRod, 'e', Item.emerald);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.rStone, 1), "ci", "cc", "cc", 'c', Block.cobblestone, 'i', modItems.infused);
	GameRegistry.addShapedRecipe(new ItemStack(modItems.tBall.itemID, 1, 0), " i ", "ici", " i ", 'i', modItems.infused, 'c', Item.pocketSundial);
	//GameRegistry.addRecipe(new stoneCrafting());
}
}
