package vtsman.runicTrans.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import vtsman.runicTrans.baseMod;

public class mortar extends Block {
	Icon morttop;
	Icon centri;

	public mortar(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasTileEntity(int m) {
		return true;
	}

	@Override
	public TileEntity createTileEntity(World world, int meta) {
		switch (meta) {
			case 1:
				return new vtsman.runicTrans.TE.centriTE();
			default:
				return new vtsman.runicTrans.TE.mortar();
		}
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		if (par2 == 0) {
			if (par1 == 1) {
				return this.morttop;
			}
			return Block.stoneBrick.getIcon(0, 0);
		}
		return this.centri;
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.morttop = ir.registerIcon("runetrans:MortTop");
		this.centri = ir.registerIcon("runetrans:centri");
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer player, int i1, float f1, float f2, float f3) {
		int Meta = world.getBlockMetadata(i, j, k);
		System.out.println(Meta);
		TileEntity te = world.getBlockTileEntity(i, j, k);
		switch (Meta) {
			case 0:
				player.openGui(baseMod.instance, baseMod.guiMorter, world, i,
						j, k);
			case 1:
				player.openGui(baseMod.instance, baseMod.guiCentri, world, i,
						j, k);
				System.out.println("here");
		}
		return true;
	}

	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs,
			List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}
}
