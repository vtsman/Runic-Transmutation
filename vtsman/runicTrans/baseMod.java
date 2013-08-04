package vtsman.runicTrans;

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
import cpw.mods.fml.common.Mod.PostInit;
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

@Mod(modid = "runicTrans", name = "Runic Transmutation", version = "0.0.0")
@NetworkMod( clientSideRequired = true, serverSideRequired = false)
public class baseMod {

	@Instance("runicTrans")
	public static baseMod instance;

	@SidedProxy(clientSide = "vtsman.runicTrans.client.clientProxy", serverSide = "vtsman.runicTrans.commonProxy")
	public static commonProxy proxy;


	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("preinit");
		proxy.registerTE();
	}

	@EventHandler
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void load(FMLInitializationEvent event) {
		tabs.init();
		modBlocks.init();
		modItems.init();
		proxy.register();
		proxy.registerRenderInformation();
	}

}