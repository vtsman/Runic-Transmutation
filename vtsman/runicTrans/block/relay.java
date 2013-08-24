package vtsman.runicTrans.block;

import vtsman.runicTrans.TE.colorable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class relay extends Block{

	public relay(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	 @Override
 	public TileEntity createTileEntity(World world, int meta) {
 		return new vtsman.runicTrans.TE.relay();
 	}
	 @Override
		public boolean hasTileEntity(int m) {
			return true;
		}
}
