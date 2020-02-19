package com.geta.restassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoreData {
	Connection con = null;

	public StoreData() {
		String url = "jdbc:mysql://localhost:3306/test";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Store> getItems() {
		List<Store> items = new ArrayList<>();
		String sql = "select * from fruitstore";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Store fruit = new Store();
				fruit.setName(rs.getString(1));
				fruit.setQuantity(rs.getInt(2));

				items.add(fruit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	public Store getItem(String name) 
	{
		String sql = "select * from fruitstore where fName='"+name+"'";
		Store fruit = new Store();

		try 
		{
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) 
			{
				fruit.setName(rs.getString(1));
				System.out.println(rs.getString(1));
				fruit.setQuantity(rs.getInt(2));
				System.out.println(rs.getInt(2));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return fruit;
	}

	public void create(Store s) 
	{
		String sql = "insert into fruitstore values(?,?)";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, s.getName());
			st.setInt(2, s.getQuantity());
			st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void updateFullTable(Store s) throws SQLException 
	{
		String sql = "truncate table fruitstore";
//		System.out.println("eeeefefdetdyfugjkhidf");
		PreparedStatement st = con.prepareStatement(sql);
//		System.out.println("eee876578");
		st.execute();
//		System.out.println("eeeefefdedf");

		String sql1 = "insert into fruitstore values(?,?)";

		st = con.prepareStatement(sql1);
		st.setString(1, s.getName());
		st.setInt(2, s.getQuantity());
		st.executeUpdate();

	}

	public void update(Store s) 
	{
//		int qq=s.getQuantity();
//		String nn=s.getName();
		String sql = "update fruitstore set fQuantity=? where fName=?";
//		System.out.println("eeeefefdetdyfugjkhidf");
//		System.out.println(sql1);
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println("eee876578");
			st.setInt(1, s.getQuantity());
			st.setString(2, s.getName());
			System.out.println("12345678");
			st.executeUpdate();
//			System.out.println(i);
			System.out.println("eeeefefdedf");
//			st1.executeUpdate(sql1);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void delete(String name) 
	{
		String sql = "delete from fruitstore where fName=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, name);
			st.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}



/*
public void update(Store s) 
{
	int qq=s.getQuantity();
	String nn=s.getName();
	String sql1 = "update fruitstore set fQuantity="+qq+" where fName='"+nn+"'";
//	System.out.println("eeeefefdetdyfugjkhidf");
//	System.out.println(sql1);
	try 
	{
		Statement st1 = con.createStatement();
//		System.out.println("eee876578");
////		st1.setInt(1, s.getQuantity());
////		st1.setString(2, s.getName());
//		System.out.println("12345678");
////		int i=st1.executeUpdate();
////		System.out.println(i);
//		System.out.println("eeeefefdedf");
		st1.executeUpdate(sql1);
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
}*/