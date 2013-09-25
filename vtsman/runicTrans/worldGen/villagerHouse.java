package vtsman.runicTrans.worldGen;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class villagerHouse implements IVillageCreationHandler{
	
	@Override
	public StructureVillagePieceWeight getVillagePieceWeight(Random random,
			int i) {
		 return new StructureVillagePieceWeight(villageHouse.class, 15, i + random.nextInt(2));
	}

	@Override
	public Class<?> getComponentClass() {
		// TODO Auto-generated method stub
		return villageHouse.class;
	}

	@Override
	public Object buildComponent(StructureVillagePieceWeight villagePiece,
			ComponentVillageStartPiece startPiece, List pieces, Random random,
			int p1, int p2, int p3, int p4, int p5) {
		// TODO Auto-generated method stub
		return villageHouse.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
	}

}
