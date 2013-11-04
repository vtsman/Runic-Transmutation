package vtsman.runicTrans.TE;

import vtsman.runicTrans.utils.stackUtils;
import net.minecraft.item.ItemStack;

public class shapelessMortar implements IMorter{
	public ItemStack[] stacks;
	public ItemStack res;
	public shapelessMortar(ItemStack s, ItemStack ... stacks){
	this.stacks = stacks;	
	res = s;
	}
	@Override
	public ItemStack getResult(ItemStack[] s) {
		return res.copy();
	}

	@Override
	public boolean canCraft(ItemStack[] s) {
		int right = 0;
		int length = 0;
		
		for(int i = 0; i < s.length; i++){
			if(s[i] != null)
				length++;
		}
		if(stacks.length == length){
			boolean[] used = new boolean[s.length];
			for(int i = 0; i < s.length; i++)
				used[i] = false;
		for(int i = 0; i < stacks.length; i++){
			for(int j = 0; j < s.length; j++){
				if(!used[j])
				if(stackUtils.canStack(s[j], stacks[i])){
					right++;
					used[j] = true;
					break;
				}
			}
		}
		}
		return right == stacks.length;
	}

}
