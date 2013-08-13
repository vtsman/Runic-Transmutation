package vtsman.runicTrans.block;

import vtsman.runicTrans.packetHandler;
import vtsman.runicTrans.TE.capacitorTE;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class capacitor extends BlockContainer {

	public capacitor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("capacitorRune");
		this.setLightValue(.8f);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean hasTileEntity(int m) {
		return true;
	}

	public void registerIcons(IconRegister ir) {
		this.blockIcon = ir.registerIcon("runetrans:cap");
	}
	// todo add TE

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new capacitorTE();
	}
}
