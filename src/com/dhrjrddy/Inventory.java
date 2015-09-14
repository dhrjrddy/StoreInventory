package com.dhrjrddy;

import java.util.Scanner;

public class Inventory {

	public void addNewItem(StoreManager storemanager) {

		Scanner input = new Scanner(System.in);
		int itemChoice;
		String itemName;
		int itemQuantity;
		String itemManufacturer;
		double itemCost;

		do {
			System.out.println("Select 1 for adding a new item.");
			System.out.println("Select 2 for removing an item.");
			System.out.println("Select 3 for changing an item quantity.");
			System.out.println("Select 4 for exit.");
			itemChoice = input.nextInt();
			switch (itemChoice) {
			case 1:
				System.out.println("Enter new item name:");
				itemName = input.next();
				System.out.println("Enter cost of each item:");
				itemCost = input.nextDouble();
				System.out.println("Enter item manufacturer name:");
				itemManufacturer = input.next();
				System.out.println("Enter total quantity of the item:");
				itemQuantity = input.nextInt();
				storemanager.addItem(new Item(itemName, itemCost,
						itemManufacturer), itemQuantity);
				storemanager.disply();
				break;
			case 2:
				System.out.println("Enter item name to delete:");
				itemName = input.next();
				storemanager.deleteItem(itemName);
				storemanager.disply();
				break;
			case 3:
				System.out.println("Enter item name to change:");
				itemName = input.next();
				System.out.println("Enter total quantity of the item:");
				itemQuantity = input.nextInt();
				storemanager.changeItem(itemName, itemQuantity);
				storemanager.disply();
				break;
			default:
				System.out.println("No such choice");
			}
		} while (itemChoice != 4);
	}

	public void placeOrder(OrderManager ordermanager) {
		Scanner input = new Scanner(System.in);
		int itemChoice;
		String itemName;
		int itemQuantity;

		do {
			System.out.println("Select 1 for ordering a new item.");
			System.out.println("Select 2 for removing an ordered item.");
			System.out.println("Select 3 for changing an ordered item quantity.");
			System.out.println("Select 4 for displaying total order.");
			System.out.println("Select 5 for exit.");
			itemChoice = input.nextInt();
			switch (itemChoice) {
			case 1:
				System.out.println("Enter new item name:");
				itemName = input.next();
				System.out.println("Enter total quantity of the item:");
				itemQuantity = input.nextInt();
				ordermanager.addOrderedItem(itemName, itemQuantity);
				ordermanager.displayOrderedItems();
				break;
			case 2:
				System.out.println("Enter item name to delete:");
				itemName = input.next();
				ordermanager.deleteOrderedItem(itemName);
				ordermanager.displayOrderedItems();
				break;
			case 3:
				System.out.println("Enter item name to change:");
				itemName = input.next();
				System.out.println("Enter total quantity of the item:");
				itemQuantity = input.nextInt();
				ordermanager.changeOrderedItem(itemName, itemQuantity);
				ordermanager.displayOrderedItems();
				break;
			case 4:
				ordermanager.displayOrderedItems();
				break;
			default:
				System.out.println("No such choice");
			}
		} while (itemChoice != 5);
	}

	public static void main(String[] args) {
		int choice;
		Scanner input = new Scanner(System.in);
		Inventory inventory = new Inventory();
		StoreManager storemanager = new StoreManager();
		OrderManager ordermanager = new OrderManager(storemanager);
		storemanager.addItem(new Item("item1", 20.10, "manufacture1"), 10);
		storemanager.addItem(new Item("item2", 30.10, "manufacture2"), 5);
		storemanager.addItem(new Item("item3", 40.10, "manufacture3"), 6);
		storemanager.addItem(new Item("item4", 50.10, "manufacture4"), 2);
		System.out.println("Select 1 for entering new item.");
		System.out.println("Select 2 for placing order.");
		choice = input.nextInt();
		if (choice == 1) {
			inventory.addNewItem(storemanager);
		} else if (choice == 2) {
			inventory.placeOrder(ordermanager);
		}

	}
}
