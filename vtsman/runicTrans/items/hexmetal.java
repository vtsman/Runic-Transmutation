package vtsman.runicTrans.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class hexmetal extends Item{

	public hexmetal(int par1) {
		super(par1);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:hexmetal");
	}
}
