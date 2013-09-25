package vtsman.runicTrans;

import vtsman.runicTrans.TE.*;
import vtsman.runicTrans.client.clientProxy;
import vtsman.runicTrans.transmute.transInit;
import vtsman.runicTrans.worldGen.tradeHandler;
import vtsman.runicTrans.worldGen.villagerHouse;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class commonProxy {
	public static int villagerID = 100;
	public void addVillager(){
		
		VillagerRegistry.instance().registerVillagerId(villagerID);
		VillagerRegistry.instance().registerVillageTradeHandler(villagerID, new tradeHandler());
		VillagerRegistry.instance().registerVillageCreationHandler(new villagerHouse());
	}
	public void registerTEs(){
		System.out.println("Registering Tile Entities");
		System.out.println(this instanceof clientProxy);
		GameRegistry.registerTileEntity(capacitorTE.class, "runeTrans.RunicCapacitor");
		GameRegistry.registerTileEntity(mortar.class, "runeTrans.morter");
		GameRegistry.registerTileEntity(colorable.class, "runeTrans.Colorable");
		GameRegistry.registerTileEntity(centriTE.class, "runeTrans.Centrifuge");
		GameRegistry.registerTileEntity(findRune.class, "runeTrans.enlightenedrune");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.chargeNode.class,
				"runeTrans.ChargeNode");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.relay.class,
				"runeTrans.relay");
		GameRegistry
				.registerTileEntity(transRuneTE.class, "runeTrans.TransmutationRune");
	}
	public void registerRenderInformation() {
	}
}