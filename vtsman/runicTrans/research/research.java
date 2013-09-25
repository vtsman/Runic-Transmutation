package vtsman.runicTrans.research;

import java.util.List;

import vtsman.runicTrans.aspect.Aspect;

public class research {
	public List<Aspect> aspects;
	public int id;
	public List<research> presearch;

	public research(List<Aspect> a, List<research> r) {
		this.presearch = r;
		this.aspects = a;
		id = researchManager.addResearch(this);
	}

}
