package vtsman.runicTrans;

import vtsman.runicTrans.items.tools.ISpecial;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.StatCollector;

public class energizedEnchant extends Enchantment
{
    protected energizedEnchant(int par1, int par2)
    {
        super(par1, par2, EnumEnchantmentType.digger);
        this.setName("Infused");
    }

    /**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    public int getMinEnchantability(int par1)
    {
        return par1 * 10 - 5;
    }
    public String getTranslatedName(int par1)
    {
        String s = StatCollector.translateToLocal("Infused");
        return s + " " + StatCollector.translateToLocal("enchantment.level." + par1);
    }
    public boolean canApply(ItemStack par1ItemStack)
    {
        return this.type.canEnchantItem(par1ItemStack.getItem()) && !(par1ItemStack.getItem() instanceof ISpecial);
    }
    /**
     * Returns the maximum value of enchantability nedded on the enchantment level passed.
     */
    public int getMaxEnchantability(int par1)
    {
        return par1 * 15;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    public int getMaxLevel()
    {
        return 3;
    }

    /**
     * Determines if the enchantment passed can be applyied together with this enchantment.
     */
    public boolean canApplyTogether(Enchantment par1Enchantment)
    {
        return super.canApplyTogether(par1Enchantment) && par1Enchantment.effectId != this.unbreaking.effectId;
    }
}