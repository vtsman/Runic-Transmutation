package vtsman.runicTrans.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class transmutationWand extends Item implements IChargable{
	int maxCap = 300;
	int cap = 0;
	public transmutationWand(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean add(int i) {
		
		if(cap + i > maxCap)return false;
		cap = cap + i;
		return true;
	}
	public void getCap(ItemStack s){
		if(s.getTagCompound().hasKey("cap")){
			this.cap = s.getTagCompound().getInteger("cap");
		}
	}
	@Override
	public boolean sub(int i) {
		if(cap - i < 0)return false;
		cap = cap - i;
		return true;
	}

	@Override
	public int getCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setTag(ItemStack s) {
		// TODO Auto-generated method stub
		s.getTagCompound().setInteger("cap", this.cap);
	}

}
