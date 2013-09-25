package vtsman.runicTrans.block;

import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.TE.IRelay;
import vtsman.runicTrans.TE.chargeNode;
import vtsman.runicTrans.items.IChargable;
import vtsman.runicTrans.items.modItems;
import vtsman.runicTrans.items.tools.ISpecial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class cNode extends Block {

	public cNode(int par1, Material par2Material) {
		super(par1, par2Material);

		// TODO Auto-generated constructor stub
	}

	public int getRenderType() {
		return -1;
	}

	public void registerIcons(IconRegister ir) {
		this.blockIcon = Block.obsidian.getIcon(0, 0);
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		return new chargeNode();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean onBlockActivated(World world, int x, int y, int z,
			EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (!world.isRemote) {
			chargeNode te = (chargeNode) world.getBlockTileEntity(x, y, z);
			ItemStack stack = player.getHeldItem();
			int chargeLevel = EnchantmentHelper.getEnchantmentLevel(baseMod.charge.effectId, stack);
			if(chargeLevel > 0){
				int maxCost = stack.getItemDamage() * 18 / chargeLevel;
				if(te.tile() != null){
					if(te.tile().remove(maxCost)){
						stack.setItemDamage(0);
					}
					else{
						int damageRem = te.getRE() / 18 * chargeLevel;
						System.out.println(damageRem);
						stack.setItemDamage(stack.getItemDamage() - damageRem);
						te.setRE(0);
					}
				}
			}
			if (stack != null && te.tile() != null) {
				if (stack.itemID == modItems.pulse.itemID) {
					if (te.tile() != null) {
						if (te.tile().remove(30 * stack.stackSize)) {
							stack.itemID = modItems.infused.itemID;
						}
					}
				}
				if (stack.itemID == Item.ingotGold.itemID) {
					if (te.tile() != null) {
						if (te.tile().remove(200 * stack.stackSize)) {
							stack.itemID = modItems.hexmetal.itemID;
						}
					}
				}
				if (stack.getItem() instanceof IChargable) {
					IChargable charge = (IChargable) stack.getItem();
					if (stack.getTagCompound() == null) {
						stack.stackTagCompound = new NBTTagCompound();
						stack.getTagCompound().setInteger("cap", 0);
					}
					if (charge.getRemaining(stack) > te.getRE()) {
						charge.add(te.getRE(), stack);
						te.tile().remove(te.getRE());
					} else {
						int c = charge.getRemaining(stack);
						charge.add(c, stack);
						te.tile().remove(c);
					}
				}
				if (stack.getItem() instanceof ISpecial) {
					ISpecial special = (ISpecial) stack.getItem();
					if (stack.getTagCompound() == null) {
						stack.stackTagCompound = new NBTTagCompound();
						stack.getTagCompound().setInteger("cap", 0);
					}
					if (special.getRemaining(stack) > te.getRE()) {
						special.add(te.getRE(), stack);
						te.tile().remove(te.getRE());
					} else {
						int c = special.getRemaining(stack);
						special.add(c, stack);
						te.tile().remove(c);
					}
				}
			}
		}
		return true;

	}
}
