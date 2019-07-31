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


@WebServlet("/addCommentClient")
public class AddCommentClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession(false);
		Request req=(Request)session.getAttribute("req");
		ClientUtils cu=new ClientUtils();
		Examiner examiner= new Examiner();
		Client client =(Client)session.getAttribute("client");
		
		String comm_text = request.getParameter("comm_text");
		//String comm_date = request.getParameter("comm_date");
		Comment comment=new Comment(0,req,"",comm_text,client,examiner);
		List<Comment>commlistclient=(ArrayList<Comment>)session.getAttribute("commlistclient");
		boolean res=false;
		if(client!= null || comm_text != null){
			res= cu.addCommentClient(comment);
			if(res){
				CommonUtils commonu=new CommonUtils();
				commlistclient=commonu.getAllCommentsWrtRidCid(req.getRid() ,client.getCid());
						
				session.setAttribute("commlistclient", commlistclient);
				response.sendRedirect("ClientComment.jsp");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
