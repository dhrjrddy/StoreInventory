package com.dhrjrddy;

import java.util.Iterator;
import java.util.LinkedList;

public class StoreManager implements StoreInterface {

	private LinkedList<Store> items;

	public StoreManager() {
		items = new LinkedList<Store>();
	}

	public void addItem(Item item, int quantity) {
		Store newItem = new Store(item, quantity);
		items.add(newItem);
	}

	public void deleteItem(String name) {
		for (Iterator<Store> i = items.iterator(); i.hasNext();) {
			Store item = (Store) i.next();
			if (item.getItem().matches(name)) {
				items.remove(item);
				break;
			}
		}

	}

	public void changeItem(String name, int quantity) {
		for (Iterator<Store> i = items.iterator(); i.hasNext();) {
			Store item = (Store) i.next();
			if (item.getItem().matches(name)) {
				item.setQuantity(quantity);
			}
		}
	}

	public void disply() {
		for (Iterator<Store> i = items.iterator(); i.hasNext();) {
			Store item = (Store) i.next();
			System.out.println(item.getItem().getName() + ","
					+ item.getItem().getCost() + "'"
					+ item.getItem().getManufacturer() + "'"
					+ item.getQuantity());
		}
		System.out.println();
	}

	public LinkedList<Store> getItemList() {
		return items;
	}
}
