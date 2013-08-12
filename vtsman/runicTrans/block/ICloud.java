package vtsman.runicTrans.block;

import net.minecraft.world.IBlockAccess;

public interface ICloud {
int[] getColor(int meta, IBlockAccess access, int x, int y, int z);
}
