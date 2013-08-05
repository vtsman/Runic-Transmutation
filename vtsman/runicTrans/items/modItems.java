package vtsman.runicTrans.items;

import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.tabs;
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
	public static Item dull;
	public static Item eStone;
	public static Item debug;
	public static Item transWand;
	public static Item iStone;
	public static Item fWand;
	public static Item fGem;
	public static Item rStone;
	public static Item tBall;

	public static void init() {
		chalk = new dust(baseMod.chalk, 0);
		enriched = new dust(baseMod.enriched, 1);
		pulse = new dust(baseMod.pulse, 2);
		infused = new dust(baseMod.infused, 3);
		dark = new dust(baseMod.dark, 4);
		myst = new dust(baseMod.myst, 5);
		sorce = new dust(baseMod.sorce, 6);
		forge = new dust(baseMod.forge, 7);
		enlight = new dust(baseMod.enlight, 8);
		dull = new dullStone(baseMod.dull).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("dullStone");
		eStone = new intelStone(baseMod.eStone).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("intelStone");
		debug = new debug(baseMod.debug).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("debug");
		transWand = new transmutationWand(baseMod.tWand).setCreativeTab(
				tabs.tabRune).setUnlocalizedName("transWand");
		iStone = new infusedStone(baseMod.iStone).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("istone");
		fWand = new fireRod(baseMod.fwand).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("fwand");
		fGem = new fireGem(baseMod.fGem).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("fstone");
		rStone = new runeStone(baseMod.rStone).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("rstone");
		tBall = new timeSphere(baseMod.tBall).setCreativeTab(tabs.tabRune)
				.setUnlocalizedName("tBall");

		LanguageRegistry.addName(chalk, dust.names[0] + " Dust");
		LanguageRegistry.addName(enriched, dust.names[1] + " Dust");
		LanguageRegistry.addName(pulse, dust.names[2] + " Dust");
		LanguageRegistry.addName(infused, dust.names[3] + " Dust");
		LanguageRegistry.addName(dark, dust.names[4] + " Dust");
		LanguageRegistry.addName(myst, dust.names[5] + " Dust");
		LanguageRegistry.addName(sorce, dust.names[6] + " Dust");
		LanguageRegistry.addName(forge, dust.names[7] + " Dust");
		LanguageRegistry.addName(enlight, dust.names[8] + " Dust");
		LanguageRegistry.addName(dull, "Dull Stone");
		LanguageRegistry.addName(eStone, "Enlightened Stone");
		LanguageRegistry.addName(debug, "Wand of limitless power");
		LanguageRegistry.addName(transWand, "Transmutation Wand");
		LanguageRegistry.addName(iStone, "Infused Stone");
		LanguageRegistry.addName(fWand, "Fire Rod");
		LanguageRegistry.addName(rStone, "Rune stone");
		LanguageRegistry.addName(fGem, "Fire Gem");
		LanguageRegistry.addName(tBall, "Time Sphere");
	}
}
