package vtsman.runicTrans.items;

import vtsman.runicTrans.block.modBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class iGlass extends ItemBlockWithMetadata{
	public iGlass(int par1, Block par2Block) {
		super(par1, par2Block);
		// TODO Auto-generated constructor stub
	}
	public String getUnlocalizedName(ItemStack stack)
    {
			return super.getUnlocalizedName() + "." + stack.getItemDamage();
    }
}
