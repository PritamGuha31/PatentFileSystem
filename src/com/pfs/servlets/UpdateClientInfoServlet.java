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


@WebServlet("/update_request")
public class UpdateClientInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		Client client=(Client)session.getAttribute("client");
		int cid=client.getCid();
		String cname = request.getParameter("cname");
		String cemail = request.getParameter("cemail");
		String cpass = request.getParameter("cpass");
		String caddress = request.getParameter("caddress");
		Long cphone  = Long.parseLong(request.getParameter("cphone"));
		Long caadhar  = Long.parseLong(request.getParameter("caadhar"));
		String cdob = request.getParameter("cdob");
		Client c=new Client(cid,cname,cemail,cpass,caddress,cphone,caadhar,cdob);
		ClientUtils cu=new ClientUtils();
		if(cu.updateClientDetails(c))
			System.out.println("updated");
			session.setAttribute("client",c);
			response.sendRedirect("ClientLoginHome.jsp");
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
