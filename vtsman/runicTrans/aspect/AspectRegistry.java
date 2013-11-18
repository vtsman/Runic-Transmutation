package vtsman.runicTrans.aspect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import vtsman.vtsmcUtil.ColorUtils;
import vtsman.vtsmcUtil.StackUtils;

public class AspectRegistry {
	public static Map<Integer, List<AspectStack>[]> aspectMap = new HashMap<Integer, List<AspectStack>[]>();
	public static Aspect[] aspects = new Aspect[128];
	private static int id = -1;

	public static void addAspect(Aspect a) {
		aspects[a.id] = a;
		System.out.println("Added " + a.Name + " aspect");
	}

	public static int getNextAspectID() {
		id++;
		return id;
	}

	private static void addEntry(int i) {
		List<AspectStack>[] aspects = new ArrayList[16];
		aspectMap.put(i, aspects);
	}

	public static boolean allAspect(ItemStack[] in) {
		ItemStack[] s = StackUtils.getNonNull(in);
		int c = 0;
		for (int i = 0; i < s.length; i++) {
			if (getAspects(s[i]) != null) {
				c++;
			}
		}
		return c == s.length;
	}

	public static List<AspectStack> getAspectsFromStacks(ItemStack... stacks) {
		if (stacks != null) {
			List<AspectStack> out = new ArrayList<AspectStack>();
			for (int i = 0; i < stacks.length; i++) {
				if (stacks[i] != null) {
					List<AspectStack> a = getAspects(stacks[i]);
					if (a != null) {
						for (int j = 0; j < a.size(); j++) {
							addToAspectList(out, a.get(j));
						}
					}
				}
			}
			return out;
		}
		return null;
	}

	public static List<AspectStack> getAspectsFromStacksArr(ItemStack[] stacks) {
		for (ItemStack s : stacks) {
			System.out.println(s);
		}
		if (stacks != null) {
			List<AspectStack> out = new ArrayList<AspectStack>();
			for (int i = 0; i < stacks.length; i++) {
				if (stacks[i] != null) {
					List<AspectStack> a = getAspects(stacks[i]);
					if (a != null) {
						for (int j = 0; j < a.size(); j++) {
							addToAspectList(out, a.get(j));
						}
					}
				}
			}
			return out;
		}
		return null;
	}

	public static void addAspectsToItem(ItemStack s, AspectStack... inlist) {
		if (s.getItemDamage() > 15) {
			return;
		}
		if (aspectMap.get(s.itemID) == null) {
			addEntry(s.itemID);
		}
		List<AspectStack> aspects = aspectMap.get(s.itemID)[s.getItemDamage()];
		if (aspects == null) {
			aspects = new ArrayList<AspectStack>();
		}
		for (int i = 0; i < inlist.length; i++) {
			addToAspectList(aspects, inlist[i]);
		}
		aspectMap.get(s.itemID)[s.getItemDamage()] = aspects;
	}

	public static int getColorFromAspects(List<AspectStack> s) {

		if (s != null) {
			int avgDiv = 0;
			int r = 0;
			int g = 0;
			int b = 0;
			avgDiv = getAmount(s);
			for (int i = 0; i < s.size(); i++) {
				Aspect a = aspects[s.get(i).id];
				r += a.r * s.get(i).amount;
				g += a.g * s.get(i).amount;
				b += a.b * s.get(i).amount;
			}
			System.out.println(avgDiv);
			if (avgDiv != 0) {
				r /= avgDiv;
				g /= avgDiv;
				b /= avgDiv;
				return ColorUtils.constColor(r, g, b);
			}
		}
		System.out.println("D:");
		return 0;
	}

	public static int getAmount(List<AspectStack> s) {
		int out = 0;
		for (int i = 0; i < s.size(); i++) {
			out += s.get(i).copy().amount;
		}
		return out;
	}

	public static ArrayList<AspectStack> clone(List<AspectStack> list) {
		ArrayList<AspectStack> out = new ArrayList<AspectStack>();
		for (AspectStack s : list) {
			out.add(s.copy());
		}
		return out;
	}

	public static List<AspectStack> getAspects(ItemStack s) {
		if (aspectMap.containsKey(s.itemID) && s.getItemDamage() < 16) {
			List<AspectStack> out = clone(aspectMap.get(s.itemID)[s
					.getItemDamage()]);
			if (out != null) {
				for (int i = 0; i < out.size(); i++) {
					out.get(i).amount *= s.stackSize;
				}
			}
			return out;

		}
		return null;
	}

	public static void addToAspectList(List<AspectStack> l, AspectStack a) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) != null) {
				if (l.get(i).id == a.id) {
					AspectStack out = l.get(i);
					out.amount += a.amount;
					l.set(i, out);
					return;
				}
			}
		}
		l.add(a);
	}
}
