package vtsman.runicTrans.block;

import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.tabs;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.transRuneTE;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;

public class modBlocks {
	public static Block cap;
	public static Block chargeNode;
	public static Block rune;

	public static void init() {
		rune = new rune(baseMod.rune, Material.rock);
		chargeNode = new cNode(baseMod.cNode, Material.rock)
		.setCreativeTab(tabs.tabRune);
		cap = new capacitor(baseMod.cap, Material.rock)
		.setCreativeTab(tabs.tabRune);
		
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
