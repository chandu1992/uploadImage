package com.bsl.utility;

public class ResponseHandler {

	private String filename;
	private String msg;
	private String status;
	
	public ResponseHandler(String filename, String msg, String status) {
		super();
		this.filename = filename;
		this.msg = msg;
		this.status = status;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
