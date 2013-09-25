package vtsman.runicTrans.worldGen;
import java.util.List;
import java.util.Random;

import vtsman.runicTrans.commonProxy;
import vtsman.runicTrans.block.modBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class villageHouse extends ComponentVillage
{
    private int averageGroundLevel = -1;

    public villageHouse(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    public static villageHouse buildComponent (ComponentVillageStartPiece villagePiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, p4);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new villageHouse(villagePiece, p5, random,
                structureboundingbox, p4) : null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
	@Override
	public boolean addComponentParts(World world, Random random,
			StructureBoundingBox sbb) {
		if (this.averageGroundLevel < 0)
	    {
	      this.averageGroundLevel = getAverageGroundLevel(world, sbb);

	      if (this.averageGroundLevel < 0)
	      {
	        return true;
	      }

	      this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 2, 0);
	    }
		System.out.println(sbb.getCenterX() + "," + sbb.getCenterY() + "," + sbb.getCenterZ());
		fillWithBlocks(world,sbb, 0, 2, 0, 6, 6, 6, Block.stoneBrick.blockID,Block.stoneBrick.blockID,false);
		fillWithBlocks(world,sbb, 0, 4, 0, 6, 5, 6, modBlocks.hex.blockID, modBlocks.hex.blockID,false);
		fillWithBlocks(world,sbb, 1, 3, 1, 5, 5, 5, 0,0,false);
		fillWithBlocks(world,sbb, 0, 7, 0, 6, 7, 6, Block.fenceIron.blockID,Block.fenceIron.blockID,false);
		fillWithBlocks(world,sbb, 1, 7, 1, 5, 7, 5, 0,0,false);
		
		fillWithBlocks(world,sbb, 0, 2, 0, 0, 5, 0, Block.stoneBrick.blockID, Block.stoneBrick.blockID,false);
		fillWithBlocks(world,sbb, 0, 2, 6, 0, 5, 6, Block.stoneBrick.blockID, Block.stoneBrick.blockID,false);
		fillWithBlocks(world,sbb, 6, 2, 6, 6, 5, 6, Block.stoneBrick.blockID, Block.stoneBrick.blockID,false);
		fillWithBlocks(world,sbb, 6, 2, 0, 6, 5, 0, Block.stoneBrick.blockID, Block.stoneBrick.blockID,false);
		
		//fillWithBlocks(world,sbb, 0, 2, 0, 6, 2, 6, modBlocks.lumin.blockID, modBlocks.lumin.blockID,false);
        super.fillWithMetadataBlocks(world, sbb, 0, 2, 0, 6, 2, 6, modBlocks.lumin.blockID, 1, modBlocks.lumin.blockID, 1, false);
        super.fillWithMetadataBlocks(world, sbb, 3, 2, 0, 3, 2, 6, modBlocks.animBlock.blockID, 7, modBlocks.animBlock.blockID, 7, false);
        super.fillWithMetadataBlocks(world, sbb, 0, 2, 3, 6, 2, 3, modBlocks.animBlock.blockID, 7, modBlocks.animBlock.blockID, 7, false);
        super.fillWithMetadataBlocks(world, sbb, 3, 3, 3, 3, 3, 3, modBlocks.rune.blockID, 0, modBlocks.rune.blockID, 0, false);
        int i = this.getMetadataWithOffset(Block.ladder.blockID, 5);
        for (int j = 0; j < 4; j++)
        {
            this.placeBlockAtCurrentPosition(world, Block.ladder.blockID, i, 1, j + 3, 1, sbb);
        }
        
        this.placeBlockAtCurrentPosition(world, 0, i, 3, 3, 0, sbb);
        this.placeBlockAtCurrentPosition(world, 0, i, 3, 4, 0, sbb);
        this.placeDoorAtCurrentPosition(world, sbb, random, 3, 3, 0, this.getMetadataWithOffset(Block.doorWood.blockID, 1));

		spawnVillagers(world, sbb, 3, 3, 3, 1);
		return true;
	}
	protected int getVillagerType(int par1)
	  {
		return commonProxy.villagerID;
	  }
	
}
