package vtsman.runicTrans.block;

import vtsman.runicTrans.tabs;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.transRuneTE;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class modBlocks {
	public static Block cap = new capacitor(750, Material.rock)
			.setCreativeTab(tabs.tabRune);
	public static Block chargeNode = new cNode(752, Material.rock)
			.setCreativeTab(tabs.tabRune);
	public static Block rune = new rune(751, Material.rock)
			.setCreativeTab(tabs.tabRune);

	public static void init() {
		GameRegistry.registerBlock(cap, "capacitor");
		GameRegistry.registerBlock(rune, "transmutation rune");
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(cap, "Runic Capacitor");
		GameRegistry.registerBlock(chargeNode,
				vtsman.runicTrans.items.itemChargeNode.class, "charge Node");
		MinecraftForge.setBlockHarvestLevel(chargeNode, "Pickaxe", 3);
		LanguageRegistry.addName(chargeNode, "Charge Node");
	}
}
