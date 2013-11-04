package vtsman.runicTrans.utils;

public class mathUtils {
	public static int intAvg(int[] in) {
		int out = 0;
		for (int i : in) {
			out += i;
		}
		return out / in.length;
	}

	public static float py(float in1, float in2) {
		return (float) Math.pow(in1 * in1 + in2 * in2, 0.f);
	}
}
