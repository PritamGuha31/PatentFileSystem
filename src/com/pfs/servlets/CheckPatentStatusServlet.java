package com.pfs.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.utils.ClientUtils;

@WebServlet("/patent_status")
public class CheckPatentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		int pointer = Integer.parseInt((String)session.getAttribute("pointer"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		String status=null;
		if(rid!=0){
			ClientUtils cu=new ClientUtils();
			status = cu.checkStatus(rid);
			if(status!=null){
				session.setAttribute("status", status);
				session.setAttribute("pointer", "2");
				response.sendRedirect("ClientLoginHome.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
