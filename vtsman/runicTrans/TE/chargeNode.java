package vtsman.runicTrans.TE;
import net.minecraft.tileentity.*;
public class chargeNode extends TileEntity{
public capacitorTE tile;
public capacitorTE getcap(){
	for(int i = -9; i <= 9; i++){
		for(int j = -9; j <= 9; j++){
			for(int k = -9; k <= 9; k++){
				TileEntity t = this.worldObj.getBlockTileEntity(this.xCoord + i, this.yCoord + j, this.zCoord + k);
				if(t != null){
					if(t instanceof capacitorTE){
						System.out.println("found");
						return (capacitorTE) t;
					}
				}
			}
		}
	}
	return null;
}
@Override
public void updateEntity(){
	if(!this.worldObj.isRemote){
		if(this.tile == null)tile = getcap();
	}
}
}
