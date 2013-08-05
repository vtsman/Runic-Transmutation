package vtsman.runicTrans.transmute;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import static vtsman.runicTrans.transmute.transmuteManager.add;
public class transInit {
	public static HashMap<String, Integer> oreEnergy = new HashMap<String, Integer>();
	private static void initOres(){
		oreEnergy.put("saplingTree", 32);
		oreEnergy.put("logWood", 64);
		oreEnergy.put("plankWood", 16);
	}
	public static void init() {
		initOres();
		add(4, new ItemStack(Block.cobblestone, 1, 0));
		add(4, new ItemStack(Block.dirt, 1, 0));
		add(4, new ItemStack(Block.sand, 1, 0));
		add(64, new ItemStack(Block.wood, 1, 0));
		add(64, new ItemStack(Block.wood, 1, 1));
		add(64, new ItemStack(Block.wood, 1, 2));
		add(64, new ItemStack(Block.wood, 1, 3));
		add(32, new ItemStack(Block.sapling, 1, 0));
		add(32, new ItemStack(Block.sapling, 1, 1));
		add(32, new ItemStack(Block.sapling, 1, 2));
		add(32, new ItemStack(Block.sapling, 1, 3));
		/*for (int i = 0; i < OreDictionary.getOreNames().length; i++) {
		String oreName = OreDictionary.getOreNames()[i];
		System.out.println(oreName);
		if (oreEnergy.containsKey(oreName)) {
			System.out.println("found");
			for (int j = 0; j < OreDictionary.getOres(i).size(); j++) {
				for(int k = 0; k < OreDictionary.getOres(oreName).get(j).get; k++){
				add(oreEnergy.get(oreName), new ItemStack(OreDictionary.getOres(oreName).get(j).itemID, 1, k));
				}
			}
		}
	}*/
		add(16, new ItemStack(Block.planks, 1, 0));
		add(16, new ItemStack(Block.planks, 1, 1));
		add(16, new ItemStack(Block.planks, 1, 2));
		add(16, new ItemStack(Block.planks, 1, 3));
		add(6, new ItemStack(Block.plantRed, 1, 0));
		add(6, new ItemStack(Block.plantYellow, 1, 0));
		add(96, new ItemStack(Block.obsidian, 1, 0));
		add(256, new ItemStack(Item.ingotIron, 1, 0));
		add(2048, new ItemStack(Item.ingotGold, 1, 0));
		add(16384, new ItemStack(Item.diamond, 1, 0));
		add(512, new ItemStack(Item.enderPearl, 1, 0));
		add(4, new ItemStack(Block.stone, 1, 0));
		add(4, new ItemStack(Block.stoneBrick, 1, 0));
		add(4, new ItemStack(Block.stoneBrick, 1, 1));
		add(4, new ItemStack(Block.stoneBrick, 1, 2));
		add(16, new ItemStack(Block.sandStone, 1, 0));
		add(16, new ItemStack(Block.sandStone, 1, 1));
		add(16, new ItemStack(Block.sandStone, 1, 2));
		add(128, new ItemStack(Block.pumpkin, 1, 0));
		add(128, new ItemStack(Block.melon, 1, 0));
		add(16, new ItemStack(Item.melon, 1 ,0));
		add(32, new ItemStack(Item.pumpkinSeeds, 1, 0));
		add(16, new ItemStack(Item.melonSeeds, 1, 0));
		add(2, new ItemStack(Block.stoneSingleSlab, 1, 0));
        add(2, new ItemStack(Block.stoneSingleSlab, 1, 3));
        add(8, new ItemStack(Block.stoneSingleSlab, 1, 1));
        add(128, new ItemStack(Block.stoneSingleSlab, 1, 4));
        add(2, new ItemStack(Block.stoneSingleSlab, 1, 5));
        add(8, new ItemStack(Block.stoneSingleSlab, 1, 6));
        add(64, new ItemStack(Block.stoneSingleSlab, 1, 7));
        add(128, new ItemStack(Item.netherQuartz, 1, 0));
        add(16, new ItemStack(Item.brick, 1, 0));
        add(64, new ItemStack(Block.blockClay, 1, 0));
        add(64, new ItemStack(Block.brick));
        add(4, new ItemStack(Block.netherrack, 1, 0));
        add(4, new ItemStack(Item.netherrackBrick, 1, 0));
        add(16, new ItemStack(Block.netherBrick));
        add(64, new ItemStack(Item.netherQuartz, 1, 0));
        add(256, new ItemStack(Block.blockNetherQuartz, 1, 0));
	}
}
