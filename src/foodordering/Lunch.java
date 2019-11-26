package foodordering;

public class Lunch {
	
	public enum Cousine
	{
		POLISH(1),
		MEXICAN(2),
		ITALIAN(3);
		
		private int cousine;
		
		private Cousine(int cousine)
		{
			this.cousine = cousine;
		}
	}
	
	private final int lid; // lunch Id
	private Cousine cousine;
	private String mainCourseName;
	private String dessertName;
	private double price;
	
	public Lunch(int lastLid) {
		this.lid = lastLid;
	}
	
	@Override
	public String toString()
	{
		String cousineStr = "";
		
		switch(cousine)
		{
			case POLISH:
				cousineStr = "Polish";
				break;
			case MEXICAN:
				cousineStr = "Mexican";
				break;
			case ITALIAN:
				cousineStr = "Italian";
				break;
		}
		
		return String.format("Lunch ID: %d\n"
				+ "Cousine: %s\n"
				+ "Main course: %s\n"
				+ "Dessert: %s\n"
				+ "Price: %f", lid, cousineStr, mainCourseName, 
				dessertName, price);
	}

	public Cousine getCousine() {
		return this.cousine;
	}

	public void setCousine(Cousine cousine) {
		this.cousine = cousine;
	}

	public String getMainCourseName() {
		return mainCourseName;
	}

	public void setMainCourseName(String mainCourseName) {
		this.mainCourseName = mainCourseName;
	}

	public String getDessertName() {
		return dessertName;
	}

	public void setDessertName(String dessertName) {
		this.dessertName = dessertName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getLid() {
		return lid;
	}
}
