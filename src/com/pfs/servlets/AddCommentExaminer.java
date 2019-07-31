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
import com.pfs.utils.ClientUtils;
import com.pfs.utils.CommonUtils;
import com.pfs.utils.ExaminerUtils;

/**
 * Servlet implementation class AddCommentExaminer
 */
@WebServlet("/addCommentExaminer")
public class AddCommentExaminer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		Request req=(Request)session.getAttribute("req");
		ExaminerUtils eu=new ExaminerUtils();
		Examiner examiner= (Examiner)session.getAttribute("examiner");
		Client client =new Client();
		
		String comm_text = request.getParameter("comm_text");
		//String comm_date = request.getParameter("comm_date");
		Comment comment=new Comment(0,req,"",comm_text,client,examiner);
		List<Comment> commlistexaminer=(ArrayList<Comment>)session.getAttribute("commlistexaminer");
		boolean res=false;
		if(examiner!= null || comm_text != null){
			res= eu.addCommentExaminer(comment);
			if(res){
				CommonUtils cu=new CommonUtils();
				commlistexaminer=cu.getAllCommentsWrtRidEid(req.getRid(), examiner.getEid());
				session.setAttribute("commlistexaminer", commlistexaminer);
				response.sendRedirect("AddComment.jsp");
			}
			}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
