package vtsman.runicTrans.TE.multiblock;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class researchMultiblock {
	public static boolean isMultiblockValid(World w, int x, int y, int z) {
		int right = 0;

		if (xArch(w, x, y, z + 5)) {
			System.out.println(1);
			right++;
		}
		if (xArch(w, x, y, z - 5)) {
			System.out.println(2);
			right++;
		}

		if (zArch(w, x + 5, y, z)) {
			System.out.println(3);
			right++;
		}

		if (zArch(w, x - 5, y, z)) {
			System.out.println(4);
			right++;
		}
		return right == 4;
	}

	static int qB = Block.blockNetherQuartz.blockID;
	static int qSl = Block.stoneSingleSlab.blockID;
	static int qSt = Block.stairsNetherQuartz.blockID;
	static int g = Block.blockGold.blockID;
	static int[][] ids = { { 0, 0, qSl, 0, 0 }, { 0, qSt, g, qSt, 0 },
			{ qSt, qSt, qSl, qSt, qSt }, { qB, 0, 0, 0, qB },
			{ qB, 0, 0, 0, qB }, { qB, 0, 0, 0, qB } };

	static int[][] zmetas = { { 0, 0, 7, 0, 0 }, { 0, 2, 0, 3, 0 },
			{ 2, 7, 15, 6, 3 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };
	static int[][] xmetas = { { 0, 0, 7, 0, 0 }, { 0, 0, 0, 1, 0 },
			{ 0, 5, 15, 4, 1 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0 } };

	// Increment Z for this function
	private static boolean xArch(World w, int x, int y, int z) {
		int check = 30;
		for (int i = 0; i < 5; i++) {
			for (int j = 5; j >= 0; j--) {
				int id = w.getBlockId(x - 2 + i, y + 5 - j, z);
				int meta = w.getBlockMetadata(x - 2 + i, y + 5 - j, z);
				if (ids[j][i] == id && xmetas[j][i] == meta) {
					check--;
				}
			}
		}
		return check == 0;
	}

	// Increment X for this function
	private static boolean zArch(World w, int x, int y, int z) {
		int check = 30;
		for (int i = 0; i < 5; i++) {
			// int i = 2;
			for (int j = 5; j >= 0; j--) {
				int id = w.getBlockId(x, y + 5 - j, z - 2 + i);
				int meta = w.getBlockMetadata(x, y + 5 - j, z - 2 + i);
				if (ids[j][i] == id && zmetas[j][i] == meta) {
					check--;
				}
			}
		}
		return check == 0;
	}
}
