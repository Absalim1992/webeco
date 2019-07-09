package com.webeco.service;

import java.util.List;

import com.webeco.db.MemberDAO;
import com.webeco.entity.Member;
import com.webeco.entity.Order;
import com.webeco.entity.OrderItem;
import com.webeco.entity.Product;

public class MemberService {

	public static boolean create(Member member)
	{
		MemberDAO dao = new MemberDAO();
		return dao.create(member);
	}
	
	public static boolean loginCheck(Member member)
	{
		MemberDAO dao = new MemberDAO();
		return dao.loginCheck(member);
	}
	
	public static boolean addToCart(String user,String pid)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addToCart(user,pid);
	}
	
	public static List<Product> getCart(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.getCart(user);
	}
	
	public static boolean delete(String user, String pid)
	{
		MemberDAO dao = new MemberDAO();
		return dao.delete(user, pid);
	}
	
	public static boolean addOrderItem(OrderItem o)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addOrderItem(o);
	}
	
	public static int addOrderDetails(Order o)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addOrderDetails(o);
	}
	
	public static boolean deleteCartItems(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.deleteCartItems(user);
	}
	
	public static List<Order> getOrderDetails(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.getOrderDetails(user);
	}
	public static List<OrderItem> getOrderItems(int orderID)
	{
		MemberDAO dao = new MemberDAO();
		return dao.getOrderItems(orderID);
	}
	

}
