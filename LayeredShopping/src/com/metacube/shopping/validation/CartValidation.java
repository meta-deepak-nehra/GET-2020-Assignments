package com.metacube.shopping.validation;

import com.metacube.shopping.message.CartMessage;

/**
 * Class for general validations.
 */
public class CartValidation {
	/**
	 * Function for validation on quantity.
	 * @param quantity on which we have to check validation.
	 * @return Returns the quantity.
	 */
	public static int quantityValidation(int quantity){
		if(quantity > 10){
			quantity = 10;
			System.out.println(CartMessage.QUANTITY_GREATER_ALERT);
			return quantity;
		}
		else
			return quantity;
	}
}
