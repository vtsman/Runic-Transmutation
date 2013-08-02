package vtsman.runicTrans.block;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.chargeNode;
import vtsman.runicTrans.items.modItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class cNode extends Block{

	public cNode(int par1, Material par2Material) {
		super(par1, par2Material);
		
		// TODO Auto-generated constructor stub
	}
	public int getRenderType(){
		return -1;
	}
	public void registerIcons(IconRegister ir)
    {
		this.blockIcon = Block.obsidian.getIcon(0, 0);
    }
	@Override
	public TileEntity createTileEntity(World world, int meta)
    {
		return new chargeNode();
    }
	public boolean isOpaqueCube()
	{
	return false;
	}
	@Override
	public boolean hasTileEntity(int metadata)
	{
	  return true;
	}
	/**
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/
	public boolean renderAsNormalBlock()
	{
	return false;
	}
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		if(!world.isRemote){
		chargeNode te = (chargeNode)world.getBlockTileEntity(x, y, z);
		ItemStack stack = player.getHeldItem();
		if(stack != null){
		if(stack.itemID == modItems.pulse.itemID){
			if(te.tile != null){
			if(te.tile.remove(30 * stack.stackSize)){
			stack.itemID = modItems.infused.itemID;
			}
			}
		}
		}
		}
        return true;
		
    }
}
