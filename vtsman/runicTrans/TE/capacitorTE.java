package vtsman.runicTrans.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class capacitorTE extends TileEntity{
public int RE;
@Override
public void readFromNBT(NBTTagCompound data)
   {
	this.RE = data.getInteger("RE");
   }
@Override
public void writeToNBT(NBTTagCompound data) {
	data.setInteger("RE", this.RE);
}
}
