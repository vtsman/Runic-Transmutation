package vtsman.runicTrans.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Magical Paintbrush");
		if (stack.getTagCompound() == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (!stack.getTagCompound().hasKey("r")) {
			stack.stackTagCompound.setInteger("r", 0xFF);
		}
		if (!stack.getTagCompound().hasKey("g")) {
			stack.stackTagCompound.setInteger("g", 0xFF);
		}
		if (!stack.getTagCompound().hasKey("b")) {
			stack.stackTagCompound.setInteger("b", 0xFF);
		}

		list.add("Red: " + stack.stackTagCompound.getInteger("r"));
		list.add("Green: " + stack.stackTagCompound.getInteger("g"));
		list.add("Blue: " + stack.stackTagCompound.getInteger("b"));
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te instanceof colorable) {
			if (player.isSneaking()) {
				color = ((colorable) te).color;
				r = ((colorable) te).r;
				g = ((colorable) te).g;
				b = ((colorable) te).b;
				stack.stackTagCompound.setInteger("r", r);
				stack.stackTagCompound.setInteger("g", g);
				stack.stackTagCompound.setInteger("b", b);
			}
			
			else {
				r = stack.stackTagCompound.getInteger("r");
				g = stack.stackTagCompound.getInteger("g");
				b = stack.stackTagCompound.getInteger("b");
				((colorable) te).color = color;
				((colorable) te).r = r;
				((colorable) te).g = g;
				((colorable) te).b = b;
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
