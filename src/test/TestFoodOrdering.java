package test;

import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import foodordering.Drink;
import foodordering.FoodOrderingApp;
import foodordering.Lunch;

public class TestFoodOrdering {
	
	private static FoodOrderingApp app = new FoodOrderingApp();
	
	@Test
	public void order_lunch()
	{
		String input = "m\n"
				+ "pizza\n"
				+ "chocolate cake\n"
				+ "23.21\n";
		app.scan = new Scanner(input);
		
		Lunch lunch = app.orderLunch();
		
		Assertions.assertEquals(0, lunch.getLid());
		Assertions.assertEquals(Lunch.Cousine.MEXICAN, lunch.getCousine());
		Assertions.assertEquals("chocolate cake", lunch.getDessertName());
		Assertions.assertEquals(23.21, lunch.getPrice(), 0.0001);
	}
	
	@Test
	public void order_drink()
	{
		String input = "Mohito\n"
				+ "9.58\n"
				+ "b\n";
		app.scan = new Scanner(input);
		
		Drink drink = app.orderDrink();
		
		Assertions.assertEquals(0, drink.getDid());
		Assertions.assertEquals("Mohito", drink.getDrinkName());
		Assertions.assertEquals(9.58, drink.getPrice(), 0.0001);
		Assertions.assertEquals(1 | 2, drink.getAdditions());
	}
}
