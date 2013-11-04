package vtsman.runicTrans.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import vtsman.runicTrans.client.particals.particalRenderer;

public class particalBlock extends Block {

	public particalBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
			int par2, int par3, int par4) {
		return null;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random r) {
		particalRenderer.spawnParticle("testPart", x, y, z, 0, 0, 0);
	}

}
