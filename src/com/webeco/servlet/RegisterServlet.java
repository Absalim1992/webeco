package com.webeco.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.webeco.entity.Member;
import com.webeco.service.MemberService;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userName = request.getParameter("reg_username");
		String name = request.getParameter("reg_profilename");
		String password = request.getParameter("reg_password");
		String phNo = request.getParameter("reg_phoneno");
		String mailId = request.getParameter("reg_email");
		System.out.println(userName + " - " + name + " - "  +  password + " - " + phNo + " - " + mailId);
		
		Member m = new Member(userName, name,phNo, mailId, password);
		if(MemberService.create(m))
		{
			System.out.println("Registration successful");
			
		}
		else
		{
			System.out.println("Username is taken, try again!");
		}
		
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/login.jsp");
				rd.forward(request, response);
	}

}
