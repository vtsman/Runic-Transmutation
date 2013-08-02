package vtsman.runicTrans.items;

import vtsman.runicTrans.tabs;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if(world.isRemote){
		if(i == 4 && world.getBlockId(x, y, z) == Block.dragonEgg.blockID && player.getHeldItem() != null){
			if(player.getHeldItem().itemID == modItems.dark.itemID){
				player.getHeldItem().itemID = modItems.myst.itemID;
			}
		}
		}
        return true;
    }
}
