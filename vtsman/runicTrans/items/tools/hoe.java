package vtsman.runicTrans.items.tools;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.*;

public class hoe extends ItemHoe{

	public hoe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:hoe");
	}
}
