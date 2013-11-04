package vtsman.runicTrans.utils;

public class colorUtils {
	public static int constColor(int r, int g, int b) {
		return r * 0x10000 + g * 0x100 + b;
	}

	public static int[] splitColor(int color) {
		int[] out = new int[3];
		out[2] = (color - color % 0x10000) / 0x10000;
		out[0] = color % 0x100;
		out[1] = (color - out[0]) / 0x100 % 0x100;

		return out;
	}

	public static int getLum(int color) {
		int[] split = splitColor(color);
		return mathUtils.intAvg(split);
	}

	public static int invertColor(int color) {
		int[] colors = splitColor(color);
		for (int i = 0; i < 3; i++) {
			colors[i] = 255 - colors[i];
		}
		return constColor(colors[2], colors[1], colors[0]);
	}

	public static int revLum(int color) {
		int lum = getLum(color);
		int[] split = splitColor(color);
		float[] deconst = new float[3];
		for (int i = 0; i < 3; i++) {
			deconst[i] = (float) split[i] / lum;
		}
		int[] out = new int[3];
		for (int i = 0; i < 3; i++) {
			out[i] = (int) (deconst[i] * (255 - lum));
		}
		return constColor(out[2], out[1], out[0]);
	}
}
