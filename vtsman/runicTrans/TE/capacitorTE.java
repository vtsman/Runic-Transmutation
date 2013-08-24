package vtsman.runicTrans.TE;

import vtsman.runicTrans.packetHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class capacitorTE extends TileEntity implements IRelay{
	public int RE = 0;

	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		if (data.hasKey("RE"))
			this.RE = data.getInteger("RE");
	}

	public void writeToNBT(NBTTagCompound data) {
		super.writeToNBT(data);
		data.setInteger("RE", this.RE);
	}
	int i = 0;
	@Override
	public void updateEntity(){
		i++;
		if(i == 20){
			i = 0;
			packetHandler.sendPacket(this);
			this.worldObj.markBlockForRenderUpdate(this.xCoord, this.yCoord, this.zCoord);
		}
	}
	public void add(int i) {
		RE = RE + i;
	}

	public boolean remove(int i) {
		if (i > RE)
			return false;
		RE = RE - i;
		return true;
	}

	@Override
	public IRelay tile() {
		return this;
	}

	@Override
	public int getRE() {
		return RE;
	}
	
	@Override
	public void setRE(int i) {
		this.RE = i;
	}

	@Override
	public boolean canJoin(IRelay r) {
		return true;
	}
}
