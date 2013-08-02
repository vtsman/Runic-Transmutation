package vtsman.runicTrans.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class intelStone extends Item{

	public intelStone(int par1) {
		super(par1);
		this.setUnlocalizedName("intelStone");
		// TODO Auto-generated constructor stub
	}
	@Override
    public void registerIcons(IconRegister ir)
    {
		this.itemIcon = ir.registerIcon("runeTrans:ec");
    }
}
