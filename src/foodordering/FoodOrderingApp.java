package foodordering;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FoodOrderingApp {
	
	private List<Order> orders = new LinkedList<>();
	private List<Lunch> lunches = new LinkedList<>();
	private List<Drink> drinks = new LinkedList<>();
	
	public Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		System.out.println("Food ordering system");
		
		FoodOrderingApp app = new FoodOrderingApp();
		
		app.orderDispatcher();
	}
	
	public Lunch orderLunch()
	{
		Lunch lunch = new Lunch(lunches.size());
		double price;
		
		System.out.print("Select one of the foolowing cousine: "
				+ "Polish [p], Mexican [m], Italian [i]: ");
		
		String cousineStr = scan.nextLine();
		switch(cousineStr)
		{
			case "p":
				lunch.setCousine(Lunch.Cousine.POLISH);
				break;
			case "m":
				lunch.setCousine(Lunch.Cousine.MEXICAN);
				break;
			case "i":
				lunch.setCousine(Lunch.Cousine.ITALIAN);
				break;
			default:
				System.out.println("Wrong cousine type!");
				return null;
		}
		
		System.out.print("Provide main course name: ");
		String mainCourse = scan.nextLine();
		lunch.setMainCourseName(mainCourse);
		
		System.out.print("Provide dessert name: ");
		String dessert = scan.nextLine();
		lunch.setDessertName(dessert);
		
		System.out.print("Provide lunch price: ");
		try
		{
			price = Double.parseDouble(scan.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Wrong number format!");
			return null;
		}
		lunch.setPrice(price);
		
		return lunch;
	}
	
	public Drink orderDrink()
	{
		Drink drink = new Drink(drinks.size());
		int additions = 0;
		double price;
		
		System.out.print("Provide drink name: ");
		String drinkName = scan.nextLine();
		drink.setDrinkName(drinkName);
		
		System.out.print("Provide drink price: ");
		try
		{
			price = Double.parseDouble(scan.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Wrong number format!");
			return null;
		}
		drink.setPrice(price);
		
		System.out.print("Select additions: ice [i], lemon [l], booth [b] or none [n]: ");
		String additionsStr = scan.nextLine();
		
		switch(additionsStr)
		{
			case "i":
				additions = 1;
				break;
			case "l":
				additions = 2;
				break;
			case "b":
				additions = 1 | 2; // bitmask: 1- ice, 2- lemon
				break;
			case "n":
				break;
			default:
				System.out.print("Wrong addition type!");
				return null;
		}
		
		drink.setAdditions(additions);
		
		return drink;
	}
	
	public int placeNewOrder()
	{
		System.out.print("Do you wish to order lunch [l], drink [d] or booth [b]: ");
		String command = scan.nextLine();
		switch(command)
		{
			case "l":
				Lunch lunch = orderLunch();
				if(lunch != null)
				{
					lunches.add(lunch);
					orders.add(new Order(orders.size() - 1, lunches.size() - 1, -1));
				}
				break;
			case "d":
				Drink drink = orderDrink();
				if(drink != null)
				{
					drinks.add(drink);
					orders.add(new Order(orders.size() - 1, -1, drinks.size() - 1));
				}
				break;
			case "b":
				lunch = orderLunch();
				if(lunch != null)
				{
					drink = orderDrink();
					if(drink != null)
					{
						lunches.add(lunch);
						drinks.add(drink);
						orders.add(new Order(orders.size() - 1, lunches.size() - 1, 
								drinks.size() - 1));
					}
				}
				break;
			default:
				return -1;
		}
		return orders.size() - 1;
	}
	
	public void listOrders()
	{
		for(int i = 0; i < orders.size(); i++)
		{
			System.out.println("Order ID: " + i);
			if(!displayOrder(i)) System.out.println("Unable to display order!");
		}
	}
	
	public boolean displayLunch(int lunchId)
	{
		if(lunchId < lunches.size())
		{
			System.out.println(lunches.get(lunchId).toString());
			return true;
		}
		else return false;
	}
	
	public boolean displayDrink(int drinkId)
	{
		if(drinkId < drinks.size())
		{
			System.out.println(drinks.get(drinkId).toString());
			return true;
		}
		else return false;
	}
	
	public boolean displayOrder(int orderNumber)
	{
		boolean stat = true;
		if(orderNumber < orders.size())
		{
			Order order = orders.get(orderNumber);
			if(order.getLid() >= 0) stat &= displayLunch(order.getLid());
			if(order.getDid() >= 0) stat &= displayDrink(order.getDid());
			return stat;
		}
		else return false;
	}
	
	public void getNumberAndDisplayOrder()
	{
		
		int orderNumber;
		
		System.out.print("Enter order number to display: ");
		try
		{
			orderNumber = Integer.parseInt(scan.nextLine());
		}
		catch(NumberFormatException e)
		{
			System.out.println("Wrong number format!");
			return;
		}
		if(!displayOrder(orderNumber)) System.out.println("Unable to display order!");
	}
	
	public void orderDispatcher()
	{
		boolean nextOrder = true;
		while(nextOrder)
		{
			System.out.print("Enter command: "
					+ "quit [q], place new order [p], list all orders [l], "
					+ "show order of id [s]: ");
			String command = scan.nextLine();
			switch(command)
			{
				case "q":
					nextOrder = false;
					break;
				case "p":
					if(placeNewOrder() == -1) System.out.println("Placing order error!");
					break;
				case "l":
					listOrders();
					break;
				case "s":
					getNumberAndDisplayOrder();
					break;
				default:
					System.out.println("Unknown command. Please try again.");
					break;
			}
		}
	}
}
