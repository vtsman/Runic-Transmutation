package vtsman.runicTrans.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class infusedStone extends Item{
	 public infusedStone(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	    public boolean doesContainerItemLeaveCraftingGrid(ItemStack item) {
		if(item.getTagCompound() == null){
			item.setTagCompound(new NBTTagCompound());	
			item.getTagCompound().setInteger("damage", 2);
		}
		item.stackTagCompound.setInteger("damage", item.stackTagCompound.getInteger("damage") - 1);
		if(item.stackTagCompound.getInteger("damage") == 0)item.itemID = modItems.dull.itemID;
		
	        return false;
	    }
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:infusedStone");
	}
}
