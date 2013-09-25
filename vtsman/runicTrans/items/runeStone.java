package vtsman.runicTrans.items;

import java.util.List;

import vtsman.runicTrans.stackUtils;
import vtsman.runicTrans.TE.IRelay;
import vtsman.runicTrans.TE.transRuneTE;
import vtsman.runicTrans.transmute.transmuteManager;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class runeStone extends IChargable {

	public runeStone(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:runeStone");
	}

	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Rune Stone");
		if (stack.getTagCompound() == null) {
		stack.stackTagCompound = new NBTTagCompound();
		}
			if (!stack.getTagCompound().hasKey("cap")) {
				stack.stackTagCompound.setInteger("cap", 0);
			}
			
				list.add("The stone has "
						+ stack.getTagCompound().getInteger("cap")
						+ " out of 300 energy.");
		}

	boolean iMode = false;

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (stack.getTagCompound() == null) {
			stack.stackTagCompound = new NBTTagCompound();
			stack.getTagCompound().setInteger("cap", 0);
		}
		if (!world.isRemote) {
			System.out.println("here");
			TileEntity tile = world.getBlockTileEntity(x, y, z);
			if (tile instanceof IRelay) {
				player.addChatMessage("The stone seems to whipser to you");
				player.addChatMessage("There is " + ((IRelay) tile).getRE()
						+ " energy");
			}
			if (player.isSneaking()) {
				int meta = world.getBlockMetadata(x, y, z);
				if (meta < 7) {
					if (tile != null) {
						if (tile instanceof transRuneTE) {
							transRuneTE te = (transRuneTE) world
									.getBlockTileEntity(x, y, z);
							if (player.getHeldItem().itemID == modItems.rStone.itemID) {
								if (te.tile != null && te.find != null) {
									if (te.find.e != null) {
										ItemStack s = te.find.e.getEntityItem();
										int i = transmuteManager.getEnergy(s);
										if (te.getMax[meta] >= i
												|| te.getMax[meta] == 0) {
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
												return true;
											}
										}
									}
								}
							}
						}
					}
				}
				this.iMode = !this.iMode;
				if (iMode)
					player.addChatMessage("Item transmutation mode enabled");
				else
					player.addChatMessage("Item transmutation mode disabled");
				return true;
			}
		}
		if (world.getBlockTileEntity(x, y, z) == null) {
			ItemStack s = new ItemStack(world.getBlockId(x, y, z), 1,
					world.getBlockMetadata(x, y, z));
			if (!iMode) {
				ItemStack st = transmuteManager.getNextBlock(s);
				if (st != null) {
					int re = transmuteManager.getEnergy(s);
					if (this.sub(re / 2, stack)) {

						world.setBlock(x, y, z, st.itemID);
						world.setBlockMetadataWithNotify(x, y, z,
								st.getItemDamage(), 2);
					}
				}
			} else {
				ItemStack st = transmuteManager.getNext(s);
				if (st != null) {
					int re = transmuteManager.getEnergy(s);
					if (this.sub(re / 2, stack)) {
						if (stackUtils.hasBlock(st)) {
							world.setBlock(x, y, z, st.itemID);
							world.setBlockMetadataWithNotify(x, y, z,
									st.getItemDamage(), 2);
						} else {
							world.setBlockToAir(x, y, z);
							EntityItem out = new EntityItem(world,
									player.lastTickPosX, player.lastTickPosY,
									player.lastTickPosZ, st);
							world.spawnEntityInWorld(out);
						}
					}
				}
			}
		}
		return false;
	}
}
