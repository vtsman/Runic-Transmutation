package vtsman.runicTrans.aspect;

public class Aspect {
	public int id;
	public int r;
	public int g;
	public int b;
	public String Name;

	public Aspect() {
		this.id = AspectRegistry.getNextAspectID();
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Aspect) {
			if (((Aspect) o).id == this.id) {
				return true;
			}
		}
		return false;
	}
}
