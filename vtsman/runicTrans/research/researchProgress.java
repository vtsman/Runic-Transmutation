package vtsman.runicTrans.research;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import vtsman.runicTrans.aspect.Aspect;
import vtsman.runicTrans.aspect.AspectRegistry;
import vtsman.runicTrans.aspect.AspectStack;
import vtsman.runicTrans.aspect.modAspects;
import vtsman.vtsmcUtil.ColorUtils;

public class researchProgress {
	int id;
	public boolean[] aspects;

	public researchProgress(int researchID) {
		this.id = researchID;
		this.aspects = new boolean[researchManager.researches[id].id];
	}

	public void setAspect(Aspect aspect, EntityPlayer p) {
		int i = 0;
		for (Aspect a : researchManager.researches[id].aspects) {
			if (a.equals(aspect)) {
				aspects[i] = true;
				if (checkComplete()) {
					boolean[] b = researchManager.playerResearches.get(p);
					if (b != null) {
						b[id] = true;
						researchManager.saveResearch(p);
					}
				}
				break;
			}
			i++;
		}
	}

	public int getAspectEntry(Aspect a) {
		int x = 0;
		research r = researchManager.researches[this.id];
		for (Aspect ra : r.aspects) {
			if (ra.equals(a)) {
				return x;
			}
			x++;
		}
		return -1;
	}

	public boolean checkComplete() {
		for (boolean b : aspects) {
			if (!b) {
				return false;
			}
		}
		return true;
	}

	public void writeToTag(NBTTagCompound t) {
		t.setInteger("ID", this.id);
		t.setInteger("Length", this.aspects.length);
		for (int i = 0; i < this.aspects.length; i++) {
			t.setBoolean(Integer.toString(i), this.aspects[i]);
		}
	}

	public int getColor() {
		research r = researchManager.researches[this.id];
		ArrayList<AspectStack> stacks = new ArrayList<AspectStack>();
		for (int i = 0; i < r.aspects.size(); i++) {
			Aspect a = r.aspects.get(i);
			if (!this.aspects[this.getAspectEntry(a)]) {
				stacks.add(new AspectStack(a.id, 1));
			} else {
				stacks.add(new AspectStack(modAspects.dark.id, 1));
			}
		}
		return ColorUtils.revLum(AspectRegistry.getColorFromAspects(stacks));
	}

	public static researchProgress getResearch(NBTTagCompound t) {
		researchProgress r = new researchProgress(t.getInteger("ID"));
		int l = t.getInteger("Length");
		r.aspects = new boolean[l];
		for (int i = 0; i < l; i++) {
			r.aspects[i] = t.getBoolean(Integer.toString(i));
		}
		return r;
	}
}
