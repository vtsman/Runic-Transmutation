package vtsman.runicTrans.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class capacitorTE extends TileEntity{
public int RE = 0;
public void readFromNBT(NBTTagCompound data)
   {
	if(data.hasKey("RE"))
	this.RE = data.getInteger("RE");
	System.out.println(this.RE);
   }
public void writeToNBT(NBTTagCompound data) {
	data.setInteger("RE", this.RE);
}
public void add(int i){
	RE = RE + i;
}
public boolean remove(int i){
	if(i > RE)return false;
	RE = RE - i;
	return true;
}
}
