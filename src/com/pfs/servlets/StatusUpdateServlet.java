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


@WebServlet("/statusUpdate")
public class StatusUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession(false);
		Request r=(Request)session.getAttribute("r");
		int rid=r.getRid();
		String rstatus= request.getParameter("rstatus");
		ExaminerUtils eu=new ExaminerUtils();
		boolean update= eu.changeStatus(rid, rstatus);
		
		if(update) {
			
			session.setAttribute("examinerpointer", "1");
			r.setRstatus(rstatus);
			response.sendRedirect("ChangeStatus.jsp");
		}
		
		
		//int flag=0;
		
		
		/*
		if(update) {
			flag=1;
			HttpSession session= request.getSession(false);
			session.setAttribute("flag",flag);
			response.sendRedirect("ChangeStatus.jsp");
		}else {
			HttpSession session= request.getSession(false);
			session.setAttribute("flag",flag);
			response.sendRedirect("ChangeStatus.jsp");
		}*/
		
		
		

		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
