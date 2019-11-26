package foodordering;

public class Drink {
	
	private final int did; // drink Id
	private String drinkName;
	private double price;
	private int additions;
	
	public Drink(int lastDid) {
		this.did = lastDid;
	}
	
	@Override
	public String toString()
	{
		String additionsStr = "";
		
		if(additions == 0) additionsStr = "none";
		else
		{
			if((additions & 1) != 0)
			{
				additionsStr += "ice, ";
			}
			if((additions & 2) != 0)
			{
				additionsStr += "lemon, ";
			}
		}
		
		return String.format("Drink ID: %d\n"
				+ "Drink name: %s\n"
				+ "Price: %f\n"
				+ "Additions: %s", did, drinkName, 
				price, additionsStr);
	}

	public String getDrinkName() {
		return drinkName;
	}

	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAdditions() {
		return additions;
	}

	public void setAdditions(int additions) {
		this.additions = additions;
	}

	public int getDid() {
		return did;
	}
}
