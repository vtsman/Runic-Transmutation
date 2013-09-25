package vtsman.runicTrans.TE;

import net.minecraft.item.ItemStack;

public interface IMorter {
ItemStack getResult(ItemStack[] s);
boolean canCraft(ItemStack[] s);
}
