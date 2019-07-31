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

import com.pfs.bean.Comment;
import com.pfs.bean.Examiner;
import com.pfs.bean.Request;
import com.pfs.utils.CommonUtils;
import com.pfs.utils.ExaminerUtils;

@WebServlet("/addComment")
public class AddCommentServlet extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid=Integer.parseInt(request.getParameter("rid"));
		ExaminerUtils eu=new ExaminerUtils();
		Request req=eu.getRequest(rid);
		
		HttpSession session = request.getSession(false);
		Examiner examiner= (Examiner)session.getAttribute("examiner");
		session.setAttribute("req", req);
		List<Comment> commlistclient = new ArrayList<Comment>();
		List<Comment> commlistexaminer = new ArrayList<Comment>();
		CommonUtils cu=new CommonUtils();
		commlistclient=cu.getAllCommentsWrtRidCid(req.getRid(),req.getClient().getCid());
		commlistexaminer=cu.getAllExaminerCommentsWrtRid(req.getRid());
		session.setAttribute("commlistclient", commlistclient);
		session.setAttribute("commlistexaminer", commlistexaminer);
		response.sendRedirect("AddComment.jsp");
		
		/*RequestDispatcher dis = request.getRequestDispatcher("ViewRequest.jsp");
		dis.forward(request, response);*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
