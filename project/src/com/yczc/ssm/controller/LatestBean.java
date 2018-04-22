package com.yczc.ssm.controller;

public class LatestBean {
	private static String latestTitle = "";
	private static String latestTitleTwo = "";
	private static String latestImg = "";
	public static String getLatestTitle() {
		return latestTitle;
	}
	public static void setLatestTitle(String latestTitle) {
		LatestBean.latestTitle = latestTitle;
	}
	public static String getLatestTitleTwo() {
		return latestTitleTwo;
	}
	public static void setLatestTitleTwo(String latestTitleTwo) {
		LatestBean.latestTitleTwo = latestTitleTwo;
	}
	public static String getLatestImg() {
		return latestImg;
	}
	public static void setLatestImg(String latestImg) {
		LatestBean.latestImg = latestImg;
	}
	
}
