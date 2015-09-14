package com.dhrjrddy;

public interface StoreInterface {

	public void addItem(Item item, int quantity);

	public void deleteItem(String name);

	public void changeItem(String name, int quantity);

}
