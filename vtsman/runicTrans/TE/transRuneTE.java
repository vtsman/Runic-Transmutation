package vtsman.runicTrans.TE;

import java.util.ArrayList;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.tileentity.TileEntity;

public class transRuneTE extends IRune{
    public void updateEntity() {
    	this.animals = new ArrayList<EntityAnimal>();
    	this.items = new ArrayList<EntityItem>();
    }
}
