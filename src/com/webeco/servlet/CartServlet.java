package com.webeco.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webeco.entity.Product;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		String price = request.getParameter("price");
		System.out.println(pid + ":" + price);
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		

		if(cart!=null && !cart.isEmpty())
		{
			System.out.println(price);
			for(int i =0;i<cart.size();i++)
			{
				if( cart.get(i) !=null && cart.get(i).getPid().equals(pid))
				{
					cart.get(i).setQuantity(cart.get(i).getQuantity()+1);
					session.setAttribute("cart", cart);
				}
				else
				{
					cart.add(new Product(pid, price, 1));
					session.setAttribute("cart", cart);
					break;
				}
			}
		}
		else
		{
			List<Product> cart1= new ArrayList<>();
			System.out.println(price);
			cart1.add(new Product(pid, price, 1));
			session.setAttribute("cart", cart1);
		}
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/menu.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
