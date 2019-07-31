package com.pfs.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Request;
import com.pfs.utils.CommonUtils;

@WebServlet("/patentServlet")
public class PatentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Request> reqList = new ArrayList<Request>();
		CommonUtils cu=new CommonUtils();
		reqList = cu.getAllApprovedRequests();
		
		HttpSession session = request.getSession();
		session.setAttribute("reqList",reqList);
		
		response.sendRedirect("Patents.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
