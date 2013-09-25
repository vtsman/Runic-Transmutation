package vtsman.runicTrans.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vtsman.runicTrans.TE.capacitorTE;

public class debug extends Item {
	public debug(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			System.out.println(world.getBlockId(x, y, z) + ":"
					+ world.getBlockMetadata(x, y, z));
			TileEntity te = world.getBlockTileEntity(x, y, z);
			if (te instanceof capacitorTE) {
				((capacitorTE) te).add(100);
			}
		}
		return true;
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:debug");
	}
}
