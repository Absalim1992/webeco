package com.webeco.junit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.webeco.db.DBConnectionManager;
import com.webeco.db.MemberDAO;
import com.webeco.entity.Member;
import com.webeco.entity.Order;
import com.webeco.entity.OrderItem;

public class TestWebEco {

	@Test
	public void testConnection() {
		Connection conn = DBConnectionManager.getConnection();
		assertNotNull(conn);
	}
	
	@Test
	public void testCreate()
	{
		MemberDAO dao = new MemberDAO();
		assertFalse(dao.create(new Member("abdul", "baseer", "7795084026", "absalim@gmail.com", "abdul")));
	}
    
	@Test
	public void testLogin()
	{
		MemberDAO dao = new MemberDAO();
		assertTrue(dao.loginCheck(new Member("salim", "salim")));
	}
   
	@Test
	public void testGetOrderDetails()
	{
		MemberDAO dao = new MemberDAO();
		List<Order> o,s = new ArrayList<>();
		o = dao.getOrderDetails("salim");
		s = dao.getOrderDetails("Iphone8,49999");
		assertTrue(!o.isEmpty());
		assertTrue(s.isEmpty());
	}
    
	@Test
	public void testGetOrderItems()
	{
		MemberDAO dao = new MemberDAO();
		List<OrderItem> o,s = new ArrayList<>();
		o = dao.getOrderItems(1);
		s = dao.getOrderItems(0);
		assertTrue(o.isEmpty());
		assertTrue(s.isEmpty());
	}


}
