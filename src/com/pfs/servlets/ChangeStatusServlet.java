package com.pfs.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Request;
import com.pfs.utils.ExaminerUtils;


@WebServlet("/changeStatus")
public class ChangeStatusServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid=Integer.parseInt(request.getParameter("rid"));
		ExaminerUtils eu=new ExaminerUtils();
		Request r=eu.getRequest(rid);
		
		HttpSession session = request.getSession();
		session.setAttribute("r", r);
		session.setAttribute("rid", rid);
		response.sendRedirect("ChangeStatus.jsp");
		
//		session.setAttribute("rid", rid);
//		RequestDispatcher dis = request.getRequestDispatcher("StatusUpdateServlet.java");
//		dis.forward(request, response);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
