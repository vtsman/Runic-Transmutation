package vtsman.runicTrans.worldGen;

import java.util.Random;

import vtsman.runicTrans.block.modBlocks;
import vtsman.runicTrans.items.modItems;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

public class tradeHandler implements IVillageTradeHandler{

	@Override
	public void manipulateTradesForVillager(EntityVillager villager,
			MerchantRecipeList list, Random random) {
		for(int i = 0; i < 8; i++){
		list.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(modBlocks.animBlock, 16, i)));
		}
		list.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(modBlocks.hex, 16, 0)));
		list.addToListWithCheck(new MerchantRecipe(new ItemStack(Item.emerald, 2, 0), new ItemStack(modBlocks.hex, 16, 1)));
		list.addToListWithCheck(new MerchantRecipe(new ItemStack(modItems.infused, 2, 0), new ItemStack(Item.emerald, 1, 0)));
		list.addToListWithCheck(new MerchantRecipe(new ItemStack(Block.obsidian, 1, 0), new ItemStack(Item.emerald, 2, 0), new ItemStack(modBlocks.chargeNode, 1, 0)));	
	}

}
