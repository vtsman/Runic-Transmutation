package vtsman.runicTrans.transmute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class transmuteManager {
	public static HashMap<Integer,Integer> e = new HashMap<Integer,Integer>();
	public static HashMap<Integer, ArrayList<Integer>> REinv = new HashMap<Integer, ArrayList<Integer>>();
public static ItemStack getNext(ItemStack i){
	System.out.println(REinv.get(4).get(1));
	System.out.println("RE: " + e.get(i.itemID));
	if(e.containsKey(i.itemID)){
		int re = e.get(i.itemID);
		ArrayList<Integer> array = REinv.get(re);
		for(int j = 0; j < REinv.get(re).size(); j++){
			if(array.get(j).intValue() == i.itemID){
				System.out.println("here");
				int k = 0;
				if(j == array.size() - 1)k = array.get(0);
				else k = array.get(j + 1);
				if(Block.blocksList[k] != null)return new ItemStack(Block.blocksList[k], 1);
				return new ItemStack(Item.itemsList[k], 1);
			}
			System.out.println(array.get(j).intValue() + "!=" + i.itemID);
		}
	}
	return(null);
}
public static void add(ItemStack st, int i){
	ItemStack s = st;
	 e.put(st.itemID, i);
	 if(REinv.containsKey(i)){
		 REinv.get(i).add(st.itemID);
	 }
	 else{
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(st.itemID);
		REinv.put(i, l);
	 }
}
}
