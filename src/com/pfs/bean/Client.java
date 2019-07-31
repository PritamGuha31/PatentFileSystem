package com.pfs.bean;

public class Client {
	private int cid;
	private String cname;
	private String cemail;
	private String cpass;
	private String caddress;
	private long cphone;
	private long caadhar;
	private String dob;
	
	public Client() {}

	public Client(int cid,String cname, String cemail, String cpass, String caddress, long cphone, long caadhar, String dob) {
		super();
		this.cid=cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cpass = cpass;
		this.caddress = caddress;
		this.cphone = cphone;
		this.caadhar=caadhar;
		this.dob = dob;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public long getCphone() {
		return cphone;
	}

	public void setCphone(long cphone) {
		this.cphone = cphone;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getCaadhar() {
		return caadhar;
	}

	public void setCaadhar(long caadhar) {
		this.caadhar = caadhar;
	}

	@Override
	public String toString() {
		return "Client [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpass=" + cpass + ", caddress="
				+ caddress + ", cphone=" + cphone + ", caadhar=" + caadhar + ", dob=" + dob + "]";
	}

	
	}
	