package vtsman.runicTrans;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class stackUtils {
	public static ItemStack[] sizer(ItemStack[] input, int size) {
		ItemStack[] stack = input;
		if (input != null) {
			for (int i = 0; i < stack.length; i++) {
				if (stack[i] != null) {
					stack[i].stackSize = size;
				}
			}
		}
		return stack;
	}

	public static boolean stackEquals(ItemStack s1, ItemStack s2) {
		return (s1.stackSize == s2.stackSize) && (s1.itemID == s2.itemID)
				&& (s1.getItemDamage() == s2.getItemDamage());
	}

	public static boolean canStack(ItemStack s1, ItemStack s2) {
		return (s1.itemID == s2.itemID)
				&& (s1.getItemDamage() == s2.getItemDamage());

	}
	public static boolean hasBlock(ItemStack s){
		String name = Item.itemsList[s.itemID].getUnlocalizedName();
		System.out.println(name.substring(0, 4));
		if(name.substring(0, 4).matches("item")){
			System.out.println("item");
			return false;
		}
		return true;
	}
}
