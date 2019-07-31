package com.pfs.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Request;
import com.pfs.utils.ExaminerUtils;

@WebServlet("/approvedPatents")
public class ApprovedPatentsServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid=Integer.parseInt(request.getParameter("rid"));
		ExaminerUtils eu=new ExaminerUtils();
		Request req=eu.getRequest(rid);
		HttpSession session=request.getSession(false);
		session.setAttribute("req",req);
		response.sendRedirect("ApprovedPatents.jsp");
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
