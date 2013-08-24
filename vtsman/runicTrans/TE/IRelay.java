package vtsman.runicTrans.TE;

public interface IRelay {
	IRelay tile();
	void add(int i);
	boolean remove(int i);
	int getRE();
	void setRE(int i);
	boolean canJoin(IRelay r);
}
