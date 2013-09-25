package vtsman.runicTrans.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.tabs;
import vtsman.runicTrans.items.iGlass;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class modBlocks {
	public static Block cap;
	public static Block chargeNode;
	public static Block rune;
	public static Block hex;
	public static Block pulse;
	public static Block animBlock;
	public static Block texBlock;
	public static Block pane;
	public static Block lumin;
	public static Block morter;
	public static Block rBlock;

	// public static Block relay;
	public static void init() {
		pane = new hexGlassPane(baseMod.pane, "", "", Material.glass, true)
				.setHardness(.5f).setCreativeTab(tabs.tabPretties)
				.setUnlocalizedName("pane");
		rune = new rune(baseMod.rune, Material.rock).setUnlocalizedName("rune");
		rBlock = new resBlock(baseMod.resBlock, Material.rock).setCreativeTab(
				tabs.tabRune).setUnlocalizedName("resBlock");
		hex = new hexGlass(baseMod.hex, Material.glass)
				.setCreativeTab(tabs.tabPretties).setHardness(2f)
				.setUnlocalizedName("hex");
		chargeNode = new cNode(baseMod.cNode, Material.rock)
				.setCreativeTab(tabs.tabRune).setHardness(2f)
				.setUnlocalizedName("chargeNode");
		cap = new capacitor(baseMod.cap, Material.rock)
				.setCreativeTab(tabs.tabRune).setHardness(2f)
				.setUnlocalizedName("cap");
		pulse = new renderCloud(baseMod.pulserend, Material.rock)
				.setUnlocalizedName("pulse");
		texBlock = new textureBlock(baseMod.texBlock, Material.rock)
				.setUnlocalizedName("tex");
		animBlock = new animBlocks1(baseMod.animBlock)
				.setUnlocalizedName("animBlock1").setHardness(2f)
				.setCreativeTab(tabs.tabPretties);
		lumin = new animBlocks1(baseMod.lumin).setUnlocalizedName("lumin1")
				.setHardness(2f).setCreativeTab(tabs.tabPretties)
				.setLightValue(1f);
		morter = new mortar(baseMod.morter, Material.rock)
				.setUnlocalizedName("Mortar").setHardness(3f)
				.setCreativeTab(tabs.tabRune);
		// relay = new relay(baseMod.relay,
		// Material.rock).setCreativeTab(tabs.tabRune).setUnlocalizedName("relay").setHardness(2f);
		GameRegistry.registerBlock(cap, "capacitor");
		// GameRegistry.registerBlock(relay, "relay");
		GameRegistry.registerBlock(pane, "pane");
		GameRegistry.registerBlock(rBlock, "rBlock");
		GameRegistry.registerBlock(pulse, "pulserend");
		GameRegistry.registerBlock(morter, iGlass.class, "Mortar");
		GameRegistry.registerBlock(texBlock, "texBlock");
		GameRegistry.registerBlock(rune, "transmutation rune");
		GameRegistry.registerBlock(lumin, iGlass.class, "luminblock");
		GameRegistry.registerBlock(animBlock, iGlass.class, "animBlock1");
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(cap, "Runic Capacitor");
		GameRegistry.registerBlock(hex, iGlass.class, "Hexed Glass");
		MinecraftForge.setBlockHarvestLevel(hex, "Pickaxe", 2);
		LanguageRegistry.addName(hex, "Hexed Glass");
		LanguageRegistry.addName(lumin, "Illuminated Block");
		// LanguageRegistry.addName(relay, "Mystical Relay");
		MinecraftForge.setBlockHarvestLevel(pane, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(rBlock, "Pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(lumin, "Pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(morter, "Pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(animBlock, "Pickaxe", 1);
		// MinecraftForge.setBlockHarvestLevel(relay, "Pickaxe", 2);
		LanguageRegistry.addName(pane, "Hexed Glass Pane");
		GameRegistry.registerBlock(chargeNode,
				vtsman.runicTrans.items.itemChargeNode.class, "charge Node");
		MinecraftForge.setBlockHarvestLevel(chargeNode, "Pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(cap, "Pickaxe", 2);
		LanguageRegistry.addName(chargeNode, "Charge Node");
		LanguageRegistry.addName(rBlock, "Research Altar");
		ItemStack s = new ItemStack(hex, 1, 0);
		LanguageRegistry.addName(s.copy(), "Hexed Glass");
		s = new ItemStack(hex, 1, 1);
		LanguageRegistry.addName(s.copy(), "Frosted Hexed Glass");
		String[] names = { "Infused Block", "Infused Bricks", "Infused Tiles",
				"Carved Infused Block", "Squared Infused Bricks",
				"Etched Infused Block", "Framed Infused Block", "Infused Block" };
		for (int i = 0; i < 8; i++) {
			ItemStack stack = new ItemStack(animBlock, 1, i);
			LanguageRegistry.addName(stack.copy(), names[i]);
		}
		for (int i = 0; i < 8; i++) {
			ItemStack stack = new ItemStack(lumin, 1, i);
			LanguageRegistry.addName(stack.copy(), "Illuminated " + names[i]);
		}
		LanguageRegistry.addName(new ItemStack(morter, 1, 0), "Mortar");
		LanguageRegistry.addName(new ItemStack(morter, 1, 1),
				"Arcane Centrifuge");
	}
}
