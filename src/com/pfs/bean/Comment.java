package com.pfs.bean;

public class Comment {
	private int comm_id;
	private Request request;
	private String comm_date;
	private String comm_text;
	private Client client;
	private Examiner examiner;
	
	
	public Comment() {}

	public Comment(int comm_id, Request request, String comm_date,
			String comm_text, Client client, Examiner examiner) {
		super();
		this.comm_id = comm_id;
		this.request = request;
		this.comm_date = comm_date;
		this.comm_text = comm_text;
		this.client = client;
		this.examiner = examiner;
	}

	public int getComm_id() {
		return comm_id;
	}

	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Examiner getExaminer() {
		return examiner;
	}

	public void setExaminer(Examiner examiner) {
		this.examiner = examiner;
	}

	public String getComm_date() {
		return comm_date;
	}

	public void setComm_date(String comm_date) {
		this.comm_date = comm_date;
	}

	public String getComm_text() {
		return comm_text;
	}

	public void setComm_text(String comm_text) {
		this.comm_text = comm_text;
	}

	/*@Override
	public String toString() {
		return "Comment [comm_id=" + comm_id + ", request=" + request
				+ ", comm_date=" + comm_date + ", comm_text=" + comm_text
				+ "]";
	}*/

	
	/*public String toString() {
		if(client.getCid() != null && examiner.getEid() == null){
			return "Comment [comm_id=" + comm_id + ", request id=" + request.getRid()
					+ ", comm_date=" + comm_date + ", comm_text=" + comm_text
					+ ", client id=" + client.getCid() + "]";
		}
		else{
			return "Comment [comm_id=" + comm_id + ", request id=" + request.getRid()
					+ ", comm_date=" + comm_date + ", comm_text=" + comm_text
					+ ", examiner id=" + examiner.getEid() + "]";
		}
		
	}*/
	
	

	
	

}
