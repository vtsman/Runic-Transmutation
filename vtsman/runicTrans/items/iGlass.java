package vtsman.runicTrans.items;

import vtsman.runicTrans.block.modBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class iGlass extends ItemBlockWithMetadata{
	public static String[] hex = {"hGlass", "shGlass"};
	public static String[] anim = {"iBlock", "iBrick", "iTile", "iCreep", "iOre", "iSquare", "iV"};
	public iGlass(int par1, Block par2Block) {
		super(par1, par2Block);
		// TODO Auto-generated constructor stub
	}
	public String getUnlocalizedName(ItemStack stack)
    {
		if(stack.itemID == modBlocks.hex.blockID){
			return super.getUnlocalizedName() + "." + hex[stack.getItemDamage()];
		}
		else if(stack.itemID == modBlocks.animBlock.blockID){
			return super.getUnlocalizedName() + "." + anim[stack.getItemDamage()];
		}
	else{
        return super.getUnlocalizedName();
    }
    }
}
