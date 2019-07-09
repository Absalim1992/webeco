package com.webeco.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webeco.entity.Product;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		
		if(cart == null || cart.isEmpty())
		{			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/noitemsincart.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println(cart.get(0).getPid());
			request.setAttribute("cart", cart);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showcart.jsp");
			rd.forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		String user = (String) session.getAttribute("USERNAME");
		@SuppressWarnings("unchecked")
		List<Product> cart = (List<Product>)session.getAttribute("cart");
		String pid = request.getParameter("hdnpid2");	
		System.out.println("|"+pid+"|");
		int i=0;
		if(!cart.isEmpty())
		{
			i=0;
			for(i=0;i<cart.size();i++)
			{
				if(cart.get(i).getPid().equals(pid) && cart.get(i).getQuantity()==1)
				{
					cart.remove(i);
				}
				else if(cart.get(i).getPid().equals(pid))
				{
					cart.get(i).setQuantity(cart.get(i).getQuantity()-1);
				}
				i+=1;
			}
		}
		request.setAttribute("cart", cart);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showcart.jsp");
		rd.forward(request, response);
	}


}
