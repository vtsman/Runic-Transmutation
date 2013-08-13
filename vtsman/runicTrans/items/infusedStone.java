package vtsman.runicTrans.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
public class infusedStone extends Item{
	public static int[] dustMax = new int[] { 4, 20, 30, 80, 160, 320, 100000, 0, 0};
	
	public infusedStone(int par1) {
		super(par1);
		this.setMaxStackSize(1);
		// TODO Auto-generated constructor stub
	}
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		ItemStack stack = new ItemStack(par1, 1, 0); 
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound tag = stack.getTagCompound();
		tag.setIntArray("Dusts", new int[] {6, 6, 6, 6});
        par3List.add(stack);
    }
	@Override
    public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer, List list, boolean par4) {
		list.clear();
		list.add("Infused Stone");
		if(stack.getTagCompound() != null){
			int[] s = stack.getTagCompound().getIntArray("Dusts");
			for(int i = 0; i < 4; i++){
				list.add("§e" + dust.names[s[i]] + " Dust");
			}
		}
	}
	  public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1ItemStack)
	  {
	    return false;
	  }
	private int getMaxTransmute(NBTTagCompound tag){
		if(tag != null){
			int[] damages = tag.getIntArray("Dusts");
			int max = 0;
			for(int i = 0; i < 4; i++){
				max += dustMax[damages[i]];
			}
			return max/4;
		}
		return 0;
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:infusedStone");
	}
}
