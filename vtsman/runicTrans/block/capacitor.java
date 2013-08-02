package vtsman.runicTrans.block;

import vtsman.runicTrans.TE.capacitorTE;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class capacitor extends Block{

	public capacitor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("capacitorRune");
		this.setLightValue(.8f);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean hasTileEntity(int m){
		return true;
	}
	public void registerIcons(IconRegister ir)
    {
		this.blockIcon = ir.registerIcon("runetrans:cap");
    }
	@Override
	public TileEntity createTileEntity(World world, int meta)
    {
		return new capacitorTE();
    }
	//todo add TE
}
