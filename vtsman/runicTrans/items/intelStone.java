package vtsman.runicTrans.items;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.block.capacitor;
import vtsman.runicTrans.block.modBlocks;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class intelStone extends Item{

	public intelStone(int par1) {
		super(par1);
		this.setUnlocalizedName("intelStone");
		// TODO Auto-generated constructor stub
	}
	@Override
    public void registerIcons(IconRegister ir)
    {
		this.itemIcon = ir.registerIcon("runeTrans:ec");
    }
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		System.out.println(1);
		if(!world.isRemote){
			System.out.println(2);
			TileEntity te = world.getBlockTileEntity(x, y, z);
			System.out.println(te == null);
			if(te instanceof capacitorTE){
				System.out.println(3);
				player.addChatMessage("¤eThe stone seems to whipser to you");
				player.addChatMessage("¤b¤oThere is " + ((capacitorTE)te).RE + " energy");
			}
		}
		return true;
	}
}
