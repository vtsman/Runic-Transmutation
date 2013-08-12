package vtsman.runicTrans;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class tabs {
	public static CreativeTabs tabRune = new CreativeTabs("tabRune") {
		public ItemStack getIconItemStack() {
			ItemStack stack = new ItemStack(modItems.chalk, 1, 0);
			return stack;
		}
	};
	public static CreativeTabs tabPretties = new CreativeTabs("tabRuneBlock") {
		public ItemStack getIconItemStack() {
			ItemStack stack = new ItemStack(modBlocks.animBlock, 1, 0);
			return stack;
		}
	};

	public static void init() {
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabRune",
				"en_US", "Runic Alchemy");
		LanguageRegistry.instance().addStringLocalization("itemGroup.tabRuneBlock",
				"en_US", "Pretty Blocks");
	}
}
