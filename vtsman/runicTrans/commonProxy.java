package vtsman.runicTrans;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.colorable;
import vtsman.runicTrans.TE.findRune;
import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.client.clientProxy;
import vtsman.runicTrans.transmute.transInit;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class commonProxy {
	public void registerTEs(){
		System.out.println("Registering Tile Entities");
		System.out.println(this instanceof clientProxy);
		GameRegistry.registerTileEntity(capacitorTE.class, "runeTrans.RunicCapacitor");
		GameRegistry.registerTileEntity(colorable.class, "runeTrans.Colorable");
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