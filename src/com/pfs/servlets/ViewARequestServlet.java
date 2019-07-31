package com.pfs.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfs.bean.Client;
import com.pfs.bean.Request;
import com.pfs.utils.ClientUtils;
import com.pfs.utils.ExaminerUtils;


@WebServlet("/viewRequest")
public class ViewARequestServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid=Integer.parseInt(request.getParameter("rid"));
		ExaminerUtils eu=new ExaminerUtils();
		Request r=eu.getRequest(rid);
		
		ClientUtils cu=new ClientUtils();
		Client client=cu.getClient(r.getClient().getCid());
		
		List<Request> reqList=new ArrayList<Request>();
		reqList=eu.getClientRequests(r.getClient().getCid());
		
		HttpSession session = request.getSession(false);
			session.setAttribute("r", r);
			session.setAttribute("client", client);
			session.setAttribute("reqList", reqList);
			response.sendRedirect("ViewRequest.jsp");
		
		/*RequestDispatcher dis = request.getRequestDispatcher("ViewRequest.jsp");
		dis.forward(request, response);*/
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
