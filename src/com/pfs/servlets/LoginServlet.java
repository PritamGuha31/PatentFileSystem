package com.pfs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Client;
import com.pfs.bean.Examiner;
import com.pfs.utils.ClientUtils;
import com.pfs.utils.ExaminerUtils;


@WebServlet("/login_request")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		Examiner examiner=new Examiner();
		Client client=new Client();
		
			if(usertype.equals("client")){
				ClientUtils cu=new ClientUtils();
				client=cu.validateClient(email, password);
				if(client != null){
					HttpSession session= request.getSession();
					session.setAttribute("client",client);
					session.setAttribute("pointer", "0");
					session.setAttribute("status",null);
					response.sendRedirect("ClientLoginHome.jsp");
				}else{
					PrintWriter out = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('You have entered wrong email ID and password combination');");  
					out.println("window.location='Home.jsp';");
					out.println("</script>");
				}
			}else if(usertype.equals("examiner")) {
				ExaminerUtils eu=new ExaminerUtils();
				examiner=eu.validateExaminer(email, password);
				if(examiner != null){
					HttpSession session= request.getSession();
					session.setAttribute("examiner",examiner);
					session.setAttribute("examinerpointer", "0");
					response.sendRedirect("ExaminerLoginHome.jsp");
				}else{
					PrintWriter out = response.getWriter();  
					response.setContentType("text/html");  
					out.println("<script type=\"text/javascript\">");  
					out.println("alert('You have entered wrong email ID and password combination');");  
					out.println("window.location='Home.jsp';");
					out.println("</script>");
				}
			}	
		}
			

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
