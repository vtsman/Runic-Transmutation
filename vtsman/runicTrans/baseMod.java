package vtsman.runicTrans;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.findRune;
import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.client.ClientPacketHandler;
import vtsman.runicTrans.items.modItems;
import vtsman.runicTrans.transmute.transInit;
import vtsman.runicTrans.transmute.transmuteManager;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@NetworkMod(clientSideRequired = true, serverSideRequired = false, // Whether
																	// client
																	// side and
																	// server
																	// side are
																	// needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = { "RuneTrans TE" }, packetHandler = ClientPacketHandler.class), // For
																															// clientside
																															// packet
																															// handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = { "RuneTrans Server" }, packetHandler = ServerPacketHandler.class))
// For serverside packet handling
@Mod(modid = "runeTrans", name = "Runic Alchemy", version = "0.0.0")
public class baseMod { // The class file
	
	public static int cap;
	public static int rune;
	public static int cNode;
	
	public static int chalk;
	public static int enriched;
	public static int pulse;
	public static int infused;
	public static int dark;
	public static int myst;
	public static int sorce;
	public static int forge;
	public static int enlight;
	
	public static int dull;
	public static int eStone;
	public static int debug;
	public static int tWand;
	public static int iStone;
	public static int fwand;
	public static int fGem;
	public static int rStone;
	public static int tBall;
	@Instance("runeTrans")
	// The instance, this is very important later on
	public static baseMod instance = new baseMod();
	@SidedProxy(clientSide = "vtsman.runicTrans.client.clientProxy", serverSide = "vtsman.runicTrans.commonProxy")
	public static commonProxy proxy;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();
	cap = config.get("Block IDs", "Capacitor: ", 750).getInt();
	rune = config.get("Block IDs", "Rune: ", 751).getInt();
	cNode = config.get("Block IDs", "Charge Node: ", 752).getInt();
	
	chalk = config.get("Item IDs", "Chalky Dust: ", 700).getInt();
	enriched = config.get("Item IDs", "Enriched Dust: ", 701).getInt();
	pulse = config.get("Item IDs", "Pulsating Dust: ", 702).getInt();
	infused = config.get("Item IDs", "Infused Dust: ", 703).getInt();
	dark = config.get("Item IDs", "Darkened Dust: ", 704).getInt();
	myst = config.get("Item IDs", "Mysterious Dust: ", 705).getInt();
	sorce = config.get("Item IDs", "Sorcerer's Dust: ", 706).getInt();
	forge = config.get("Item IDs", "Forges Dust: ", 707).getInt();
	enlight = config.get("Item IDs", "Enlightened Dust: ", 708).getInt();
	dull = config.get("Item IDs", "Dull Stone: ", 709).getInt();
	eStone = config.get("Item IDs", "Enlightened Stone: ", 710).getInt();
	debug = config.get("Item IDs", "Wand of Infinite Power: ", 711).getInt();
	tWand = config.get("Item IDs", "Wand of Transmutation: ", 712).getInt();
	iStone = config.get("Item IDs", "Infused Stone: ", 713).getInt();
	fwand = config.get("Item IDs", "Wand of Fire: ", 714).getInt();
	fGem = config.get("Item IDs", "Fire Gem: ", 715).getInt();
	rStone = config.get("Item IDs", "Rune Stone: ", 716).getInt();
	tBall = config.get("Item IDs", "Time Sphere: ", 717).getInt();
	
	config.save();
	modBlocks.init();
	modItems.init();
	}
	@EventHandler
	public void ServerInit(FMLInitializationEvent event) {
		System.out.println("Server");
		GameRegistry.registerTileEntity(capacitorTE.class, "Runic Capacitor");
		GameRegistry.registerTileEntity(findRune.class, "enlightened rune");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.chargeNode.class,
				"Charge Node");
		GameRegistry
				.registerTileEntity(transRuneTE.class, "Transmutation Rune");
		recipes.init();
		proxy.registerRenderInformation();
		tabs.init();
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		transInit.init();
	}

}