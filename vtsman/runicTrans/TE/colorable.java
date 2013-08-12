package vtsman.runicTrans.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class colorable extends TileEntity{
	public int color = 0xFFFFFF;
	public int r = 0xFF;
	public int g = 0xFF;
	public int b = 0xFF;

	public void readFromNBT(NBTTagCompound data) {
		if (data.hasKey("color"))
			this.color = data.getInteger("color");
	}
	public void add(String s, int c){
		if(s == "r"){
			if(r + c <= 0xFF){
				r = r + c;
			}
		}
		if(s == "g"){
			if(g + c <= 0xFF){
				g = g + c;
			}
		}
		if(s == "b"){
			if(b + c <= 0xFF){
				b = b + c;
			}
		}
		color = r * 0x10000 + g * 0x100 + b;
	}
	public void sub(String s, int c){
		if(s == "r"){
			if(r - c >= 0x00){
				r = r - c;
			}
		}
		if(s == "g"){
			if(g - c >= 0x00){
				g = g - c;
			}
		}
		if(s == "b"){
			if(b - c >= 0x00){
				b = b - c;
			}
		}
		color = r * 0x10000 + g * 0x100 + b;
	}
	public void writeToNBT(NBTTagCompound data) {
		data.setInteger("color", this.color);
	}
}
