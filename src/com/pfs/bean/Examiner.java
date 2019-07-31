package com.pfs.bean;

public class Examiner {
	
	private int eid;
	private String ename;
	private String epassword;
	private String erole;
	private String email;
	
	public Examiner() {}

	public Examiner(int eid,String ename, String epassword, String erole, String email) {
		super();
		this.eid=eid;
		this.ename = ename;
		this.epassword = epassword;
		this.erole = erole;
		this.email = email;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEpassword() {
		return epassword;
	}

	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}

	public String getErole() {
		return erole;
	}

	public void setErole(String erole) {
		this.erole = erole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Examiner [eid=" + eid + ", ename=" + ename + ", epassword=" + epassword + ", erole=" + erole
				+ ", email=" + email + "]";
	}
	
	
	

}
