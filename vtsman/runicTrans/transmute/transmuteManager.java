package vtsman.runicTrans.transmute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class transmuteManager {
	public static HashMap<Integer,Integer> e = new HashMap<Integer,Integer>();
	public static HashMap<Integer, ArrayList<Integer>> REinv = new HashMap<Integer, ArrayList<Integer>>();
public static ItemStack getNext(ItemStack i){
	System.out.println("RE: " + e.get(i.itemID));
	if(e.containsKey(i.itemID)){
		for(int j = 0; j < REinv.size(); j++){
			if(REinv.get(e.get(i.itemID)).get(j) == i.itemID){
				ArrayList<Integer> l = REinv.get(e.get(i.itemID));
				if(j == REinv.size() - 1)return new ItemStack(Block.blocksList[l.get(1)], 1);
				return new ItemStack(Block.blocksList[l.get((j + 1))], 1);
			}
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
