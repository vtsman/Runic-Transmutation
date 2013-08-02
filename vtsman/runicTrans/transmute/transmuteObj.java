package vtsman.runicTrans.transmute;

import java.util.ArrayList;
import java.util.List;

import vtsman.runicTrans.stackUtils;

import net.minecraft.item.ItemStack;

public class transmuteObj {
public List<ItemStack> l = new ArrayList<ItemStack>();
public transmuteObj(){
	
}
public void add(ItemStack i){
	this.l.add(i);
}
public ItemStack getNext(ItemStack i){
	for(int j = 0; j < l.size(); j++){
		if(stackUtils.canStack(l.get(j), i)){
			if(j == l.size() - 1)return l.get(0);
			return l.get(j + 1);
		}
	}
	return null;
}
}
