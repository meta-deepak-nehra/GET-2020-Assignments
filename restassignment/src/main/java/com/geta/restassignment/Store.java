package com.geta.restassignment;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Store 
{	
	private String name;
	private int quantity;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

}
