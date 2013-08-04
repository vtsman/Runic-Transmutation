package vtsman.runicTrans;

import vtsman.runicTrans.TE.capacitorTE;
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
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
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
@Mod(modid = "runeTrans", name = "Runic Transmutation", version = "0.0.0")
public class baseMod { // The class file
	int i = 0;
	@Instance("runeTrans")
	// The instance, this is very important later on
	public static baseMod instance = new baseMod();
	@SidedProxy(clientSide = "vtsman.runicTrans.client.clientProxy", serverSide = "vtsman.runicTrans.commonProxy")
	public static commonProxy proxy;

			
	@EventHandler
	public void ServerInit(FMLInitializationEvent event) {
		System.out.println("Server");
		GameRegistry.registerTileEntity(capacitorTE.class, "Runic Capacitor");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.chargeNode.class,
				"Charge Node");
		GameRegistry
				.registerTileEntity(transRuneTE.class, "Transmutation Rune");
		recipes.init();
		modItems.init();
		modBlocks.init();
		transInit.init();
		proxy.registerRenderInformation();
		tabs.init();
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {

	}

}