package com.dhrjrddy;

import java.util.Iterator;
import java.util.LinkedList;

public class OrderManager implements OrderInterface {
	private LinkedList<OrderItem> orderItemsList;
	private StoreManager items;

	public OrderManager(StoreManager items) {
		orderItemsList = new LinkedList<OrderItem>();
		this.items = items;
	}

	public void addOrderedItem(String name, int quantity) {
		for (Iterator<Store> i = items.getItemList().iterator(); i.hasNext();) {
			Store item = (Store) i.next();
			if (item.getItem().matches(name)) {
				if (item.getQuantity() >= quantity) {
					OrderItem neworderitems = new OrderItem(name, quantity,
							item.getItem().getCost());
					neworderitems.setTotalItemCost(quantity);
					item.setQuantity(item.getQuantity() - quantity);
					orderItemsList.add(neworderitems);
				} else {
					System.out.println(item.getQuantity() + " "
							+ item.getItem().getName() + "are there.");
				}
			}
		}
		items.disply();
	}

	private void changeItemListInventory(String name, int quantity) {
		for (Iterator<Store> i = items.getItemList().iterator(); i.hasNext();) {
			Store item = (Store) i.next();
			if (item.getItem().matches(name)) {
				item.setQuantity(item.getQuantity() + quantity);
			}
		}
	}

	public void deleteOrderedItem(String name) {
		for (Iterator<OrderItem> i = orderItemsList.iterator(); i.hasNext();) {
			OrderItem orderitem = (OrderItem) i.next();
			if (orderitem.ordernamematches(name)) {
				changeItemListInventory(name, orderitem.getQuantity());
				orderItemsList.remove(orderitem);
				break;
			}
		}
		items.disply();
	}

	public void changeOrderedItem(String name, int quantity) {
		for (Iterator<OrderItem> i = orderItemsList.iterator(); i.hasNext();) {
			OrderItem orderitem = (OrderItem) i.next();
			if (orderitem.ordernamematches(name)) {
				changeItemListInventory(name, orderitem.getQuantity()
						- quantity);
				orderitem.setQuantity(quantity);
				orderitem.setTotalItemCost(quantity);
			}
		}
		items.disply();
	}

	public void displayOrderedItems() {
		for (Iterator<OrderItem> i = orderItemsList.iterator(); i.hasNext();) {
			OrderItem orderitem = (OrderItem) i.next();
			System.out.println(orderitem.getName() + ","
					+ orderitem.getQuantity() + ","
					+ orderitem.getTotalItemCost());
		}
		System.out.println();
	}
}
