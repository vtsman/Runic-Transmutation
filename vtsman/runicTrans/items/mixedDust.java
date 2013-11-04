package vtsman.runicTrans.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import vtsman.runicTrans.aspect.AspectRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class mixedDust extends Item {
	public ItemStack[] inv = new ItemStack[6];
	int color;

	public mixedDust(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int par2) {
		readFromNBT(stack.stackTagCompound);
		// System.out.println(colorUtils.constColor(0xFF, 0x00, 0xd0));
		return color;
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		ItemStack[] stacks = new ItemStack[2];
		stacks[0] = new ItemStack(Block.cobblestone, 1, 0);
		stacks[1] = new ItemStack(Block.netherrack, 5, 0);
		ItemStack out = new ItemStack(par1, 1, 0);
		out.stackTagCompound = new NBTTagCompound();
		this.writeToNBT(out.stackTagCompound, stacks);
		par3List.add(out);
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:white");
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Mixed Dust");
		if (stack.stackTagCompound == null) {
			stack.stackTagCompound = new NBTTagCompound();
			writeToNBT(stack.stackTagCompound);
		}
		this.readFromNBT(stack.stackTagCompound);
		for (ItemStack s : inv) {
			if (s != null) {
				list.add(s.stackSize + " "
						+ s.getItem().getItemStackDisplayName(s));
			}
		}
	}

	public void readFromNBT(NBTTagCompound tagCompound) {

		NBTTagList tagList = tagCompound.getTagList("Inventory");
		for (int i = 0; i < tagList.tagCount(); i++) {
			NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inv.length) {
				inv[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
		this.color = tagCompound.getInteger("Color");
	}

	public static ItemStack[] readFromNBTStat(NBTTagCompound tagCompound) {
		if (tagCompound != null) {
			NBTTagList tagList = tagCompound.getTagList("Inventory");
			ItemStack[] out = new ItemStack[6];
			for (int i = 0; i < tagList.tagCount(); i++) {
				NBTTagCompound tag = (NBTTagCompound) tagList.tagAt(i);
				byte slot = tag.getByte("Slot");
				if (slot >= 0 && slot < out.length) {
					out[slot] = ItemStack.loadItemStackFromNBT(tag);
				}
			}
			return out;
		}
		ItemStack[] out = new ItemStack[6];
		return out;
	}

	public void writeToNBT(NBTTagCompound tagCompound) {

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < inv.length; i++) {
			ItemStack stack = inv[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tagCompound.setInteger("Color", AspectRegistry
				.getColorFromAspects(AspectRegistry
						.getAspectsFromStacksArr(inv)));
	}

	public static void writeToNBT(NBTTagCompound tagCompound, ItemStack[] stacks) {

		NBTTagList itemList = new NBTTagList();
		for (int i = 0; i < stacks.length; i++) {
			ItemStack stack = stacks[i];
			if (stack != null) {
				NBTTagCompound tag = new NBTTagCompound();
				tag.setByte("Slot", (byte) i);
				stack.writeToNBT(tag);
				itemList.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", itemList);
		tagCompound.setInteger("Color", AspectRegistry
				.getColorFromAspects(AspectRegistry
						.getAspectsFromStacksArr(stacks)));
	}
}
