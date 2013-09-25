package vtsman.runicTrans;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vtsman.runicTrans.client.gui.centriContainer;
import vtsman.runicTrans.client.gui.centriGui;
import vtsman.runicTrans.client.gui.morterContainer;
import vtsman.runicTrans.client.gui.morterGui;

public class guiHandler implements IGuiHandler{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if(te != null){
			if(ID == baseMod.guiMorter && te instanceof vtsman.runicTrans.TE.mortar)
				return new morterContainer(player.inventory, (vtsman.runicTrans.TE.mortar)te);
			if(ID == baseMod.guiCentri && te instanceof vtsman.runicTrans.TE.centriTE)
				return new centriContainer(player.inventory, (vtsman.runicTrans.TE.centriTE)te);
		}
		return null;
	}
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		System.out.println(ID == baseMod.guiCentri);
		if(te != null){
			if(ID == baseMod.guiMorter && te instanceof vtsman.runicTrans.TE.mortar)
				return new morterGui(player.inventory, (vtsman.runicTrans.TE.mortar)te);
			if(ID == baseMod.guiCentri && te instanceof vtsman.runicTrans.TE.centriTE)
				return new centriGui(player.inventory, (vtsman.runicTrans.TE.centriTE)te);
		}
		return null;
	}
}
