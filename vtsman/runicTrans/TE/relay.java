package vtsman.runicTrans.TE;

import net.minecraft.tileentity.TileEntity;

public class relay extends TileEntity implements IRelay{
	IRelay tile;
	public IRelay getcap() {
		for (int i = -9; i <= 9; i++) {
			for (int j = -9; j <= 9; j++) {
				for (int k = -9; k <= 9; k++) {
					TileEntity t = this.worldObj.getBlockTileEntity(this.xCoord
							+ i, this.yCoord + j, this.zCoord + k);
					if (t != null) {
						if (t instanceof IRelay) {
							if (((IRelay) t).canJoin(this)) {
								return (IRelay) t;
							}
						}
					}
				}
			}
		}
		return null;
	}
	
	@Override
	public void updateEntity() {
		if (!this.worldObj.isRemote) {
			if (this.tile == null)
				System.out.println("noTile");
				tile = getcap();
		}
	}
	@Override
	public IRelay tile() {
		return tile;
	}

	@Override
	public void add(int i) {
		if(tile != null)
		tile.add(i);
	}

	@Override
	public boolean remove(int i) {
		if(tile != null)
		return tile.remove(i);
		return false;
	}

	@Override
	public int getRE() {
		if(tile != null){
		return tile.getRE();
		}
		return 0;
	}

	@Override
	public void setRE(int i) {
		if(tile != null);
		tile.setRE(i);
	}
	@Override
	public boolean canJoin(IRelay r) {
		return this.tile() instanceof capacitorTE && r.tile() == null && r != this;
	}

}
