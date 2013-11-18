package vtsman.runicTrans.transmute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemStack;
import vtsman.vtsmcUtil.StackUtils;

public class transmuteManager {
	public static HashMap<Integer, Integer[]> RE = new HashMap<Integer, Integer[]>();
	public static HashMap<Integer, List<ItemStack>> REinv = new HashMap<Integer, List<ItemStack>>();

	public static ItemStack getNext(ItemStack i) {
		int re = getEnergy(i); // Gets Energy of item
		if (REinv.containsKey(re)) {
			List<ItemStack> list = REinv.get(re);
			if (list != null) {
				// Everything's OK?
				for (int j = 0; j < list.size(); j++) {
					if (i.itemID == list.get(j).itemID) {
						if (i.getItemDamage() == list.get(j).getItemDamage()) {

							// Found it!
							if (j == list.size() - 1) {
								return list.get(0);
							}
							return list.get(j + 1);
							// Returns next entry
						}
					}
				}
			}
		}
		return null; // Nothing found
	}

	public static ItemStack getNextBlock(ItemStack i) {
		ItemStack stack = i;
		if (RE.containsKey(i.itemID) && i.getItemDamage() < 16) {
			if (RE.get(i.itemID)[i.getItemDamage()] != 0) {
				for (int j = 0; j < REinv.get(
						RE.get(i.itemID)[i.getItemDamage()]).size(); j++) {
					stack = getNext(stack);
					if (StackUtils.hasBlock(stack)) {
						return stack;
					}
				}
			}
		}
		return null;
	}

	public static void add(int i, ItemStack s) {
		if (s.getItemDamage() < 16) {
			if (!RE.containsKey(s.itemID)) {
				RE.put(s.itemID, new Integer[16]);
				for (int x = 0; x < 16; x++) {
					RE.get(s.itemID)[x] = 0;
				}
			}
			RE.get(s.itemID)[s.getItemDamage()] = i;
			if (!REinv.containsKey(i)) {
				REinv.put(i, new ArrayList<ItemStack>());
			}
			REinv.get(i).add(s);
		}
	}

	public static int getEnergy(ItemStack s) {
		if (s != null) {
			if (RE.containsKey(s.itemID))
				return RE.get(s.itemID)[s.getItemDamage()];
		}
		return 0;
	}
}