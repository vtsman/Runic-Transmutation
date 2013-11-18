package vtsman.runicTrans.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import vtsman.runicTrans.TE.colorable;
import vtsman.vtsmcUtil.ColorUtils;

public class colorWand extends Item {
	int color = 0xFFFFFF;

	public colorWand(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Magical Paintbrush");
		if (stack.getTagCompound() == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (!stack.getTagCompound().hasKey("color")) {
			stack.stackTagCompound.setInteger("color", 0xFFFFFF);
		}
		int[] rgb = ColorUtils.splitColor(stack.stackTagCompound
				.getInteger("color"));
		int r = rgb[0];
		int g = rgb[1];
		int b = rgb[2];
		list.add("Red: " + r);
		list.add("Green: " + g);
		list.add("Blue: " + b);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof colorable) {

			if (player.isSneaking()) {
				int[] rgb = ColorUtils.splitColor(((colorable) te).color);
				int r = rgb[0];
				int g = rgb[1];
				int b = rgb[2];
				color = ((colorable) te).color;
				stack.stackTagCompound.setInteger("color", color);
			}

			else {
				this.color = stack.stackTagCompound.getInteger("color");
				((colorable) te).color = color;
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
