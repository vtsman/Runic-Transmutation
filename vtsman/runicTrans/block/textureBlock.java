package vtsman.runicTrans.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;

public class textureBlock extends Block{
	public Icon[] icons = new Icon[16];
	public textureBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	public Icon getIcon(int par1, int par2)
    {
    	if(icons[par2] == null)
    		return icons[0];
    	return icons[par2];
    }
	public void registerIcons(IconRegister ir) {
		this.icons[1] = ir.registerIcon("runetrans:brick");
		this.icons[2] = ir.registerIcon("runetrans:tile");
		this.icons[3] = ir.registerIcon("runetrans:creep");
		this.icons[4] = ir.registerIcon("runetrans:sBrick");
		this.icons[5] = ir.registerIcon("runetrans:square");
		this.icons[6] = ir.registerIcon("runetrans:frame");
	}

}
