package vtsman.runicTrans.items;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class timeSphere extends IChargable {

	public timeSphere(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int par7, float par8, float par9, float par10) {
		if (!world.isRemote) {
			if (stack.getTagCompound() == null) {
				stack.stackTagCompound = new NBTTagCompound();
				stack.getTagCompound().setInteger("cap", 0);
			}
			int id = world.getBlockId(x, y, z);
			if (id == Block.stoneBrick.blockID) {
				if (this.sub(10, stack))
					world.setBlockMetadataWithNotify(x, y, z,
							new Random().nextInt(3), 3);
			}
			if (id == Block.stone.blockID) {
				if (this.sub(10, stack)){
					world.setBlock(x, y, z, Block.cobblestone.blockID);
				}
			}
			if (id == Block.cobblestone.blockID) {
				if (this.sub(10, stack)){
					world.setBlock(x, y, z, Block.cobblestoneMossy.blockID);
				}
			}
		}
		return true;
	}

	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Time Sphere");
		if (stack.getTagCompound() != null) {
			if (stack.getTagCompound().hasKey("cap")) {
				list.add("§b§oThe time sphere has:");
						list.add("§b§o" + stack.getTagCompound().getInteger("cap")
						+ " out of 300 energy.");
			}
		}
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:timeSphere");
	}
}
