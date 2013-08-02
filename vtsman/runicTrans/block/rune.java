package vtsman.runicTrans.block;

import java.util.ArrayList;
import java.util.Random;

import vtsman.runicTrans.TE.IRune;
import vtsman.runicTrans.TE.capacitorTE;
import vtsman.runicTrans.TE.transRuneTE;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class rune extends Block{
	IRune rune;
	public rune(int par1, Material par2Material) {
		super(par1, par2Material);
		// TODO Auto-generated constructor stub
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity e)
    {
        if (!par1World.isRemote)
        {
        	if(e instanceof EntityItem){
        		rune.items.add((EntityItem)e);
        	}
        	if(e instanceof EntityAnimal){
        		rune.animals.add((EntityAnimal)e);
        	}
        }
    }
	@Override
	public boolean hasTileEntity(int m){
		return true;
	}
	@Override
	public TileEntity createTileEntity(World world, int meta)
    {
		if(meta != 7){
			transRuneTE t = new transRuneTE();
			this.rune = t;
		return t;
		}
		else{
			return null;
		}
    }
}
