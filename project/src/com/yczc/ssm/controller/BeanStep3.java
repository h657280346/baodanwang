package com.yczc.ssm.controller;

public class BeanStep3 {
	private String timeStamp = "";
	private String nonceStr  = "";
	private String paySign   = "";
	
	public BeanStep3(String timeStamp, String nonceStr, String paySign) {
		super();
		this.timeStamp = timeStamp;
		this.nonceStr = nonceStr;
		this.paySign = paySign;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonceStr() {
		return nonceStr;
	}
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}
	public String getPaySign() {
		return paySign;
	}
	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}
	
}
