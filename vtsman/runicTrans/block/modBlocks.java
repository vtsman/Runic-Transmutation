package vtsman.runicTrans.block;

import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.tabs;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.items.iGlass;
import vtsman.runicTrans.items.infpedI;
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
	public static Block hex;
	public static Block pulse;
	public static Block animBlock;
	public static Block texBlock;
	public static Block pane;
	public static void init() {
		pane = new hexGlassPane(baseMod.pane, "", "", Material.glass, true).setHardness(.5f).setCreativeTab(tabs.tabPretties).setUnlocalizedName("pane");
		rune = new rune(baseMod.rune, Material.rock).setUnlocalizedName("rune");
		hex = new hexGlass(baseMod.hex, Material.glass).setCreativeTab(tabs.tabPretties).setHardness(2f).setUnlocalizedName("hex");
		chargeNode = new cNode(baseMod.cNode, Material.rock)
		.setCreativeTab(tabs.tabRune).setHardness(2f).setUnlocalizedName("chargeNode");
		cap = new capacitor(baseMod.cap, Material.rock)
		.setCreativeTab(tabs.tabRune).setHardness(2f).setUnlocalizedName("cap");
		pulse = new renderCloud(baseMod.pulserend, Material.rock).setUnlocalizedName("pulse");
		texBlock = new textureBlock(baseMod.texBlock, Material.rock).setUnlocalizedName("tex");
		animBlock = new animBlocks1(baseMod.animBlock).setUnlocalizedName("animBlock1").setHardness(2f).setCreativeTab(tabs.tabPretties);
		GameRegistry.registerBlock(cap, "capacitor");
		GameRegistry.registerBlock(pane, iGlass.class, "pane");
		GameRegistry.registerBlock(pulse, "pulserend");
		GameRegistry.registerBlock(texBlock, "texBlock");
		GameRegistry.registerBlock(rune, "transmutation rune");
		GameRegistry.registerBlock(animBlock, iGlass.class, "animBlock1");
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(cap, "Runic Capacitor");
		GameRegistry.registerBlock(hex, iGlass.class, "Hexed Glass");
		MinecraftForge.setBlockHarvestLevel(hex, "Pickaxe", 2);
		LanguageRegistry.addName(hex, "Hexed Glass");
		MinecraftForge.setBlockHarvestLevel(pane, "Pickaxe", 2);
		LanguageRegistry.addName(pane, "Hexed Glass Pane");
		GameRegistry.registerBlock(chargeNode,
				vtsman.runicTrans.items.itemChargeNode.class, "charge Node");
		MinecraftForge.setBlockHarvestLevel(chargeNode, "Pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(chargeNode, "Charge Node");
	}
}
