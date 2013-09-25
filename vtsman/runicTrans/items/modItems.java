package vtsman.runicTrans.items;

import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.tabs;
import vtsman.runicTrans.items.tools.initTools;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class modItems {
	public static dust chalk;
	public static dust enriched;
	public static dust pulse;
	public static dust infused;
	public static dust dark;
	public static dust myst;
	public static dust sorce;
	public static dust forge;
	public static dust enlight;
	public static Item debug;
	public static Item fWand;
	public static Item fGem;
	public static Item rStone;
	public static Item cWand;
	public static Item hexmetal;
	public static Item mixDust;
	
	public static void init() {
		
		initTools.init();
		
		chalk = new dust(baseMod.chalk, 0);
		enriched = new dust(baseMod.enriched, 1);
		pulse = new dust(baseMod.pulse, 2);
		infused = new dust(baseMod.infused, 3);
		dark = new dust(baseMod.dark, 4);
		myst = new dust(baseMod.myst, 5);
		sorce = new dust(baseMod.sorce, 6);
		forge = new dust(baseMod.forge, 7);
		enlight = new dust(baseMod.enlight, 8);
		mixDust = new mixedDust(baseMod.mixDust).setUnlocalizedName("mixdust").setCreativeTab(tabs.tabRune);
		debug = new debug(baseMod.debug).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("debug");
		fWand = new fireRod(baseMod.fwand).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("fwand");
		fGem = new fireGem(baseMod.fGem).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("fstone");
		rStone = new runeStone(baseMod.rStone).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("rstone");
		cWand = new colorWand(baseMod.cWand).setCreativeTab(tabs.tabRune).setUnlocalizedName("colorWand");
		hexmetal = new hexmetal(baseMod.hexmetal).setUnlocalizedName("hexmetal").setCreativeTab(tabs.tabRune);
		
		LanguageRegistry.addName(chalk, dust.names[0] + " Dust");
		LanguageRegistry.addName(enriched, dust.names[1] + " Dust");
		LanguageRegistry.addName(pulse, dust.names[2] + " Dust");
		LanguageRegistry.addName(infused, dust.names[3] + " Dust");
		LanguageRegistry.addName(dark, dust.names[4] + " Dust");
		LanguageRegistry.addName(myst, dust.names[5] + " Dust");
		LanguageRegistry.addName(sorce, dust.names[6] + " Dust");
		LanguageRegistry.addName(forge, dust.names[7] + " Dust");
		LanguageRegistry.addName(enlight, dust.names[8] + " Dust");
		LanguageRegistry.addName(mixDust, "Mixed Dust");
		LanguageRegistry.addName(debug, "Wand of limitless power");
		LanguageRegistry.addName(fWand, "Firey Staff");
		LanguageRegistry.addName(rStone, "Rune stone");
		LanguageRegistry.addName(fGem, "Fire Gem");
		LanguageRegistry.addName(cWand, "Magical Paintbrush");
		LanguageRegistry.addName(hexmetal, "Hexed metal");
	}
}
