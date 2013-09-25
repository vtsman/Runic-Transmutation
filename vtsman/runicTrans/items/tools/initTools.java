package vtsman.runicTrans.items.tools;

import java.util.HashMap;
import java.util.Map;

import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.LanguageRegistry;
import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.energizedEnchant;
import vtsman.runicTrans.tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;

public class initTools {
	
	public static EnumToolMaterial special = EnumHelper.addToolMaterial("Hexed", 2, 1536, 8.0F, 3, 30); 
	public static EnumToolMaterial hex = EnumHelper.addToolMaterial("Hexed", 2, 768, 6.0F, 3, 30); 
	
	
	public static Item cavePick;
	public static Item diveShovel;
	public static Item forestAxe;
	public static Item advSword;
	public static Item advHoe;
	
	public static Item pick;
	public static Item spade;
	public static Item axe;
	public static Item hoe;
	public static Item sword;
	
public static ItemStack infuse(Item i, int strength){
	ItemStack s = new ItemStack(i, 1);
	s.addEnchantment(baseMod.charge, strength);
	return s;
}
public static void init(){
	cavePick = new minerPickaxe(baseMod.cavePick, special).setUnlocalizedName("CavePick").setCreativeTab(tabs.tabRune);
	diveShovel = new diveShovel(baseMod.diveSpade, special).setUnlocalizedName("DiveSpade").setCreativeTab(tabs.tabRune);
	forestAxe = new forestAxe(baseMod.forestAxe, special).setUnlocalizedName("forestAxe").setCreativeTab(tabs.tabRune);
	advSword = new advSword(baseMod.advSword, special).setUnlocalizedName("advSword").setCreativeTab(tabs.tabRune);
	advHoe = new advHoe(baseMod.advHoe, special).setUnlocalizedName("advHoe").setCreativeTab(tabs.tabRune);
	
	LanguageRegistry.addName(diveShovel, "Diver's Spade");
	LanguageRegistry.addName(cavePick, "Caver's Pickaxe");
	LanguageRegistry.addName(forestAxe, "Forester's Axe");
	LanguageRegistry.addName(advSword, "Assassin's Blade");
	LanguageRegistry.addName(advHoe, "Cultivator's Hoe");
	
	pick = new pick(baseMod.pick, hex).setUnlocalizedName("HexPick").setCreativeTab(tabs.tabRune);
	spade = new spade(baseMod.spade, hex).setUnlocalizedName("HexSpade").setCreativeTab(tabs.tabRune);
	axe = new axe(baseMod.axe, hex).setUnlocalizedName("HexAxe").setCreativeTab(tabs.tabRune);
	sword = new sword(baseMod.sword, hex).setUnlocalizedName("HexSword").setCreativeTab(tabs.tabRune);
	hoe = new hoe(baseMod.hoe, hex).setUnlocalizedName("HexHoe").setCreativeTab(tabs.tabRune);
	
	LanguageRegistry.addName(spade, "Hexed Spade");
	LanguageRegistry.addName(pick, "Hexed Pickaxe");
	LanguageRegistry.addName(axe, "Hexed Axe");
	LanguageRegistry.addName(sword, "Hexed Sword");
	LanguageRegistry.addName(hoe, "Hexed Hoe");
}
}
