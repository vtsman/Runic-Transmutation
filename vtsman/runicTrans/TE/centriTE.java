package vtsman.runicTrans.TE;

import vtsman.runicTrans.client.gui.morterContainer;
import vtsman.runicTrans.items.mixedDust;
import vtsman.runicTrans.items.modItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class centriTE extends TileEntity implements IInventory, ISidedInventory {
	ItemStack[] inv = new ItemStack[7];
	public morterContainer cont;
	public centriTE() {

	}
	static final int max = 200;
	int progress = 0;
	@Override
	public void updateEntity() {
		if(inv[6] != null)
			if(inv[6].itemID == modItems.mixDust.itemID)
				progress++;
		if(progress == max){
			progress = 0;
			int x = 0;
			for(int i = 0; i < inv.length - 1; i++){
			if(this.inv[i] == null)
				x++;
			}
			if(x == inv.length - 1){
			ItemStack[] s = mixedDust.readFromNBTStat(inv[6].stackTagCompound);
			for(int i = 0; i < s.length; i++){
				inv[i] = s[i];
			}
			this.decrStackSize(6, 1);
			}
		}
	}
	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inv[slot];
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		this.invUpdate(slot);
	}

	@Override
	public ItemStack decrStackSize(int slot, int amt) {
		ItemStack stack;
		stack = getStackInSlot(slot);
		if (stack != null) {
			if (stack.stackSize <= amt) {
				setInventorySlotContents(slot, null);
			} else {
				stack.stackSize -= amt;
				if (stack.stackSize == 0) {
					setInventorySlotContents(slot, null);
				}
			}
		}

		this.invUpdate(slot);
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if (stack != null) {
			setInventorySlotContents(slot, null);
		}
		return stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
				&& player.getDistanceSq(xCoord + 0.5, yCoord + 0.5,
						zCoord + 0.5) < 64;
	}

	@Override
	public void openChest() {
	}

	@Override
	public void closeChest() {
	}

	@Override
	public void readFromNBT(NBTTagCompound tagCompound) {
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	public void invUpdate(int i) {
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tagCompound) {
		super.writeToNBT(tagCompound);

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
	}

	@Override
	public String getInvName() {
		return "mod.vtsman_hodgecraft.shelfTE";
	}

	public boolean func_94042_c() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean func_94041_b(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInvNameLocalized() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		// TODO Auto-generated method stub
		return i == 6;
	}
	public int[] getAccessibleSlotsFromSide(int par1)
    {
		int[] bottom = {7};
		int[] other = {0, 1, 2, 3, 4, 5};
        return par1 == 0 ? other : bottom;
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1;
    }
}
