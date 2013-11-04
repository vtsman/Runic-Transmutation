package vtsman.runicTrans.aspect;

import static vtsman.runicTrans.aspect.AspectRegistry.addAspect;
import static vtsman.runicTrans.aspect.AspectRegistry.addAspectsToItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import vtsman.runicTrans.items.modItems;

public class modAspects {
	public static final Aspect fire = new FireAspect();
	public static final Aspect water = new WaterAspect();
	public static final Aspect earth = new EarthAspect();
	public static final Aspect leaf = new LeafAspect();
	public static final Aspect inert = new InertAspect();
	public static final Aspect active = new ActiveAspect();
	public static final Aspect magic = new MagicAspect();
	public static final Aspect pure = new PureAspect();
	public static final Aspect corrupt = new CorruptAspect();
	public static final Aspect ore = new MetalAspect();
	public static final Aspect dark = new DarkAspect();

	public static void init() {
		addAspect(fire);
		addAspect(earth);
		addAspect(water);
		addAspect(leaf);
		addAspect(inert);
		addAspect(active);
		addAspect(magic);
		addAspect(pure);
		addAspect(corrupt);
		addAspect(ore);
		addAspect(dark);

		addItem();
	}

	private static void addItem() {
		for (int i = 0; i < 4; i++) {
			addAspectsToItem(new ItemStack(Block.sapling, 1, i),
					new AspectStack(leaf, 4));
			addAspectsToItem(new ItemStack(Block.wood, 1, i), new AspectStack(
					leaf, 8));
			addAspectsToItem(new ItemStack(Block.planks, 1, i),
					new AspectStack(leaf, 2));
			addAspectsToItem(new ItemStack(Block.leaves, 1, i),
					new AspectStack(leaf, 1));
		}
		addAspectsToItem(new ItemStack(Block.stoneBrick, 1, 0),
				new AspectStack(earth, 4), new AspectStack(earth, 1),
				new AspectStack(fire, 1), new AspectStack(pure, 1));
		addAspectsToItem(new ItemStack(Block.stoneBrick, 1, 1),
				new AspectStack(earth, 4), new AspectStack(earth, 1),
				new AspectStack(fire, 1), new AspectStack(corrupt, 1));
		addAspectsToItem(new ItemStack(Block.stoneBrick, 1, 2),
				new AspectStack(earth, 4), new AspectStack(earth, 1),
				new AspectStack(fire, 1), new AspectStack(corrupt, 1));
		addAspectsToItem(new ItemStack(Block.stoneBrick, 1, 3),
				new AspectStack(earth, 4), new AspectStack(earth, 1),
				new AspectStack(fire, 1), new AspectStack(pure, 1));

		addAspectsToItem(new ItemStack(Block.cobblestone), new AspectStack(
				earth, 1));
		addAspectsToItem(new ItemStack(Block.cobblestoneMossy),
				new AspectStack(earth, 1), new AspectStack(leaf, 1));
		addAspectsToItem(new ItemStack(Block.netherrack), new AspectStack(
				earth, 1), new AspectStack(fire, 2));
		addAspectsToItem(new ItemStack(Block.stone), new AspectStack(earth, 1),
				new AspectStack(fire, 1), new AspectStack(pure, 1));
		addAspectsToItem(new ItemStack(Item.ingotIron),
				new AspectStack(ore, 4), new AspectStack(fire, 2));
		addAspectsToItem(new ItemStack(Item.ingotGold),
				new AspectStack(ore, 8), new AspectStack(fire, 4));
		addAspectsToItem(new ItemStack(Block.glass), new AspectStack(pure, 2),
				new AspectStack(earth, 1));
		addAspectsToItem(new ItemStack(Item.redstone), new AspectStack(ore, 1),
				new AspectStack(active, 2));
		addAspectsToItem(new ItemStack(Block.torchRedstoneActive),
				new AspectStack(active, 4));
		addAspectsToItem(new ItemStack(Block.lever), new AspectStack(active, 1));
		addAspectsToItem(new ItemStack(modItems.hexmetal), new AspectStack(ore,
				8), new AspectStack(fire, 4), new AspectStack(magic, 8));
		addAspectsToItem(new ItemStack(Item.netherStalkSeeds), new AspectStack(
				fire, 2), new AspectStack(leaf, 4), new AspectStack(corrupt, 2));
		addAspectsToItem(new ItemStack(Block.mycelium),
				new AspectStack(leaf, 2), new AspectStack(corrupt, 1));
		addAspectsToItem(new ItemStack(Item.diamond, 1), new AspectStack(pure,
				24), new AspectStack(ore, 16), new AspectStack(earth, 8),
				new AspectStack(ore, 8));
	}
}
