package com.metacube.shopping.facade;

import java.util.HashMap;
import java.util.HashSet;

import com.metacube.shopping.dao.CartDao;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

/**
 * Facade layer of architecture.
 */
public class CartFacade {
	/**
	 * Function for storing items.
	 * @return HashMap of stored items.
	 */
	public static HashMap<Integer, Item> storeItemFacade(){
		HashMap<Integer, Item> products = CartDao.storeItems();
		return products;
	}
	
	/**
	 * Function to return itemcode.
	 * @return Returns the itemcode.
	 */
	public static HashSet<Integer> storeIdFacade() 
	{
		HashSet<Integer> itemCode= CartDao.storeId();
		return itemCode;
	}
	
	/**
	 * Function to add item to list which user want to buy. 
	 * @param id ID of item.
	 * @param quantity Quantity of item.
	 */
	public static void addItemF(int id,int quantity){
		CartDao.addItem(id, quantity);
	}

	/**
	 * Function to view the cart.
	 */
	public static void viewCartF(){
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		if(userCart.isEmpty()){
			System.out.println(CartMessage.EMPTY_CART);
		}
		else{
			System.out.println(CartMessage.CART_HEADER);
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())  
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity()); 
		}
	}

	/**
	 * Function to edit items.
	 * @param id of item to be edited. 
	 * @param quantity of items to be edited.
	 */
	public static void editItemF(int id,int quantity){
		CartDao.editItem(id, quantity);
	}

	/**
	 * Function to remove the items.
	 * @param id of the item which we want to remove.
	 */
	public static void removeItemF(int id){
		CartDao.removeItem(id);
	}
	
	/**
	 * Function to generate the bill.
	 * @return Return the amount to be paid by user. 
	 */
	public static int billF(){
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity() * entry.getValue().getPrice();
		return amount;
	}

}
