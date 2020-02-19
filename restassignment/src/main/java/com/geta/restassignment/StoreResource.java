package com.geta.restassignment;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("stores")
public class StoreResource 
{
	StoreData data= new StoreData();
	
	@GET
	@Path("inventory")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> getItems()
	{	
		return data.getItems();
	}
	
	@GET
	@Path("inventory/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Store getItem(@PathParam("name")String name)
	{
		return data.getItem(name);
	}
	
	@POST
	@Path("inventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Store createItem(Store s)
	{
		data.create(s);
		return s;
	}
	
	@PUT
	@Path("inventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public Store updateItem(Store s)throws SQLException
	{
		data.updateFullTable(s);
		return s;
	}
	
	@PUT
	@Path("inventory/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Store updateItems(Store s)
	{
		if(data.getItem(s.getName()).getName()==null)
		{
			data.create(s);
		}
		else 
		{
			data.update(s);
		}
		return s;
	}
	
	@DELETE
	@Path("inventory/{name}")
	public Store deleteItem(@PathParam("name")String name) 
	{
		Store s=data.getItem(name);
		if(s.getName()!=null)
			data.delete(name);
		return s;
	}
}
