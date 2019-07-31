package com.pfs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Client;
import com.pfs.utils.ClientUtils;


@WebServlet("/register_request")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = request.getParameter("cname");
		String cemail = request.getParameter("cemail");
		String cpass = request.getParameter("cpass");
		String caddress = request.getParameter("caddress");
		Long cphone  = Long.parseLong(request.getParameter("cphone"));
		Long caadhar  = Long.parseLong(request.getParameter("caadhar"));
		String cdob = request.getParameter("cdob");
		Client client=new Client(0,cname,cemail,cpass,caddress,cphone,caadhar,cdob);
		ClientUtils cu=new ClientUtils();
		if(cu.addClient(client)){
			HttpSession session= request.getSession();
			client = cu.validateClient(cemail, cpass);
			session.setAttribute("client",client);
			session.setAttribute("pointer", "0");
			response.sendRedirect("ClientLoginHome.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
