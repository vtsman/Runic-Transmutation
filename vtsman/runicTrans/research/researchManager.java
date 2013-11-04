package vtsman.runicTrans.research;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import vtsman.runicTrans.aspect.Aspect;

public class researchManager {
	static research[] researches = new research[256];
	static int i;
	public static Map<EntityPlayer, boolean[]> playerResearches = new HashMap<EntityPlayer, boolean[]>();

	public static int addResearch(research r) {
		if (i < researches.length) {
			researches[i] = r;
			return i;
		}
		return -1;
	}

	public static void saveResearch(EntityPlayer p) {
		boolean[] b = playerResearches.get(p).clone();
		for (int i = 0; i < b.length; i++) {
			researchFileHelper.setResearch(p, i, b[i]);
		}
	}

	public static researchProgress getInitResearch(Aspect[] a, EntityPlayer p) {
		for (int j = 0; j < i; j++) {
			research r = researches[j];
			if (!isResearched(r, p)) {
				for (Aspect as : r.aspects) {
					for (Aspect inAs : a) {
						if (as.id == inAs.id) {
							researchProgress out = new researchProgress(r.id);
							out.setAspect(inAs, p);
							return out;
						}
					}
				}
			}
		}
		return null;
	}

	public static boolean research(Aspect[] as, EntityPlayer p,
			researchProgress r) {
		for (Aspect a : as) {
			int entry = r.getAspectEntry(a);
			if (entry != -1) {
				if (!r.aspects[entry]) {
					r.setAspect(a, p);
					return true;
				}
			}

		}
		return false;
	}

	public static int getLength() {
		return researches.length;
	}

	public static boolean isResearched(research r, EntityPlayer p) {
		playerResearches.put(p, researchFileHelper.getResearch(p));
		return playerResearches.get(p)[r.id];
	}
}
