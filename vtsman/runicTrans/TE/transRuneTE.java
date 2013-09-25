package vtsman.runicTrans.TE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vtsman.runicTrans.transmute.transmuteManager;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class transRuneTE extends TileEntity implements IRelay{
	public List<ItemStack> items = new ArrayList<ItemStack>();
	public static double[] getMult = new double[] { .5d, 2d / 3d, 10d / 14d,
			10d / 13d, .8d, .9d, 1d };
	public static int[] getMax = new int[] { 4, 20, 30, 80, 160, 320, 0 };
	public IRelay tile;
	public findRune find;
	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			if (this.tile == null)
				tile = getcap();
			if (this.find== null)
				find = getfind();
		}
	}

	public IRelay getcap() {
		for (int i = -9; i <= 9; i++) {
			for (int j = -9; j <= 9; j++) {
				for (int k = -9; k <= 9; k++) {
					TileEntity t = this.worldObj.getBlockTileEntity(this.xCoord
							+ i, this.yCoord + j, this.zCoord + k);
					if (t != null) {
						if (t instanceof IRelay) {
							if (((IRelay) t).canJoin(this)) {
								System.out.println("found");
								return (IRelay) t;
							}
						}
					}
				}
			}
		}
		return null;
	}
	public findRune getfind() {
		for (int i = -9; i <= 9; i++) {
			for (int j = -9; j <= 9; j++) {
				for (int k = -9; k <= 9; k++) {
					TileEntity t = this.worldObj.getBlockTileEntity(this.xCoord
							+ i, this.yCoord + j, this.zCoord + k);
					if (t != null) {
						if (t instanceof findRune) {
							System.out.println("found");
							return (findRune) t;
						}
					}
				}
			}
		}
		return null;
	}

	public boolean suck(Entity e) {
		int meta = this.worldObj.getBlockMetadata(this.xCoord, this.yCoord,
				this.zCoord);
		if (this.tile != null) {
			if (e != null) {
				if (e instanceof EntityItem) {
					ItemStack i = ((EntityItem) e).getEntityItem();
					if (i != null) {
						int RE = transmuteManager.getEnergy(i);
						if (RE > 0) {
							if (getMax[meta] == 0) {
								this.tile.add(RE * i.stackSize);
								e.setDead();
								return true;
							}
							if(getMax[meta] >= RE){
								this.tile.add((int)((double)RE * getMult[meta] * i.stackSize));
								e.setDead();
								return true;
							}
						}
					}
				}
			}
		}
		Random rand = new Random();
		return false;
	}

	@Override
	public IRelay tile() {
		return tile;
	}

	@Override
	public void add(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remove(int i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getRE() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRE(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean canJoin(IRelay r) {
		return false;
	}
}
