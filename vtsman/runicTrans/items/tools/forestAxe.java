package vtsman.runicTrans.items.tools;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IShearable;

public class forestAxe extends ItemAxe{

	public forestAxe(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void registerIcons(IconRegister ir) {
		this.itemIcon = ir.registerIcon("runeTrans:advaxe");
	}
	    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLivingBase par7EntityLivingBase)
	    {
	    	if ((double)Block.blocksList[par3].getBlockHardness(par2World, par4, par5, par6) != 0.0D)
	        {
	            par1ItemStack.damageItem(1, par7EntityLivingBase);
	        }
	    	else if (par3 != Block.leaves.blockID && par3 != Block.web.blockID && par3 != Block.tallGrass.blockID && par3 != Block.vine.blockID && par3 != Block.tripWire.blockID && !(Block.blocksList[par3] instanceof IShearable))
	        {
	            return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
	        }
	            return true;
	    }

	    /**
	     * Returns if the item (tool) can harvest results from the block type.
	     */
	    public boolean canHarvestBlock(Block par1Block)
	    {
	        return par1Block.blockID == Block.web.blockID || par1Block.blockID == Block.redstoneWire.blockID || par1Block.blockID == Block.tripWire.blockID;
	    }

	    /**
	     * Returns the strength of the stack against a given block. 1.0F base, (Quality+1)*2 if correct blocktype, 1.5F if
	     * sword
	     */
	    public float getStrVsBlock(ItemStack stack, Block block, int meta)
	    {
	    	int[] five = new int[] {Block.web.blockID, Block.cloth.blockID};
	    	int[] fifteen = new int[] {Block.leaves.blockID};
	    	for(int i = 0; i < five.length; i++){
	    		if(block.blockID == five[i])
	    			return 5.0f;
	    	}
	    	for(int i = 0; i < fifteen.length; i++){
	    		if(block.blockID == fifteen[i])
	    			return 15.0f;
	    	}
	    	if (ForgeHooks.isToolEffective(stack, block, meta))
	        {
	            return efficiencyOnProperMaterial;
	        }
	        return getStrVsBlock(stack, block);
	    }
	    //TODO Redo all tools
	    @Override
	    public boolean onBlockStartBreak(ItemStack itemstack, int x, int y, int z, EntityPlayer player) 
	    {
	        if (player.worldObj.isRemote)
	        {
	            return false;
	        }
	        int id = player.worldObj.getBlockId(x, y, z);
	        if (Block.blocksList[id] instanceof IShearable)
	        {
	            IShearable target = (IShearable)Block.blocksList[id];
	            if (target.isShearable(itemstack, player.worldObj, x, y, z))
	            {
	                ArrayList<ItemStack> drops = target.onSheared(itemstack, player.worldObj, x, y, z,
	                        EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, itemstack));
	                Random rand = new Random();

	                for(ItemStack stack : drops)
	                {
	                    float f = 0.7F;
	                    double d  = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
	                    double d1 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
	                    double d2 = (double)(rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
	                    EntityItem entityitem = new EntityItem(player.worldObj, (double)x + d, (double)y + d1, (double)z + d2, stack);
	                    entityitem.delayBeforeCanPickup = 10;
	                    player.worldObj.spawnEntityInWorld(entityitem);
	                }

	                itemstack.damageItem(1, player);
	                player.addStat(StatList.mineBlockStatArray[id], 1);
	            }
	        }
	        return false;
	    }

}
