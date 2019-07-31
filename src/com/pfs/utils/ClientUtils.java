package com.pfs.utils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import com.pfs.bean.*;

public class ClientUtils {
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public boolean addClient(Client client){
		int cid=0;
		boolean inserted=false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "insert into client (cname,cemail,cpass,caddress,cphone,caadhar,cdob) values (?,?,?,?,?,?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(1, client.getCname());
			pst.setString(2, client.getCemail());
			pst.setString(3, client.getCpass());
			pst.setString(4, client.getCaddress());
			pst.setLong(5, client.getCphone());
			pst.setLong(6, client.getCaadhar());
			pst.setString(7, client.getDob());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r>0){
				inserted=true;
				//cid=rs.getInt(1);
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public boolean sendRequest(Request request){
		boolean sent=false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "insert into requests (cid,rdesc,rdate,rstatus) values (?,?,now(),?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setInt(1, request.getClient().getCid());
			pst.setString(2, request.getRdesc());
			//pst.setString(3, request.getRdate());
			pst.setString(3, request.getRstatus());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			if(r > 0){
				sent=true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return sent;
	}
	
	public String checkStatus(int rid){
		String status=null;
		
		conn = DBUtils.getConnection("pfs");
		
		String sql = "select * from requests where rid="+rid;
		
		stmt = DBUtils.getSimpleStatement();
		
		try{
			rs = stmt.executeQuery(sql);
			
			if(rs != null){
				while(rs.next()){
					status = rs.getString(5);
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		DBUtils.closeResources();
		
		return status;
	}
	
	public boolean addCommentClient(Comment comment){
		boolean inserted=false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "insert into comments (rid,comm_date,comm_text,cid) values (?,now(),?,?)";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setInt(1, comment.getRequest().getRid());
			//pst.setString(2, comment.getComm_date());
			pst.setString(2, comment.getComm_text());
			pst.setInt(3, comment.getClient().getCid());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r > 0){
				inserted=true;
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return inserted;
	}
	
	public Client validateClient(String email, String pass){
		Client client=null;
		conn=DBUtils.getConnection("pfs");
		String sql="select * from client where cemail='"+email+"' and cpass='"+pass+"'";
		stmt = DBUtils.getSimpleStatement();
		try{
			rs=stmt.executeQuery(sql);
			if(rs!=null){
				while(rs.next()){
					client=new Client(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getLong(6),rs.getLong(7),rs.getString(8));
					
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		DBUtils.closeResources();
		return client;
	}
	
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
		
		DBUtils.closeResources();
		
		return client;
	}
	
	public boolean updateClientDetails(Client client){
		boolean updated=false;
		try{
			conn = DBUtils.getConnection("pfs");
			
			String sql = "update client set cname=? , cemail=? , cpass=? , caddress=? , cphone=? , caadhar=? , cdob=? where cid=?";
			
			pst = DBUtils.getPreparedStatement(sql);
			
			pst.setString(1, client.getCname());
			pst.setString(2, client.getCemail());
			pst.setString(3, client.getCpass());
			pst.setString(4, client.getCaddress());
			pst.setLong(5, client.getCphone());
			pst.setLong(6, client.getCaadhar());
			pst.setString(7, client.getDob());
			pst.setInt(8, client.getCid());
			
			int r = pst.executeUpdate();
			//ResultSet rs = pst.getGeneratedKeys();
			
			if(r>0){
				updated=true;
				//cid=rs.getInt(1);
			}
			
			DBUtils.closeResources();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return updated;
	}
	}