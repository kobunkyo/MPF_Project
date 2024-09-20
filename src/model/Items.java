package model;

import java.io.File;
import java.util.ArrayList;

public class Items {
	private static ArrayList<Item> items;
	
	public static void InitializeItem() {
	
		// Data 1
		items.add(new Item(5, "Heart", 10, "Adds an additional hit point but lightly weakens your attack power", new File("Assets/image/heart.png").toURI().toString()));
		
		// Data 2
		items.add(new Item(8, "Coffee", 7, "Super meter continuously fills in addition to what you earn", new File("Assets/image/coffee.png").toURI().toString()));
		
		// Data 3
		items.add(new Item(6, "Whetstone", 6, "Your first parry move doubles as a damaging axe attack", new File("Assets/image/whetstone.png").toURI().toString()));
		
		// Data 4
		items.add(new Item(5, "Twin Heart", 3, "Adds two additional hit points but weakens your attack power", new File("Assets/image/twinheart.png").toURI().toString()));
		
		// Data 5
		items.add(new Item(6, "Smoke Bomb", 12, "You will not take damage during a dash. A great defense maneuver", new File("Assets/image/smokebomb.png").toURI().toString()));
	}
	
	public static void setArrayList(ArrayList<Item> data) {
		items = data;
	}
	
	public static ArrayList<Item> getItems(){
		return items;
	}
	
	public static void updateItemByIndex(int index, Integer price, Integer stock, String description) {
		items.get(index).setPrice(price);
		items.get(index).setStock(stock);
		items.get(index).setDescription(description);
	}
}	
