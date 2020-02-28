package com.metacube.shopping.client;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.metacube.shopping.controller.CartController;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

/**
 * Class used for client interaction.
 */
public class Client {
	static Scanner scanner = new Scanner(System.in);
	static int itemId = 0, itemQuantity = 0, option, amount, flag = 0;
	final static int ADD_ITEM = 1, VIEW_CART = 2, EDIT_CART = 3, REMOVE_ITEM = 4, BILL = 5, EXIT = 6;

	/**
	 * Function for user input.
	 */
	public static void userInput(){
		do {
			System.out.println(CartMessage.OPTION_HEADER);
			System.out.println(CartMessage.SELECT_OPTION);
			try {
				option = scanner.nextInt();
				switch(option){
				case ADD_ITEM:
					do{
						try{
							System.out.println(CartMessage.ENTER_ID);
							itemId = scanner.nextInt();
							if(CartController.storeId().contains(itemId)==false)
							{
								System.out.println(CartMessage.INVALID_ID);
							}

							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALID_ID);
							System.out.println("");
						}
						scanner.nextLine();
					}while(flag == 0);
					do{
						try{
							System.out.println(CartMessage.ENTER_QUANTITY);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0){
								System.out.println(CartMessage.QUANTITY_INVALID);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.QUANTITY_INVALID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.addItem(itemId, itemQuantity);
					break;
				case VIEW_CART:
					CartController.viewCart();
					break;
				case EDIT_CART:
					do{
						try{
							System.out.println(CartMessage.ENTER_ID_EDIT);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.storeItemFacade().size()){
								System.out.println(CartMessage.INVALID_ID);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALID_ID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					do{
						try{
							System.out.println(CartMessage.ENTER_QUANTITY);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0){
								System.out.println(CartMessage.QUANTITY_INVALID);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.QUANTITY_INVALID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.editItem(itemId,itemQuantity);
					break;
				case REMOVE_ITEM:
					do{
						try{
							System.out.println(CartMessage.ENTER_ID_REMOVE);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.storeItemFacade().size()){
								System.out.println(CartMessage.INVALID_ID);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALID_ID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					CartController.removeItem(itemId);
					break;
				case BILL:
					amount = CartController.bill();
					if(amount == 0)
						System.out.println(CartMessage.EMPTY_CART);
					else
						CartController.viewCart();
						System.out.println("The total amount is :" + amount);
					break;
				case EXIT:
					System.out.println(CartMessage.THANK_YOU);
					System.exit(0);
					break;
				default:
					System.out.println(CartMessage.INVALID_OPTION);
				}
			} catch (Exception e) {
				System.out.println(CartMessage.INVALID_OPTION);
				scanner.nextLine();
			}
		}while(true);	
	}

	/**
	 * Main function.
	 * @param Arguments to run the main function.
	 */
	public static void main(String args[]){
		HashMap<Integer, Item> products = CartController.storeItemFacade();
		CartController.showItem(products);
		userInput();
	}
}
