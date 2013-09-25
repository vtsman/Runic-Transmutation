package vtsman.runicTrans.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class advSword extends ItemSword implements ISpecial {
	int maxCap = 1000;

	public advSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}

	public void addInformation(ItemStack stack, EntityPlayer par2EntityPlayer,
			List list, boolean par4) {
		list.clear();
		list.add("Assassin's sword");
		if (stack.getTagCompound() == null) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (!stack.getTagCompound().hasKey("cap")) {
			stack.stackTagCompound.setInteger("cap", 0);
		}

		list.add("This sword has " + stack.getTagCompound().getInteger("cap")
				+ " out of 1000 energy.");
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:advsword");
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world,
			int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (player instanceof EntityPlayerMP)
			if (stack.stackTagCompound != null)
				if (this.sub(100, stack)) {
						System.out.println("inv");
						((EntityPlayerMP) player)
								.addPotionEffect(new PotionEffect(
										Potion.invisibility.getId(), 200, 0));
						return true;
					}
		return false;
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
