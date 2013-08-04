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
		System.out.println(i != null);
		return this.getCraftingResult(i) != null;
	}
	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventorycrafting) {
		hasStone = false;
		twoItems = false;
		out = null;
		Transmuting = null;
		itemcount = 0;
		for(int i = 0; i < 9; i++){
			if(inventorycrafting.getStackInSlot(i) != null){
		if((inventorycrafting.getStackInSlot(i)).itemID == modItems.iStone.itemID)hasStone = true;
			}
			}
		for(int i = 0; i < 9; i++){
			if(inventorycrafting.getStackInSlot(i) != null){
				if((inventorycrafting.getStackInSlot(i)).itemID != modItems.iStone.itemID)Transmuting = inventorycrafting.getStackInSlot(i);
			}
		}
		for(int i = 0; i < 9; i++){
			if(inventorycrafting.getStackInSlot(i) != null){
			itemcount++;
			}
		}
		if(itemcount == 2)this.twoItems = true;
		if(twoItems && hasStone){
			System.out.println("here");
			out = transmuteManager.getNext(Transmuting);
		return out;
		}
		out = null;
		return null;
	}
	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 9;
	}
	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		//return transmuteManager.getNext(Transmuting);
		return out.copy();
	}

}
