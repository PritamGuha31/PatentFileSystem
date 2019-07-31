package com.pfs.bean;

public class Request {
	private int rid;
	private Client client;
	private String rdesc;
	private String rdate;
	private String rstatus;
	
	public Request() {}

	public Request(int rid, Client client, String rdesc, String rdate, String rstatus) {
		super();
		this.rid = rid;
		this.client=client;
		//this.cid=cid;
		this.rdesc = rdesc;
		this.rdate = rdate;
		this.rstatus = rstatus;
	}

	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getRdesc() {
		return rdesc;
	}


	public void setRdesc(String rdesc) {
		this.rdesc = rdesc;
	}


	public String getRdate() {
		return rdate;
	}


	public void setRdate(String rdate) {
		this.rdate = rdate;
	}


	public String getRstatus() {
		return rstatus;
	}


	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	@Override
	public String toString() {
		return "Request [rid=" + rid + ", client=" + client.getCid() + ", client name=" + client.getCname() +", rdesc="
				+ rdesc + ", rdate=" + rdate + ", rstatus=" + rstatus + "]";
	}	
}