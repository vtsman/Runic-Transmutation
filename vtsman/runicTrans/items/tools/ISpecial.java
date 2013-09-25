package vtsman.runicTrans.items.tools;

import net.minecraft.item.ItemStack;
import vtsman.runicTrans.items.IChargable;

public interface ISpecial {
	boolean add(int i, ItemStack s);

	int getRemaining(ItemStack s);

	boolean sub(int i, ItemStack s);
}
