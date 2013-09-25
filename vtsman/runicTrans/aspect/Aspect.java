package vtsman.runicTrans.aspect;

public class Aspect {
	public int id;
	public int r;
	public int g;
	public int b;
	public String Name;
	public Aspect(){
		this.id = AspectRegistry.getNextAspectID();
	}
}
