package vtsman.runicTrans.research;

public class researchManager {
	private static research[] researches = new research[256];
	static int i;
	public static boolean[] playerResearches = new boolean[researches.length];

	public static int addResearch(research r) {
		if (i < researches.length) {
			researches[i] = r;
			return i;
		}
		return -1;
	}

	public static int getLength() {
		return researches.length;
	}

	public static boolean isResearched(research r) {
		return playerResearches[r.id];
	}
}
