package vtsman.runicTrans.items;

import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import vtsman.runicTrans.stackUtils;

public class fireRod extends IChargable {

	public fireRod(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
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
				int id = world.getBlockId(x, y, z);
				int meta = world.getBlockMetadata(x, y, z);
				ItemStack s = new ItemStack(id, 1, meta);
				if (s != null) {
					ItemStack out = FurnaceRecipes.smelting()
							.getSmeltingResult(s);
					if (out != null) {
						if (this.sub(10, stack)) {
							if (stackUtils.hasBlock(out)) {
								world.setBlock(x, y, z, out.itemID,
										out.getItemDamage(), 2);
							} else {
								world.setBlockToAir(x, y, z);
								EntityItem e = new EntityItem(world,
										player.lastTickPosX,
										player.lastTickPosY,
										player.lastTickPosZ, out.copy());
								world.spawnEntityInWorld(e);
							}
						}
					}
					/*
					 * else{ int slot = 100; for(int i = 0; i < 36; i++){
					 * if(player.inventory.mainInventory[i] != null){
					 * if(player.inventory.mainInventory[i].itemID ==
					 * Item.stick.itemID){ slot = i; } } } if(slot != 100){
					 * player.inventory.mainInventory[slot].stackSize--;
					 * if(player.inventory.mainInventory[slot].stackSize ==
					 * 0)player.inventory.mainInventory[slot] = null; int[]
					 * coords = {x, y, z}; int m = 0; switch(side){ case 0:
					 * coords[1]--; m = 0; case 1: coords[1]++; case 2:
					 * coords[2]++; case 3: coords[2]--; case 4: coords[0]--;
					 * case 5: coords[0]++; } if(canPlaceBlockAt(world,
					 * coords[0], coords[1], coords[2])){
					 * world.setBlock(coords[0], coords[1], coords[2],
					 * Block.torchWood.blockID); onBlockPlaced }
					 * if(canPlaceBlockAt(world, x, y , z)){
					 * world.setBlock(coords[0], coords[1], coords[2],
					 * Block.torchWood.blockID); onBlockAdded(world, coords[0],
					 * coords[1], coords[2]); } } }
					 */
				}
			}
		}
		return true;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Fire Rod");
		if (stack.getTagCompound() == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (!stack.getTagCompound().hasKey("cap")) {
			stack.stackTagCompound.setInteger("cap", 0);
		}

		list.add("This wand has " + stack.getTagCompound().getInteger("cap")
				+ " out of 300 energy.");
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:fireRod");
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)
				|| par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,
						true)
				|| par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH,
						true)
				|| par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH,
						true)
				|| canPlaceTorchOn(par1World, par2, par3 - 1, par4);
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */

	private boolean canPlaceTorchOn(World par1World, int par2, int par3,
			int par4) {
		if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4)) {
			return true;
		} else {
			int l = par1World.getBlockId(par2, par3, par4);
			return Block.blocksList[l] != null
					&& Block.blocksList[l].canPlaceTorchOnTop(par1World, par2,
							par3, par4);
		}
	}

	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		if (par1World.getBlockMetadata(par2, par3, par4) == 0) {
			if (par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 1, 2);
			} else if (par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,
					true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 - 1,
					SOUTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
			} else if (par1World.isBlockSolidOnSide(par2, par3, par4 + 1,
					NORTH, true)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
			} else if (this.canPlaceTorchOn(par1World, par2, par3 - 1, par4)) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
			}
		}
	}

}
