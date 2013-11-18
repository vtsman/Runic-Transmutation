package vtsman.runicTrans;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vtsman.runicTrans.client.gui.centriContainer;
import vtsman.runicTrans.client.gui.centriGui;
import vtsman.runicTrans.client.gui.mortarContainer;
import vtsman.runicTrans.client.gui.mortarGui;
import vtsman.runicTrans.client.gui.researchContainer;
import vtsman.runicTrans.client.gui.researchGui;
import cpw.mods.fml.common.network.IGuiHandler;

public class guiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (ID == baseMod.guiMorter
				&& te instanceof vtsman.runicTrans.TE.mortar) {
			return new mortarContainer(player.inventory,
					(vtsman.runicTrans.TE.mortar) te);
		}
		if (ID == baseMod.guiCentri
				&& te instanceof vtsman.runicTrans.TE.centriTE) {
			return new centriContainer(player.inventory,
					(vtsman.runicTrans.TE.centriTE) te);
		}
		if (ID == baseMod.guiResearch) {
			return new researchContainer(player.inventory, te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (ID == baseMod.guiMorter
				&& te instanceof vtsman.runicTrans.TE.mortar) {
			return new mortarGui(player.inventory,
					(vtsman.runicTrans.TE.mortar) te);
		}
		if (ID == baseMod.guiCentri
				&& te instanceof vtsman.runicTrans.TE.centriTE) {
			return new centriGui(player.inventory,
					(vtsman.runicTrans.TE.centriTE) te);
		}
		if (ID == baseMod.guiResearch) {
			return new researchGui(player.inventory, te);
		}
		return null;
	}
}
