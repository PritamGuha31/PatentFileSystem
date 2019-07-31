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

import com.pfs.bean.Client;
import com.pfs.bean.Comment;
import com.pfs.bean.Examiner;
import com.pfs.bean.Request;
import com.pfs.utils.CommonUtils;
import com.pfs.utils.ExaminerUtils;

@WebServlet("/clientcomments")
public class ClientCommentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(request.getParameter("rid"));
		ExaminerUtils eu=new ExaminerUtils();
		Request req=eu.getRequest(rid);
		
		HttpSession session = request.getSession(false);
		Client client= (Client)session.getAttribute("client");
		session.setAttribute("req", req);
		
		List<Comment> commlistclient = new ArrayList<Comment>();
		List<Comment> commlistexaminer = new ArrayList<Comment>();
		CommonUtils cu=new CommonUtils();
		commlistclient=cu.getAllCommentsWrtRidCid(rid,client.getCid());
		commlistexaminer=cu.getAllExaminerCommentsWrtRid(rid);
		
		session.setAttribute("commlistclient", commlistclient);
		session.setAttribute("commlistexaminer", commlistexaminer);
		response.sendRedirect("ClientComment.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
