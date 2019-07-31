import java.util.ArrayList;
import java.util.List;

import com.pfs.bean.Client;
import com.pfs.bean.Comment;
import com.pfs.bean.Examiner;
import com.pfs.bean.Request;
import com.pfs.utils.ClientUtils;
import com.pfs.utils.CommonUtils;
import com.pfs.utils.ExaminerUtils;

public class Test {

	public static void main(String[] args) {
		//Updating client
		/*Client c=new Client(2, "Pallavi Datta","pd@gmail.com", "pd345", "Garfa 4th Main Lane, Viveknagar", 8282807990L, 120987654321L, "1995-07-07");
		ClientUtils u=new ClientUtils();
		boolean res= u.updateClientDetails(c);
		if(res){
			System.out.println("Success..!");
		}
		else
			System.out.println("Failure..!");*/
		
		//sending patent request
		/*ClientUtils u=new ClientUtils();
		Client ct=u.getClient(1);
		Request r = new Request(0, ct, "Water", "2017-07-13", "Pending");
		boolean res= u.sendRequest(r,ct);
		if(res){
			System.out.println("Success..!");
		}
		else
			System.out.println("Failure..!");*/
		
		//Checking status of a patent request
		/*ClientUtils u=new ClientUtils();
		Request req=null;
		req= u.checkStatus(3);
		if(req!=null){
			System.out.println(req.toString());
		}*/
		
		//adding examiner comment
		/*ExaminerUtils eu=new ExaminerUtils();
		Examiner e= eu.getExaminer(3);
		Request r= eu.getRequest(3);
		Comment c=new Comment(0,r,"2017-07-13", "Excellent discovery!",null,e);
		
		boolean res= eu.addCommentExaminer(c,r,e);
		if(res){
			System.out.println("Success..!");
		}
		else
			System.out.println("Failure..!");*/
		
		//adding client comment
		/*ExaminerUtils eu=new ExaminerUtils();
		ClientUtils cu=new ClientUtils();
		Request r=eu.getRequest(3);
		Client ct=cu.getClient(2);
		Comment c=new Comment(0,r,"2017-07-13", "Thank you sir...",ct,null);
		boolean res= cu.addCommentClient(c,r,ct);
		if(res){
			System.out.println("Success..!");
		}
		else
			System.out.println("Failure..!");*/
		
		//checking ValidateExaminer
		/*ExaminerUtils eu=new ExaminerUtils();
		Examiner ex = eu.validateExaminer("vs@gmail.com", "viru678");
		System.out.println(ex);*/
		
		//checking Validate Client
		/*ClientUtils cu=new ClientUtils();
		Client c = cu.validateClient("pd@gmail.com", "pd123");
		System.out.println(c);*/
		
		//viweing client request lists
		/*ExaminerUtils eu=new ExaminerUtils();
		List<Request> allReq=new ArrayList<Request>();
		allReq = eu.getAllPendingOrProcessingRequests();
		for(Request r : allReq){
			System.out.println(r);
		}*/
		
		//to change the status of a request
		/*ExaminerUtils eu= new ExaminerUtils();
		boolean res = eu.changeStatus(3, "Approved");
		if(res)
			System.out.println("Updated");
		else
			System.out.println("Failed");*/
		
		//to get all comments wrt rid
		/*CommonUtils common=new CommonUtils();
		List<Comment> allComments=new ArrayList<Comment>();
		allComments = common.getAllCommentsWrtRidEid(3,3);
		for(Comment c : allComments){
			System.out.println(c);
		}*/
		
		//to get all examiner comments wrt rid
		CommonUtils common=new CommonUtils();
		List<Comment> allComments=new ArrayList<Comment>();
		allComments = common.getAllExaminerCommentsWrtRid(3);
		for(Comment c : allComments){
			System.out.println(c);
		}
		
		//to view a request wrt rid
		/*ExaminerUtils eu=new ExaminerUtils();
		Request request=eu.getRequest(3);
		System.out.println(request);*/
	}
}