package vtsman.runicTrans.research;

import java.util.ArrayList;
import java.util.List;

import vtsman.runicTrans.aspect.Aspect;
import vtsman.runicTrans.aspect.AspectRegistry;
import vtsman.runicTrans.aspect.AspectStack;

public class research {
	public List<Aspect> aspects;
	public int id;
	public List<research> presearch;

	public research(List<Aspect> a, List<research> r) {
		this.presearch = r;
		this.aspects = a;
		id = researchManager.addResearch(this);
	}

	public int getColor() {
		ArrayList<AspectStack> stacks = new ArrayList<AspectStack>();
		for (int i = 0; i < aspects.size(); i++) {
			stacks.set(i, new AspectStack(this.aspects.get(i).id, 1));
		}
		return AspectRegistry.getColorFromAspects(stacks);
	}
}
