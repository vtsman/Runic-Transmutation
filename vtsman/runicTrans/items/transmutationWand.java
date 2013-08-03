package vtsman.runicTrans.items;

import java.util.List;

import vtsman.runicTrans.transmute.transmuteManager;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class transmutationWand extends IChargable {
	public transmutationWand(int par1) {
		super(par1);
		this.maxStackSize = 1;
		// TODO Auto-generated constructor stub
	}

	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Transmutation Wand");
		if (stack.getTagCompound() != null) {
			if (stack.getTagCompound().hasKey("cap")) {
				list.add("§b§oThis wand has "
						+ stack.getTagCompound().getInteger("cap")
						+ " out of 300 energy.");
			}
		}
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if (stack.getTagCompound() == null) {
				stack.stackTagCompound = new NBTTagCompound();
				stack.getTagCompound().setInteger("cap", 0);
			}
			if (!player.isSneaking()) {
				if (world.getBlockTileEntity(x, y, z) == null) {
					ItemStack s = new ItemStack(world.getBlockId(x, y, z), 1,
							world.getBlockMetadata(x, y, z));
					ItemStack st = transmuteManager.getNext(s);
					System.out.println(st);
					if (st != null) {
						int re = transmuteManager.getEnergy(s);
						if (transmutationWand.sub(re / 2, stack)) {

							world.setBlock(x, y, z, st.itemID);
							world.setBlockMetadataWithNotify(x, y, z,
									st.getItemDamage(), 2);
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:transWand");
	}

}
