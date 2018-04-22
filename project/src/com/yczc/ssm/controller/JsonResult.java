package com.yczc.ssm.controller;

public class JsonResult {
	public boolean success;
	  public String msg;
	  public Object data;

	  public JsonResult()
	  {
	  }

	  public JsonResult(boolean success, Object data)
	  {
	    this.success = success;
	    this.data = data;
	  }
	  public JsonResult(boolean success, Object data, String msg) {
	    this.success = success;
	    this.data = data;
	    this.msg = msg;
	  }
	  public boolean getSuccess() {
	    return this.success;
	  }
	  public void setSuccess(boolean success) {
	    this.success = success;
	  }
	  public String getMsg() {
	    return this.msg;
	  }
	  public void setMsg(String msg) {
	    this.msg = msg;
	  }
	  public Object getData() {
	    return this.data;
	  }
	  public void setData(Object data) {
	    this.data = data;
	  }

	  public static void main(String[] args)
	  {
	  }
}
