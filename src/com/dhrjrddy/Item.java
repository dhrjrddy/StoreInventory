package com.dhrjrddy;

public class Item {

	private String name;
	private double cost;
	private String manufacturer;

	public Item(String name, double cost, String manufacturer) {
		this.name = name;
		this.cost = cost;
		this.manufacturer = manufacturer;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public boolean matches(String otherItemName) {
		if (name.equals(otherItemName)) {
			return true;
		}
		return false;
	}
}
