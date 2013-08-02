package vtsman.runicTrans.items;

import vtsman.runicTrans.tabs;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.Item;

public class modItems {
	public static dust chalk = new dust(700, 0);
	public static dust enriched = new dust(701, 1);
	public static dust pulse = new dust(702, 2);
	public static dust infused = new dust(703, 3);
	public static dust dark = new dust(704, 4);
	public static dust myst = new dust(705, 5);
	public static dust sorce = new dust(706, 6);
	public static dust forge = new dust(707, 7);
	public static dust enlight = new dust(708, 8);
	public static Item dull = new dullStone(709).setCreativeTab(tabs.tabRune).setUnlocalizedName("dullStone");
	public static Item eStone = new intelStone(710).setCreativeTab(tabs.tabRune).setUnlocalizedName("intelStone");
	public static Item debug = new debug(711).setCreativeTab(tabs.tabRune).setUnlocalizedName("debug");
	public static void init(){
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
		LanguageRegistry.addName(debug, "Debug Tool");
	}
}
