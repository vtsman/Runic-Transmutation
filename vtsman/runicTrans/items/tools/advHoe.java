package vtsman.runicTrans.items.tools;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class advHoe extends ItemHoe {

	public advHoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	public ItemStack decrStack(ItemStack stack) {
		if (stack.stackSize - 1 == 0) {
			stack = null;
		} else {
			stack.stackSize--;
		}
		return stack;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int n, float par8, float par9, float par10) {
		// if (world.getBlockId(x, y, z) == Block.tilledField.blockID) {
		if (!world.isRemote) {
			boolean seeds = false;
			boolean meal = false;
			int sinv = 0;
			int binv = 0;
			for (int i = 0; i < player.inventory.mainInventory.length; i++) {
				if (player.inventory.mainInventory[i] != null) {
					if (player.inventory.mainInventory[i].itemID == Item.seeds.itemID) {
						seeds = true;
						sinv = i;
						// break;
					}
					if (player.inventory.mainInventory[i].itemID == Item.dyePowder.itemID) {
						System.out.println(1);
						meal = true;
						binv = i;
						// break;
					}
				}
			}
			if (seeds && world.getBlockId(x, y, z) == Block.tilledField.blockID) {
				player.inventory.mainInventory[sinv] = decrStack(player.inventory.mainInventory[sinv]);
				world.setBlock(x, y + 1, z, Block.crops.blockID);
				return true;
			} else if (meal && world.getBlockId(x, y, z) != Block.dirt.blockID
					&& world.getBlockId(x, y, z) != Block.grass.blockID) {
				if (ItemDye.applyBonemeal(new ItemStack(Item.dyePowder, 1, 15),
						world, x, y, z, player)) {
					player.inventory.mainInventory[binv] = decrStack(player.inventory.mainInventory[binv]);
					return true;
				}
			}
			// }
			super.onItemUse(stack, player, world, x, y, z, n, par8, par9, par10);
			
		}
		player.onUpdate();
		return true;
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:advhoe");
	}
}
