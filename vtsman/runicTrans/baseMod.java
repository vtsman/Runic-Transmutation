package vtsman.runicTrans;

import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.Configuration;
import vtsman.runicTrans.TE.recipe_mortar;
import vtsman.runicTrans.aspect.modAspects;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;
import vtsman.runicTrans.transmute.transInit;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

// For serverside packet handling
@Mod(modid = "runeTrans", name = "Runic Alchemy", version = "1.2.4")
@NetworkMod(channels = { "RuneAlchem TE", "RuneAlchem RE", "RuneAlchem RE CLI" }, clientSideRequired = true, serverSideRequired = false, clientPacketHandlerSpec = @SidedPacketHandler(channels = {
		"RuneAlchem TE", "RuneAlchem RE" }, packetHandler = packetHandler.class))
// For clientside packet handling
public class baseMod { // The class file

	public static int guiMorter = 0;
	public static int guiCentri = 1;
	public static int guiResearch = 2;

	public static int cap;
	public static int rune;
	public static int cNode;
	public static int hex;
	public static int pulserend;
	public static int animBlock;
	public static int texBlock;
	public static int pane;
	public static int lumin;
	public static int mortar;
	public static int resBlock;

	public static int chalk;
	public static int enriched;
	public static int pulse;
	public static int infused;
	public static int dark;
	public static int myst;
	public static int sorce;
	public static int forge;
	public static int enlight;
	public static int mixDust;

	public static int debug;
	public static int fwand;
	public static int fGem;
	public static int rStone;
	public static int cWand;
	public static int hexmetal;

	public static int cavePick;
	public static int diveSpade;
	public static int forestAxe;
	public static int advSword;
	public static int advHoe;

	public static int hoe;
	public static int axe;
	public static int spade;
	public static int pick;
	public static int sword;

	public static Enchantment charge;
	@Instance("runeTrans")
	public static baseMod instance = new baseMod();

	@SidedProxy(clientSide = "vtsman.runicTrans.client.clientProxy", serverSide = "vtsman.runicTrans.commonProxy")
	public static commonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(
				event.getSuggestedConfigurationFile());
		proxy.registerTEs();
		config.load();
		cap = config.get("Block IDs", "Capacitor: ", 750).getInt();
		rune = config.get("Block IDs", "Rune: ", 751).getInt();
		cNode = config.get("Block IDs", "Charge Node: ", 752).getInt();
		hex = config.get("Block IDs", "Hexed Glass: ", 753).getInt();
		pulserend = config.get("Block IDs", "Pulse Cloud: ", 754).getInt();
		animBlock = config.get("Block IDs", "Animated Block: ", 755).getInt();
		texBlock = config.get("Block IDs", "Texture Block: ", 756).getInt();
		pane = config.get("Block IDs", "Hexed Glass Pane: ", 757).getInt();
		lumin = config.get("Block IDs", "Illuminated Animated Block: ", 758)
				.getInt();
		mortar = config.get("Block IDs", "Mortar: ", 759).getInt();
		resBlock = config.get("Block IDs", "Research Altar: ", 760).getInt();

		chalk = config.get("Item IDs", "Chalky Dust: ", 700).getInt();
		enriched = config.get("Item IDs", "Enriched Dust: ", 701).getInt();
		pulse = config.get("Item IDs", "Pulsating Dust: ", 702).getInt();
		infused = config.get("Item IDs", "Infused Dust: ", 703).getInt();
		dark = config.get("Item IDs", "Darkened Dust: ", 704).getInt();
		myst = config.get("Item IDs", "Mysterious Dust: ", 705).getInt();
		sorce = config.get("Item IDs", "Sorcerer's Dust: ", 706).getInt();
		forge = config.get("Item IDs", "Forges Dust: ", 707).getInt();
		enlight = config.get("Item IDs", "Enlightened Dust: ", 708).getInt();
		debug = config.get("Item IDs", "Wand of Infinite Power: ", 711)
				.getInt();
		fwand = config.get("Item IDs", "Fire Rod: ", 714).getInt();
		fGem = config.get("Item IDs", "Fire Gem: ", 715).getInt();
		rStone = config.get("Item IDs", "Rune Stone: ", 716).getInt();
		cWand = config.get("Item IDs", "Magical Paintbrush: ", 718).getInt();
		hexmetal = config.get("Item IDs", "Hexed metal: ", 729).getInt();
		mixDust = config.get("Item IDs", "Mixed Dust: ", 730).getInt();

		cavePick = config.get("Item IDs", "Caver's Pickaxe: ", 719).getInt();
		diveSpade = config.get("Item IDs", "Diver's Shovel: ", 720).getInt();
		forestAxe = config.get("Item IDs", "Forester's Axe: ", 721).getInt();
		advSword = config.get("Item IDs", "Assassin's Sword: ", 722).getInt();
		advHoe = config.get("Item IDs", "Cultivator's Hoe: ", 723).getInt();

		pick = config.get("Item IDs", "Hexed pickaxe: ", 724).getInt();
		axe = config.get("Item IDs", "Hexed axe: ", 725).getInt();
		spade = config.get("Item IDs", "Hexed spade: ", 726).getInt();
		hoe = config.get("Item IDs", "Hexed hoe: ", 727).getInt();
		sword = config.get("Item IDs", "Hexed sword: ", 728).getInt();

		int e = config.get("Enchantment IDs", "Infused: ", 85).getInt();
		charge = new energizedEnchant(e, 10);
		config.save();
		modBlocks.init();
		modItems.init();
		modAspects.init();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event) {
		recipes.init();
		// proxy.addVillager();
		proxy.registerRenderInformation();
		tabs.init();
		recipe_mortar.init();
		NetworkRegistry.instance().registerGuiHandler(instance,
				new guiHandler());
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		transInit.init();
	}

}