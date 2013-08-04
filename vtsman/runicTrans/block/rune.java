package vtsman.runicTrans.block;

import java.util.ArrayList;
import java.util.Random;

import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.chargeNode;
import vtsman.runicTrans.TE.findRune;
import vtsman.runicTrans.TE.transRuneTE;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class rune extends Block {

	public rune(int par1, Material par2Material) {
		super(par1, par2Material);
		float f = 1f / 16f;
		 this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
		// TODO Auto-generated constructor stub
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	public void onEntityCollidedWithBlock(World world, int par2, int par3,
			int par4, Entity e) {
		TileEntity rune = world.getBlockTileEntity(par2, par3, par4);
		if (!world.isRemote) {
			if(rune instanceof transRuneTE)
			((transRuneTE)rune).suck(e);
			if(rune instanceof findRune)
				((findRune) rune).accept(e);
		}
	}
	public int quantityDropped(int par1, Random par2Random)
    {
		return 0;
    }
	public int getRenderType() {
		return -1;
	}

	public void registerIcons(IconRegister ir) {
		this.blockIcon = Block.obsidian.getIcon(0, 0);
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

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		if (meta < 7) {
			transRuneTE t = new transRuneTE();
			return t;
		} else {
			return new findRune();
		}
	}
}
