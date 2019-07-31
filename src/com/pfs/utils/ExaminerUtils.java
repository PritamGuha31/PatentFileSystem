package com.pfs.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.pfs.bean.Client;
import com.pfs.bean.Comment;
import com.pfs.bean.Examiner;
import com.pfs.bean.Request;

public class ExaminerUtils {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	//for examiner login
	public Examiner validateExaminer(String email, String pass){
		Examiner ex=null;
		conn=DBUtils.getConnection("pfs");
		String sql="select * from examiner where email='"+email+"' and epassword='"+pass+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					ex=new Examiner(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return ex;
	}
	
	//adding Examiner comments to a patent request
	public boolean addCommentExaminer(Comment comment){
		boolean inserted=false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "insert into comments (rid,comm_date,comm_text,eid) values (?,now(),?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setInt(1, comment.getRequest().getRid());
			//pst.setString(2, comment.getComm_date());
			pst.setString(2, comment.getComm_text());
			pst.setInt(3, comment.getExaminer().getEid());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r>0){
				inserted=true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	//view all patent requests
	public List<Request> getAllRequests(){
		List<Request> requestList = new ArrayList<Request>();
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select r.rid,r.rdesc,r.rdate,r.rstatus,c.cid,c.cname,c.cemail,c.cpass,c.caddress,c.cphone,c.caadhar,c.cdob from requests r, client c where r.cid=c.cid";
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			Request req = null;
			
			if(rs != null){
				while(rs.next()){
					Client c=new Client();
					c.setCid(rs.getInt(5));
					c.setCname(rs.getString(6));
					c.setCemail(rs.getString(7));
					c.setCpass(rs.getString(8));
					c.setCaddress(rs.getString(9));
					c.setCphone(rs.getLong(10));
					c.setCaadhar(rs.getLong(11));
					c.setDob(rs.getString(12));
					req = new Request(rs.getInt(1),c,rs.getString(2),rs.getString(3),rs.getString(4));				
					requestList.add(req);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return requestList;
	}
	
	//to get the request for a particular request ID
	public Request getRequest(int rid){
		
			Request request = null;
			
			conn = DBUtils.getConnection("pfs");
			
			String sql = "select r.rid,r.rdesc,r.rdate,r.rstatus,c.cid,c.cname,c.cemail,c.cpass,c.caddress,c.cphone,c.caadhar,c.cdob from requests r, client c where r.cid=c.cid and r.rid="+rid;
			
			stmt = DBUtils.getSimpleStatement();
			
			try{
				rs = stmt.executeQuery(sql);
				
				if(rs != null){
					while(rs.next()){
						Client c=new Client();
						c.setCid(rs.getInt(5));
						c.setCname(rs.getString(6));
						c.setCemail(rs.getString(7));
						c.setCpass(rs.getString(8));
						c.setCaddress(rs.getString(9));
						c.setCphone(rs.getLong(10));
						c.setCaadhar(rs.getLong(11));
						c.setDob(rs.getString(12));
						request = new Request(rs.getInt(1),c,rs.getString(2),rs.getString(3),rs.getString(4));
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			DBUtils.closeResources();
			
			return request;
		}
	
	//to pass an EID and get a particular Examiner object
	public Examiner getExaminer(int eid){
		Examiner examiner = null;
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select * from examiner where eid="+eid;
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
					examiner = new Examiner(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return examiner;
	}
	
	public boolean changeStatus(int rid, String s){
		boolean updated = false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "update requests set rstatus=? where rid=?";
			
			pst = DBUtils.getPreparedStatement(sql);
			try{
				pst.setString(1, s);
				pst.setInt(2, rid);
			}catch(SQLException e){
				e.printStackTrace();
			}
			int r = pst.executeUpdate();
			
			if(r > 0){
				updated = true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return updated;
	}
	
	//to view requests of a particular client
	public List<Request> getClientRequests(int cid){
		List<Request> requestList = new ArrayList<Request>();
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select r.rid,r.rdesc,r.rdate,r.rstatus,c.cid,c.cname,c.cemail,c.cpass,c.caddress,c.cphone,c.caadhar,c.cdob from requests r, client c where r.cid=c.cid and r.cid="+cid;
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			Request req = null;
			
			if(rs != null){
				while(rs.next()){
					Client c=new Client();
					c.setCid(rs.getInt(5));
					c.setCname(rs.getString(6));
					c.setCemail(rs.getString(7));
					c.setCpass(rs.getString(8));
					c.setCaddress(rs.getString(9));
					c.setCphone(rs.getLong(10));
					c.setCaadhar(rs.getLong(11));
					c.setDob(rs.getString(12));
					req = new Request(rs.getInt(1),c,rs.getString(2),rs.getString(3),rs.getString(4));				
					requestList.add(req);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return requestList;
	}
	
	//view all pending or processing patent requests
			public List<Request> getAllPendingOrProcessingRequests(){
				List<Request> requestList = new ArrayList<Request>();
				
				conn = DBUtils.getConnection("pfs");
				String status1="Pending";
				String status2="Processing";
				
				String sql = "select r.rid,r.rdesc,r.rdate,r.rstatus,c.cid,c.cname,c.cemail,c.cpass,c.caddress,c.cphone,c.caadhar,c.cdob from requests r, client c where r.cid=c.cid and ( rstatus='"+status1+"' OR rstatus='"+status2+"')";
				
				stmt = DBUtils.getSimpleStatement();
				
				try{
					rs = stmt.executeQuery(sql);
					
					Request req = null;
					
					if(rs != null){
						while(rs.next()){
							Client c=new Client();
							c.setCid(rs.getInt(5));
							c.setCname(rs.getString(6));
							c.setCemail(rs.getString(7));
							c.setCpass(rs.getString(8));
							c.setCaddress(rs.getString(9));
							c.setCphone(rs.getLong(10));
							c.setCaadhar(rs.getLong(11));
							c.setDob(rs.getString(12));
							req = new Request(rs.getInt(1),c,rs.getString(2),rs.getString(3),rs.getString(4));				
							requestList.add(req);
						}
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
				
				DBUtils.closeResources();
				
				return requestList;
			}
			//to get all examiners details
			public List<Examiner> getAllExaminer(){
				List<Examiner> examinerList = new ArrayList<Examiner>();
				
				conn = DBUtils.getConnection("pfs");
				
				String sql = "select * from examiner";
				
				stmt = DBUtils.getSimpleStatement();
				
				try{
					rs = stmt.executeQuery(sql);
					
					Examiner examiner = null;
					
					if(rs != null){
						while(rs.next()){
							/*Client c=new Client();
							c.setCid(rs.getInt(5));
							c.setCname(rs.getString(6));
							c.setCemail(rs.getString(7));
							c.setCpass(rs.getString(8));
							c.setCaddress(rs.getString(9));
							c.setCphone(rs.getLong(10));
							c.setCaadhar(rs.getLong(11));
							c.setDob(rs.getString(12));
							req = new Request(rs.getInt(1),c,rs.getString(2),rs.getString(3),rs.getString(4));				
							requestList.add(req);*/
							examiner = new Examiner(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
							examinerList.add(examiner);
						}
					}
				}catch(SQLException e){
					e.printStackTrace();
				}
				
				DBUtils.closeResources();
				
				return examinerList;
			}
}
