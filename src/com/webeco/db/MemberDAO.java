package com.webeco.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webeco.entity.Member;
import com.webeco.entity.Order;
import com.webeco.entity.OrderItem;
import com.webeco.entity.Product;


public class MemberDAO {

	
	//inserting values to register n login table
	public boolean create(Member member)
	{
		String sql1 = "insert into register values(?,?,?,?,?)";
		String sql2 = "insert into login values(?,?)";
		String sql3 = "select userName from register where userName=?";
		int rows1 = 0, rows2 = 0;
		String dummyUserName = null;
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps2 = conn.prepareStatement(sql3);
			ps2.setString(1, member.getUserName());
			ResultSet rs = ps2.executeQuery();
			
			if(rs != null && rs.next())
			{
				dummyUserName = rs.getString(1);
			}
			
			if(dummyUserName != null && dummyUserName.equals(member.getUserName()))
			{
				return false;
			}
			else
			{			
				PreparedStatement ps = conn.prepareStatement(sql1);
				ps.setString(1, member.getUserName());
				ps.setString(2, member.getPassword());
				ps.setString(3, member.getName());
				ps.setString(4, member.getPhNo());
				ps.setString(5, member.getMailId());
				rows1 = ps.executeUpdate();
			
				PreparedStatement ps1 = conn.prepareStatement(sql2);
				ps1.setString(1, member.getUserName());
				ps1.setString(2, member.getPassword());
				rows2 = ps1.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return rows1 > 0 && rows2 == rows1;
	}
	
	public boolean loginCheck(Member m)
	{
		
		String dummyUName = null;
		String dummyPass = null;
		int row1 = 0;
		
		String sql1 = "select userName,password from login where userName LIKE (?)";
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql1);
			ps.setString(1, m.getUserName());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs != null && rs.next())
			{
				dummyUName = rs.getString(1);
				System.out.println(dummyUName);
				dummyPass = rs.getString(2);
				System.out.println(dummyPass);
			}
			if(dummyUName != null && dummyUName.equals(m.getUserName()) && dummyPass != null && dummyPass.equals(m.getPassword()))
			{
				row1 = 1;
			}
		} catch (SQLException e) {
					e.printStackTrace();
		}
		return row1 > 0;
	}
	
	public boolean addToCart(String user, String pid)
	{
		int row = 0;
		String sql1 = "select productId from cart where userName=? and productId=?";
		String sql2 = "insert into cart value(?,?,?)";
		String sql3 = "update cart set quantity = quantity+? where userName=? and productId=?";
		String p = null;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, user);
			ps1.setString(2, pid);
			ResultSet rs = ps1.executeQuery();
			if(rs !=null && rs.next())
			{
				p = rs.getString(1);
			}
			if(p != null && p.equals(pid))
			{
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, 1);
				ps3.setString(2, user);
				ps3.setString(3, pid);
				row = ps3.executeUpdate();
			}
			else
			{
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1,user);
				ps2.setString(2, pid);
				ps2.setInt(3, 1);
				row = ps2.executeUpdate();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return (row>0);
	}
	
	public List<Product> getCart(String user)
	{
		
		List<String> productIdList = new ArrayList<>();
		String price = "0";
		List<Product> pList = new ArrayList<>();
		String sql0 = "select productId from cart where userName=?";
		String sql1 = "select price from product where productId = ?";
		String sql2 = "select quantity from cart where userName=? and productId = ?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			ps0.setString(1, user);
			ResultSet rs = ps0.executeQuery();
			while(rs != null && rs.next())
			{
				productIdList.add(rs.getString(1));
				System.out.println(rs.getString(1));
			}
			
			for(String p : productIdList)
			{
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setString(1, p );
				ResultSet rs1 = ps1.executeQuery();
				if(rs1 != null && rs1.next())
				{
					System.out.println(rs1.getString(1));
					price = rs1.getString(1);
				}	
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, user);
				ps2.setString(2, p);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2 != null && rs2.next())
				{
					pList.add(new Product(p, price, rs2.getInt(1)));
				}
			}
			return pList;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return pList;
	
	}
	
	public boolean delete(String user, String pid)
	{
		int row=0; 
		String sql1 = "select quantity from cart where userName=? and productId=?";
		String sql2 = "delete from cart userName=? and productId=?";
		String sql3 = "update cart set quantity = quantity-? where userName=? and productId=?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			int q = 0;
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, user);
			ps1.setString(2, pid);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1 != null && rs1.next())
			{
				q = rs1.getInt(1);
			}
			if(q == 1)
			{
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, user);
				ps2.setString(2, pid);
				row = ps2.executeUpdate();
			}
			else
			{
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, 1);
				ps3.setString(2, user);
				ps3.setString(3, pid);
				row = ps3.executeUpdate();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("row" +row);
		return row>0;
	}
	
	public boolean addOrderItem(OrderItem o)
	{
		int row = 0;
		
		String sql = "insert into orderitem values(?,?,?,?,?)";
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setLong(1, o.getOrderId());
			ps.setString(2, o.getProductId());
			ps.setString(3, o.getUsername());
			ps.setInt(4, o.getQuantity());
			ps.setFloat(5,o.getSubtotal());
			row = ps.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		return row>0;
	}
	
	public int addOrderDetails(Order o)
	{
		
		String sql = "insert into orders values(?,?,?,?,?,?,?)";
		int orderID=0;
		java.sql.Date dlvDate = new java.sql.Date(o.getDlvDate().getTime());//another way of converting Date type from java.util.Date to java.sql.Date
		java.sql.Date orderDate = new java.sql.Date(o.getOrderDate().getTime());
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, o.getOrderId());
			ps.setFloat(2, o.getSubtotal());
			ps.setFloat(3, o.getTax());
			ps.setFloat(4, o.getGrandtotal());
			ps.setDate(5, orderDate);
			ps.setDate(6, dlvDate);
			ps.setString(7, o.getStatus());
		    ps.executeUpdate();
		    ResultSet rs1 = ps.getGeneratedKeys();
			rs1.next();// moving the cursor from headings to the first row.
            orderID = rs1.getInt(1);
            return orderID;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean deleteCartItems(String user)
	{
		int row = 1;
		String sql = "delete from cart where userName = ?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			row = ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return row>0;
	}
	
	public List<Order> getOrderDetails(String user)
	{
		String sql = "select o.orderId,o.subTotal,tax,o.grandTotal,o.ordDate,o.dlvDate,o.status from orders o, orderitem ori where ori.userName =(?) and o.orderId=ori.orderId";
		List<Order> orders = new ArrayList<>(); 
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				orders.add(new Order(user, rs.getInt(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getDate(5), rs.getDate(6), rs.getString(7)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return orders;
	}
	
	public List<OrderItem> getOrderItems(int orderID)
	{
		List<OrderItem> list = new ArrayList<>();
		String sql = "select orderId,productId,quantity,sumOfItem from orderItem where orderId=?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderID);
			ResultSet rs = ps.executeQuery();
			while(rs!=null && rs.next())
			{
				list.add(new OrderItem(orderID, rs.getString(1),rs.getString(2), rs.getInt(3), rs.getFloat(4)));
			}
			return list;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}
}
