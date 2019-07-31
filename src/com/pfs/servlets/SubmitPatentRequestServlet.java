package com.pfs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Client;
import com.pfs.bean.Request;
import com.pfs.utils.ClientUtils;

@WebServlet("/patent_request")
public class SubmitPatentRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		Client client = (Client)session.getAttribute("client");
		int pointer = Integer.parseInt((String)session.getAttribute("pointer"));
		int cid =  client.getCid();
		String rdesc = request.getParameter("rdesc");
		//String rdate = request.getParameter("rdate");
		Request req=new Request(0, client, rdesc, "", "Pending");
		boolean res=false;
		if(cid != 0 || rdesc != null){
			ClientUtils cu=new ClientUtils();
			res= cu.sendRequest(req);
			if(res){
				session.setAttribute("pointer", "1");
				response.sendRedirect("ClientLoginHome.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
