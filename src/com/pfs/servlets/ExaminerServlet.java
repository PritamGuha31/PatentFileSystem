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

import com.pfs.bean.Examiner;
import com.pfs.bean.Request;
import com.pfs.utils.CommonUtils;
import com.pfs.utils.ExaminerUtils;


@WebServlet("/examinerServlet")
public class ExaminerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Examiner> examinerList = new ArrayList<Examiner>();
		ExaminerUtils cu=new ExaminerUtils();
		examinerList = cu.getAllExaminer();
		
		HttpSession session = request.getSession();
		session.setAttribute("examinerList",examinerList);
		
		response.sendRedirect("Examiner.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
