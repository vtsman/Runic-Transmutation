package vtsman.runicTrans.block;

import vtsman.runicTrans.tabs;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.MinecraftForge;

public class modBlocks {
public static Block cap = new capacitor(750, Material.rock).setCreativeTab(tabs.tabRune);
	public static void init(){
		GameRegistry.registerBlock(cap, "cap");
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(cap, "Runic Capacitor");
}
}
