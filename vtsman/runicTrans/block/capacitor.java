package vtsman.runicTrans.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class capacitor extends Block{

	public capacitor(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setUnlocalizedName("capacitorRune");
		// TODO Auto-generated constructor stub
	}
	public void registerIcons(IconRegister ir)
    {
		this.blockIcon = ir.registerIcon("runetrans:cap");
    }
	//todo add TE
}
