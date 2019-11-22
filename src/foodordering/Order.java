package foodordering;

public class Order {
	
	private final int oid; // order Id
	private final int lid; // lunch Id
	private final int did; // drink Id
	
	public Order(int oid, int lid, int did) {
		this.oid = oid;
		this.lid = lid;
		this.did = did;
	}
	
	public int getOid() {
		return oid;
	}
	
	public int getLid() {
		return lid;
	}
	
	public int getDid() {
		return did;
	}
}
