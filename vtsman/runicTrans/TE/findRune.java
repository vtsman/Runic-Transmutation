package vtsman.runicTrans.TE;

import java.util.Random;

import vtsman.runicTrans.transmute.transmuteManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class findRune extends TileEntity{
	public EntityItem e;
	public void accept(Entity e){
		if(e instanceof EntityItem){
			ItemStack s = ((EntityItem)e).getEntityItem();
			if(transmuteManager.RE.containsKey(s.itemID)){
				if(e != null){
				this.e = (EntityItem) e;
				return;
				}
			}
		}
		Random rand = new Random();
		e.setVelocity(rand.nextDouble() * 2 - 1d, 1, rand.nextDouble() * 2 - 1d);
	}
}
