package vtsman.runicTrans.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.*;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class diveShovel extends ItemSpade implements ISpecial {
	int maxCap = 1000;
	
	boolean special = true;

	public diveShovel(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	int coolDown = 20;
	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Diver's Shovel");
		if (stack.getTagCompound() == null) {
		stack.stackTagCompound = new NBTTagCompound();
		}
			if (!stack.getTagCompound().hasKey("cap")) {
				stack.stackTagCompound.setInteger("cap", 0);
			}
			
				list.add("This shovel has "
						+ stack.getTagCompound().getInteger("cap")
						+ " out of 1000 energy.");
		}
	public void toggle(EntityPlayer p){
		if(p.isSneaking()){
			special = !special;
		if(special)
			p.addChatMessage("Enabled potion effect");
		else
			p.addChatMessage("Disabled potion effect");
		}
	}
	boolean c = true;
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if(c){
		toggle(player);
		c = false;
		}
		else{
			c = true;
		}
		return true;
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:divespade");
	}
	public void onUpdate(ItemStack item, World world, Entity entity, int par4,
			boolean par5) {
		if(item.stackTagCompound != null)
		if (entity instanceof EntityPlayerMP
				&& ((EntityPlayerMP) entity).getCurrentEquippedItem() == item) {
			if (special) {
				if (coolDown == 0) {
					if (this.sub(5, item)) {
						((EntityPlayerMP) entity)
								.addPotionEffect(new PotionEffect(
										Potion.waterBreathing.getId(), 1, 0));
					}
					coolDown = 20;
				} else {
					if(item.getTagCompound().getInteger("cap") >= 5)
					((EntityPlayerMP) entity)
					.addPotionEffect(new PotionEffect(
							Potion.waterBreathing.getId(), 0, 0));
					coolDown--;
				}
			}
		}

	}

	public boolean add(int i, ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		if (cap + i > maxCap)
			return false;
		cap = cap + i;
		s.getTagCompound().setInteger("cap", cap);
		return true;
	}

	public int getRemaining(ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		return this.maxCap - cap;
	}

	public boolean sub(int i, ItemStack s) {
		int cap = s.getTagCompound().getInteger("cap");
		if (cap - i < 0)
			return false;
		cap = cap - i;
		s.getTagCompound().setInteger("cap", cap);
		return true;
	}
}
