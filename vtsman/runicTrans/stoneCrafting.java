package vtsman.runicTrans;

import java.util.List;

import vtsman.runicTrans.items.modItems;
import vtsman.runicTrans.transmute.transmuteManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import cpw.mods.fml.common.ICraftingHandler;

public class stoneCrafting implements IRecipe{
boolean hasStone = false;
boolean twoItems = false;
ItemStack Transmuting;
ItemStack out;
int itemcount = 0;
public stoneCrafting(){

}
	@Override
	public boolean matches(InventoryCrafting i, World world) {
		hasStone = false;
		twoItems = false;
		out = null;
		Transmuting = null;
		itemcount = 0;
		for(int j = 0; j < 9; j++){
			if(i.getStackInSlot(j) != null){
		if((i.getStackInSlot(j)).itemID == modItems.rStone.itemID)hasStone = true;
			}
			}
		for(int j = 0; j < 9; j++){
			if(i.getStackInSlot(j) != null){
				if((i.getStackInSlot(j)).itemID != modItems.rStone.itemID)Transmuting = i.getStackInSlot(j);
			}
		}
		for(int j = 0; j < 9; j++){
			if(i.getStackInSlot(j) != null){
			itemcount++;
			}
		}
		if(itemcount == 2)this.twoItems = true;
		if(twoItems && hasStone){
			out = transmuteManager.getNext(Transmuting);
		return true;
		}
		else{
		out = null;
		return false;
		}
	}
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		return out.copy();
	}
	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 10;
	}
	@Override
	public ItemStack getRecipeOutput() {
		return out;
	}

}
