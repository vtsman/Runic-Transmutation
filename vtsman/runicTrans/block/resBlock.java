package vtsman.runicTrans.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import vtsman.runicTrans.baseMod;
import vtsman.runicTrans.TE.multiblock.researchMultiblock;

public class resBlock extends Block {

	public resBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon("runetrans:research");
	}

	@Override
	public boolean onBlockActivated(World world, int i, int j, int k,
			EntityPlayer player, int i1, float f1, float f2, float f3) {
		if (researchMultiblock.isMultiblockValid(world, i, j, k)) {
			System.out.println("here");
			player.openGui(baseMod.instance, baseMod.guiResearch, world, i, j,
					k);
		}
		return true;
	}
}
