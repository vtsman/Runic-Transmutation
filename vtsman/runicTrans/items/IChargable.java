package vtsman.runicTrans.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class IChargable extends Item {
	public int maxCap = 300;

	public IChargable(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	public boolean add(int i, ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		if (cap + i > maxCap)
			return false;
		cap = cap + i;
		s.getTagCompound().setInteger("cap", cap);
		return true;
	}

	public static int getRemaining(ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		return ((IChargable) s.getItem()).maxCap - cap;
	}

	public static boolean sub(int i, ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		if (cap - i < 0)
			return false;
		cap = cap - i;
		s.getTagCompound().setInteger("cap", cap);
		return true;
	}
}
