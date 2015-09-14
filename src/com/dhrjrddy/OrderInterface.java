package com.dhrjrddy;

public interface OrderInterface {
	public void addOrderedItem(String name, int quantity);

	public void deleteOrderedItem(String name);

	public void changeOrderedItem(String name, int quantity);

}
