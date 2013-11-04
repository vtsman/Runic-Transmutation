package vtsman.runicTrans;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;
import vtsman.runicTrans.items.tools.initTools;
import cpw.mods.fml.common.registry.GameRegistry;

public class recipes {
	public static void init() {
		GameRegistry.addShapedRecipe(new ItemStack(modItems.fGem, 1), "fmf",
				"mdm", "fmf", 'd', Item.diamond, 'f', Item.fireballCharge, 'm',
				Item.magmaCream);
		ItemStack fRod = new ItemStack(modItems.fWand, 1);
		fRod.stackTagCompound = new NBTTagCompound();
		fRod.stackTagCompound.setInteger("cap", 0);
		GameRegistry.addShapedRecipe(fRod, "if", "bi", 'f', modItems.fGem, 'i',
				modItems.infused, 'b', Item.blazeRod);
		GameRegistry.addShapedRecipe(new ItemStack(modItems.rStone, 1), "ci",
				"cc", "cc", 'c', Block.cobblestone, 'i', modItems.infused);
		GameRegistry.addShapedRecipe(
				new ItemStack(modItems.cWand.itemID, 1, 0), "dgd", " s ", 'g',
				Block.cloth, 'd', Item.glowstone, 's', Item.stick);
		GameRegistry.addShapedRecipe(
				new ItemStack(modBlocks.hex.blockID, 16, 0), "ggg", "gdg",
				"ggg", 'd', modItems.infused, 'g', Block.glass);
		GameRegistry.addRecipe(new stoneCrafting());
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 4),
				"bsb", "sis", "bsb", 's', Block.stone, 'i', modItems.infused,
				'b', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 0),
				"sss", "sis", "sss", 's', Block.stone, 'i', modItems.infused);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 1),
				"bbb", "bib", "bbb", 'b', Block.stoneBrick, 'i',
				modItems.infused);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 2),
				"sss", "sis", "sss", 's', Item.brick, 'i', modItems.infused);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 3),
				"sss", "gig", "sss", 's', Block.stone, 'i', modItems.infused,
				'g', Item.gunpowder);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 5),
				"sbs", "bib", "sbs", 's', Block.stone, 'i', modItems.infused,
				'b', Block.stoneBrick);
		GameRegistry.addRecipe(new ItemStack(modBlocks.animBlock, 16, 6),
				"sss", "sis", "sss", 's', Block.fenceIron, 'i',
				modItems.infused);
		GameRegistry.addShapelessRecipe(
				new ItemStack(modBlocks.animBlock, 1, 7), new ItemStack(
						modBlocks.animBlock, 1, 0), new ItemStack(
						Item.dyePowder, 1, 0));
		for (int i = 0; i < 7; i++) {
			GameRegistry.addShapelessRecipe(
					new ItemStack(modBlocks.lumin, 1, i), new ItemStack(
							modBlocks.animBlock, 1, i), new ItemStack(
							Block.glowStone, 1, 0));
		}
		GameRegistry.addShapedRecipe(new ItemStack(modBlocks.morter), "i i",
				"sis", "sss", 'i', Item.ingotIron, 's', Block.stoneBrick);
		GameRegistry.addShapedRecipe(new ItemStack(modBlocks.morter, 1, 1),
				"hhh", "oio", "ooo", 'o', Block.obsidian, 'h',
				modItems.hexmetal, 'i', modItems.infused);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.hoe), "mm", " s",
				" s", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.hoe), "mm", "s ",
				"s ", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.axe), "mm", "ms",
				" s", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.axe), "mm", "sm",
				"s ", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.spade), "m", "s",
				"s", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.sword), "m", "m",
				"s", 'm', modItems.hexmetal, 's', Item.stick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.pick), "mmm",
				" s ", " s ", 'm', modItems.hexmetal, 's', Item.stick);

		GameRegistry.addShapedRecipe(new ItemStack(initTools.cavePick), "geg",
				"epe", "geg", 'g', Block.glowStone, 'e', modItems.enlight, 'p',
				initTools.pick);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.advHoe), "efe",
				"fhf", "efe", 'e', Item.emerald, 'f', modItems.forge, 'h',
				initTools.hoe);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.forestAxe), "srs",
				"rar", "srs", 's', Item.shears, 'r', Item.redstone, 'a',
				initTools.axe);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.diveShovel),
				"lfl", "fsf", "lfl", 'l', Block.blockLapis, 'f',
				modItems.forge, 's', initTools.spade);
		GameRegistry.addShapedRecipe(new ItemStack(initTools.advSword), "ege",
				"gsg", "ege", 'e', Item.spiderEye, 'g', Block.glass, 's',
				initTools.sword);
	}
}
