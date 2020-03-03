package com.metacube.shopping.dao;

import java.util.HashMap;
import java.util.HashSet;

import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

/**
 * DAO layer of layered architecture.
 */
public class CartDao {

	static HashMap<Integer, Item> products = new HashMap<Integer,Item>();	

	static HashMap<Integer,Item> userCart =new HashMap<Integer,Item>(); 
	static HashSet<Integer> itemCode = new HashSet<Integer>();
	
	/**
	 * Function to store items in HashMap.
	 * @return Returns the HashMap in which items are stored.
	 */
	public static HashMap<Integer, Item> storeItems(){
		Item prod1 = new Item("Candy",40);
		Item prod2 = new Item("Bread",30);
		Item prod3 = new Item("Butter",50);
		Item prod4 = new Item("Milk",43);
		Item prod5 = new Item("Toast",60);
		Item prod6 = new Item("Curd",20);
		Item prod7 = new Item("Cream",80);
		Item prod8 = new Item("Pastry",45);
		Item prod9 = new Item("Cake",300);
		Item prod10 = new Item("Panner",200);
		Item prod11 = new Item("Egg",8);
		products.put(1,prod1);
		products.put(2,prod2);
		products.put(3,prod3);
		products.put(4,prod4);
		products.put(5,prod5);
		products.put(6,prod6);
		products.put(7,prod7);
		products.put(8,prod8);
		products.put(9,prod9);
		products.put(10,prod10);
		products.put(11,prod11);
		return products;
	}
	
	/**
	 * Function to store ID of items in HashSet.
	 * @return Returns the HashSet.
	 */
	public static HashSet<Integer> storeId()
	{
		itemCode.add(1);
		itemCode.add(2);
		itemCode.add(3);
		itemCode.add(4);
		itemCode.add(5);
		itemCode.add(6);
		itemCode.add(7);
		itemCode.add(8);
		itemCode.add(9);
		itemCode.add(10);
		itemCode.add(11);
		return itemCode;
	}

	/**
	 * Function to add item in cart.
	 * @param id of item to be added in cart.
	 * @param quantity of item to be added in cart.
	 */
	public static void addItem(int id,int quantity){
		if(userCart.containsKey(id)){
			int newQuantity = userCart.get(id).getQuantity() + quantity;
			userCart.get(id).setQuantity(newQuantity);
			System.out.println(CartMessage.ALREADY_ADDED + newQuantity);
		}
		else{
			products.get(id).setQuantity(quantity);
			userCart.put(id,products.get(id));
			System.out.println(CartMessage.ITEM_ADDED);
		}
	}
	
	/**
	 * Function to edit item from cart.
	 * @param id of item to be edited.
	 * @param quantity of item to be saved.
	 */
	public static void editItem(int id,int quantity){
		if(!userCart.containsKey(id)){
			System.out.println(CartMessage.ITEM_NOT_IN_CART);
		}
		else{
			System.out.println(CartMessage.ITEM_EDITED);
			userCart.get(id).setQuantity(quantity);
		}
	}
	
	/**
	 * Funtion used to remove the item from cart.
	 * @param id of the item which we have to remove from cart.
	 */
	public static void removeItem(int id){
		if(!userCart.containsKey(id)){
			System.out.println(CartMessage.INVALID_ID);
		}
		else{
			userCart.remove(id);
			System.out.println(CartMessage.ITEM_REMOVED);
		}
	}
	
	/**
	 * Cart for the user.
	 * @return Returns the cart.
	 */
	public static HashMap<Integer,Item> getUserCart(){
		return userCart;
	}

	
}
