package com.metacube.shopping.model;

import com.metacube.shopping.validation.CartValidation;

/**
 * POJO class of item.
 */
public class Item {
	
	private double price;
	private int quantity;
	private String name;
	
	/**
	 * Constructor of the item class
	 * @param name of the item
	 * @param price of the item
	 */
	public Item(String name,int price){
		this.price = price;
		this.name = name;
	}
	/**
	 * Get the price of the item. 
	 * @return Returns the price of item.
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Get the quantity of the item.
	 * @return Returns the quantity of item.
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Set the quantity of the item.
	 * @param quantity to set.
	 */
	public void setQuantity(int quantity) {
		this.quantity = CartValidation.quantityValidation(quantity);
	}
	
	/**
	 * Get the name of the item.
	 * @return Returns the name of item.
	 */
	public String getName() {
		return name;
	}
}
