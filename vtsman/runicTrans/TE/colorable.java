package vtsman.runicTrans.TE;

import vtsman.runicTrans.packetHandler;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class colorable extends TileEntity {
	public int color = 0xFFFFFF;
	public int r = 0xFF;
	public int g = 0xFF;
	public int b = 0xFF;

	public void readFromNBT(NBTTagCompound data) {
		super.readFromNBT(data);
		this.color = data.getInteger("color");
		this.r = data.getInteger("r");
		this.g = data.getInteger("g");
		this.b = data.getInteger("b");
		//System.out.println(this.r);
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
	
	public void add(String s, int c) {
		if (s == "r") {
			if (r + c <= 0xFF) {
				r = r + c;
			}
		}
		if (s == "g") {
			if (g + c <= 0xFF) {
				g = g + c;
			}
		}
		if (s == "b") {
			if (b + c <= 0xFF) {
				b = b + c;
			}
		}
		color = r * 0x10000 + g * 0x100 + b;
	}

	public void sub(String s, int c) {
		if (s == "r") {
			if (r - c >= 0x00) {
				r = r - c;
			}
		}
		if (s == "g") {
			if (g - c >= 0x00) {
				g = g - c;
			}
		}
		if (s == "b") {
			if (b - c >= 0x00) {
				b = b - c;
			}
		}
		color = r * 0x10000 + g * 0x100 + b;
	}

	public void writeToNBT(NBTTagCompound data) {		
		super.writeToNBT(data);
		data.setInteger("color", this.color);
		data.setInteger("r", this.r);
		data.setInteger("g", this.g);
		data.setInteger("b", this.b);
	}
}
