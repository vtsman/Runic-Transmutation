package vtsman.runicTrans;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.transRuneTE;
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

	public void registerRenderInformation() {
	}

	public void register() {
		recipes.init();
		transInit.init();

	}
	public void registerTE(){
		GameRegistry.registerTileEntity(capacitorTE.class, "Runic Capacitor");
		GameRegistry.registerTileEntity(vtsman.runicTrans.TE.chargeNode.class,
				"Charge Node");
		GameRegistry
				.registerTileEntity(transRuneTE.class, "Transmutation Rune");
	}
}