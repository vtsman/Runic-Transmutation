package vtsman.runicTrans.TE.multiblock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class essenceCrafterMultiblock {
	public static boolean isValidMultiblock(World w, int x, int y, int z) {
		int right = 4;
		if (checkPillar(w, x + 3, y, z + 3)) {
			right--;
		}
		if (checkPillar(w, x + 3, y, z - 3)) {
			right--;
		}
		if (checkPillar(w, x - 3, y, z - 3)) {
			right--;
		}
		if (checkPillar(w, x - 3, y, z + 3)) {
			right--;
		}
		return right == 0;
	}

	static int qB = Block.blockNetherQuartz.blockID;
	static int nB = Block.netherBrick.blockID;
	static int nBS = Block.stairsNetherBrick.blockID;

	private static boolean checkPillar(World w, int x, int y, int z) {
		int right = 12;
		// Check for stairs
		for (int i = 0; i < 3; i++) {
			if (w.getBlockId(x + i - 1, y, z - 1) == nBS) {
				if (w.getBlockMetadata(x + i - 1, y, z - 1) == 2) {
					right--;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (w.getBlockId(x + i - 1, y, z + 1) == nBS) {
				if (w.getBlockMetadata(x + i - 1, y, z + 1) == 3) {
					right--;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (w.getBlockId(x - 1, y, z + i - 1) == nBS) {
				if (w.getBlockMetadata(x - 1, y, z + i - 1) == 0) {
					right--;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			if (w.getBlockId(x + 1, y, z + i - 1) == nBS) {
				if (w.getBlockMetadata(x + 1, y, z + i - 1) == 1) {
					right--;
				}
			}
		}
		System.out.println(right);
		// Check for nether line
		for (int i = 0; i < 3; i++) {
			if (w.getBlockId(x, y + i, z) == nB) {
				right--;
			}
		}
		// Check for quartz topper
		if (w.getBlockId(x, y + 3, z) == qB) {
			right--;
		}
		return right == 0;
	}
}
