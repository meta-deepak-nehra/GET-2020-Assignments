package com.metacube.shopping.controller;

import java.util.HashMap;
import java.util.HashSet;

import com.metacube.shopping.facade.CartFacade;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;
/**
 *Controller class for layered architecture.
 */
public class CartController {

	/**
	 * Function for storing items.
	 * @return HashMap of stored items.
	 */
	public static HashMap<Integer, Item> storeItemFacade(){
		HashMap<Integer, Item> products = CartFacade.storeItemFacade();
		return products;
	}

	/**
	 * Function to show items to user.
	 * @param products which we are showing to user.
	 */
	public static void showItem(HashMap<Integer, Item> products){
		System.out.println(CartMessage.SHOPPING_HEADER);
		for (HashMap.Entry<Integer,Item> entry : products.entrySet()){
			System.out.println(entry.getKey() +" \t \t"+entry.getValue().getName()+" \t \t"+ entry.getValue().getPrice());
		}
	}
	
	/**
	 * Function to return itemcode.
	 * @return Returns the itemcode.
	 */
	public static HashSet<Integer> storeId()
	{
		HashSet<Integer> itemCode= CartFacade.storeIdFacade();
		return itemCode;
	}
	
	/**
	 * Function to add item to list which user want to buy. 
	 * @param id ID of item.
	 * @param quantity Quantity of item.
	 */
	public static void addItem(int id,int quantity){
		CartFacade.addItemF(id, quantity);
	}
	
	/**
	 * Function to view the cart.
	 */
	public static void viewCart(){
		CartFacade.viewCartF();
	}
	
	/**
	 * Function to edit items.
	 * @param id of item to be edited. 
	 * @param quantity of items to be edited.
	 */
	public static void editItem(int id,int quantity){
		CartFacade.editItemF(id, quantity);
	}
	
	/**
	 * Function to remove the items.
	 * @param id of the item which we want to remove.
	 */
	public static void removeItem(int id){
		CartFacade.removeItemF(id);
	}
	
	/**
	 * Function to generate the bill.
	 * @return Return the bill using cart. 
	 */
	public static int bill(){
		return CartFacade.billF();
	}
}
