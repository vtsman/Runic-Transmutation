package vtsman.runicTrans.client.gui;

import vtsman.runicTrans.packetHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class oneSlot extends Slot {
	TileEntity t;
	morterContainer c;
	public oneSlot(morterContainer container, TileEntity tile, IInventory par1iInventory, int par2, int par3, int par4) {
		super(par1iInventory, par2, par3, par4);
		this.t = tile;
		this.c = container;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onPickupFromSlot(EntityPlayer p , ItemStack s){
		for(int k = 0; k < 6; k++)
			 if(this.inventory.getStackInSlot(k) != null)
				 this.c.slots[k].decrStackSize(1);
		packetHandler.sendPacket(t);
	}

	public boolean isItemValid(ItemStack par1ItemStack) {

		return false;
	}
}
