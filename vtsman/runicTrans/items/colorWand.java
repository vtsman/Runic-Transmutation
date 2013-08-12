package vtsman.runicTrans.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.colorable;
import vtsman.runicTrans.TE.transRuneTE;

public class colorWand extends Item {
	int color = 0xFFFFFF;
	int r = 0xFF;
	int g = 0xFF;
	int b = 0xFF;
	public colorWand(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te instanceof colorable) {
				if(player.isSneaking()){
				color = ((colorable)te).color;
				r = ((colorable)te).r;
				g = ((colorable)te).g;
				b = ((colorable)te).b;
				System.out.println(color);
				}
				else{
					((colorable)te).color = color;
					((colorable)te).r = r;
					((colorable)te).g = g;
					((colorable)te).b = b;
					world.markBlockForRenderUpdate(x, y, z);
				}
			}
		return true;
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:colorWand");
	}
}
