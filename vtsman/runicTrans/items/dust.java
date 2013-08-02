package vtsman.runicTrans.items;

import vtsman.runicTrans.tabs;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class dust extends Item{
	public static String[] names = {"Chalky", "Enriched", "Pulsating", "Infused", "Darkened", "Mysterious", "Sorcerer's", "Forged", "Enlightened"};
	public static String[] tex = {"chalk", "enriched", "pulsating", "infused", "darkened", "mysterious", "sorcerer", "forged", "enlightened"};
	public int i;
	public dust(int par1, int i) {
		super(par1);
		this.i = i;
		this.setCreativeTab(tabs.tabRune);
		this.setUnlocalizedName(names[i]);
		// TODO Auto-generated constructor stub
	}
	@Override
    public void registerIcons(IconRegister ir)
    {
		this.itemIcon = ir.registerIcon("runeTrans:" + tex[i]);
    }
}
