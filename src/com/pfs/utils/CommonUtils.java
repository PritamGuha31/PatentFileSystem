package com.pfs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
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

public class CommonUtils {
 
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
		
	//View all comments wrt to RID and CID
	public List<Comment> getAllCommentsWrtRidCid(int rid,int cid){
	List<Comment> commentList = new ArrayList<Comment>();
	
	Request request=new Request();
	request.setRid(rid);
	
	conn = DBUtils.getConnection("pfs");
	
	String sql = "select comm.*, r.*, c.* from comments comm, requests r, client c where comm.rid=r.rid and comm.cid=c.cid and comm.rid="+rid+" and comm.cid="+cid;
	
	stmt = DBUtils.getSimpleStatement();
	
	try{
		rs = stmt.executeQuery(sql);
		
		Comment comm = null;
		
		if(rs != null){
			while(rs.next()){			
				Client client= new Client();
				client.setCid(rs.getInt(12));
				client.setCname(rs.getString(13));
				client.setCemail(rs.getString(14));
				client.setCpass(rs.getString(15));
				client.setCaddress(rs.getString(16));
				client.setCphone(rs.getLong(17));
				client.setCaadhar(rs.getLong(18));
				client.setDob(rs.getString(19));
				request.setClient(client);
				request.setRdesc(rs.getString(9));
				request.setRdate(rs.getString(10));
				request.setRstatus(rs.getString(11));
				
				Examiner examiner=new Examiner();
				comm = new Comment(rs.getInt(1),request,rs.getString(3),rs.getString(4),client,examiner);
				commentList.add(comm);
				}
				
			}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	DBUtils.closeResources();
	
	return commentList;
}
	
		//View all comments wrt to RID and EID
		public List<Comment> getAllCommentsWrtRidEid(int rid,int eid){
		List<Comment> commentList = new ArrayList<Comment>();
		
		Request request=new Request();
		request.setRid(rid);
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select comm.*, r.*, e.* from comments comm, requests r, examiner e where e.eid=comm.eid and comm.rid=r.rid and comm.rid="+rid+" and comm.eid="+eid;
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			Comment comm = null;
			
			if(rs != null){
				while(rs.next()){			
					Client client= new Client();
					request.setClient(client);
					request.setRdesc(rs.getString(9));
					request.setRdate(rs.getString(10));
					request.setRstatus(rs.getString(11));
					Examiner examiner=new Examiner();
					examiner.setEid(rs.getInt(12));
					examiner.setEname(rs.getString(13));
					examiner.setEpassword(rs.getString(14));
					examiner.setErole(rs.getString(15));
					examiner.setEmail(rs.getString(16));
					comm = new Comment(rs.getInt(1),request,rs.getString(3),rs.getString(4),client,examiner);
					commentList.add(comm);
					}
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return commentList;
	}
	//view all approved patent requests
		public List<Request> getAllApprovedRequests(){
			List<Request> requestList = new ArrayList<Request>();
			
			conn = DBUtils.getConnection("pfs");
			String status="Approved";
			String sql = "select r.rid,r.rdesc,r.rdate,r.rstatus,c.cid,c.cname,c.cemail,c.cpass,c.caddress,c.cphone,c.caadhar,c.cdob from requests r, client c where r.cid=c.cid and r.rstatus='"+status+"'";
			
			
			stmt = DBUtils.getSimpleStatement();
			
			try{
				rs = stmt.executeQuery(sql);
				
				Request request = null;
				
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
						requestList.add(request);
					}
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			DBUtils.closeResources();
			
			return requestList;
		}
	
	//get client by cid
	public Client getClient(int cid){
		Client client = null;
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select * from client where cid="+cid;
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
					client = new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getLong(7),rs.getString(8));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		//DBUtils.closeResources();
		
		return client;
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
		
				//View all examiner comments wrt to RID
				public List<Comment> getAllExaminerCommentsWrtRid(int rid){
				List<Comment> commentList = new ArrayList<Comment>();
				
				Request request=new Request();
				request.setRid(rid);
				
				conn = DBUtils.getConnection("pfs");
				
				String sql = "select comm.*, r.*, e.* from comments comm, requests r, examiner e where e.eid=comm.eid and comm.rid=r.rid and comm.rid="+rid+" and comm.eid is not null";
				
				stmt = DBUtils.getSimpleStatement();
				
				try{
					rs = stmt.executeQuery(sql);
					
					Comment comm = null;
					
					if(rs != null){
						while(rs.next()){			
							Client client= new Client();
							request.setClient(client);
							request.setRdesc(rs.getString(9));
							request.setRdate(rs.getString(10));
							request.setRstatus(rs.getString(11));
							Examiner examiner=new Examiner();
							examiner.setEid(rs.getInt(12));
							examiner.setEname(rs.getString(13));
							examiner.setEpassword(rs.getString(14));
							examiner.setErole(rs.getString(15));
							examiner.setEmail(rs.getString(16));
							comm = new Comment(rs.getInt(1),request,rs.getString(3),rs.getString(4),client,examiner);
							commentList.add(comm);
						}
							
						}
				}catch(SQLException e){
					e.printStackTrace();
				}
				
				DBUtils.closeResources();
				
				return commentList;
			}
}
