package vtsman.runicTrans.items;

import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.transmute.transmuteManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class runeStone extends Item {

	public runeStone(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:runeStone");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (player.isSneaking()) {
				int meta = world.getBlockMetadata(x, y, z);
				if (meta < 7) {
					TileEntity tile = world.getBlockTileEntity(x, y, z);
					if (tile != null) {
						if (tile instanceof transRuneTE) {
							transRuneTE te = (transRuneTE) world
									.getBlockTileEntity(x, y, z);
							if (player.getHeldItem().itemID == modItems.rStone.itemID) {
								if (te.tile != null && te.find != null) {
									if (te.find.e != null) {
										ItemStack s = te.find.e.getEntityItem();
										int i = transmuteManager.getEnergy(s);
										if (te.getMax[meta] >= i || te.getMax[meta] == 0) {
											if (te.tile.remove(i * 64)) {
												ItemStack st = s.copy();
												st.stackSize = 64;
												EntityItem e = new EntityItem(
														world,
														(double) player.lastTickPosX,
														(double) player.lastTickPosY,
														(double) player.lastTickPosZ,
														st.copy());
												world.spawnEntityInWorld(e);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}
}
