package com.dhrjrddy;

public class OrderItem {

	private String name;
	private int quantity;
	private double cost;
	private double totalItemCost;

	public OrderItem(String name, int quantity, double cost) {
		this.name = name;
		this.quantity = quantity;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean ordernamematches(String otherItemName) {
		if (name.equals(otherItemName)) {
			return true;
		}
		return false;
	}

	public void setTotalItemCost(int quantity) {
		this.totalItemCost = this.cost * quantity;
	}

	public double getTotalItemCost() {
		return totalItemCost;
	}
}
