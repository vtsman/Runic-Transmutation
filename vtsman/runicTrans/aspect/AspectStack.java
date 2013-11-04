package vtsman.runicTrans.aspect;

public class AspectStack {
	public int id;
	public int amount;

	public AspectStack(int id, int amount) {
		this.id = id;
		this.amount = amount;
	}

	public AspectStack(Aspect a, int amount) {
		this.id = a.id;
		this.amount = amount;
	}

	public AspectStack copy() {
		return new AspectStack(id, amount);
	}

	@Override
	public String toString() {
		return Integer.toString(amount) + " of "
				+ AspectRegistry.aspects[id].Name;
	}
}
