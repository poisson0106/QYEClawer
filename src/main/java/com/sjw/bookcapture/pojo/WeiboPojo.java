package com.sjw.bookcapture.pojo;

public class WeiboPojo {
	private String name;
	private String info;
	private String picHref;
	private String postDate;
	private int commentsNum;
	private int goodNum;
	private int forwardNum;
	private String postBy;
	private int refWeibo;
	private String uid;
	private WeiboPojo refWeiboDetail;
	
	public WeiboPojo getRefWeiboDetail() {
		return refWeiboDetail;
	}
	public void setRefWeiboDetail(WeiboPojo refWeiboDetail) {
		this.refWeiboDetail = refWeiboDetail;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getRefWeibo() {
		return refWeibo;
	}
	public void setRefWeibo(int refWeibo) {
		this.refWeibo = refWeibo;
	}
	public int getForwardNum() {
		return forwardNum;
	}
	public void setForwardNum(int forwardNum) {
		this.forwardNum = forwardNum;
	}
	public String getPostBy() {
		return postBy;
	}
	public void setPostBy(String postBy) {
		this.postBy = postBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getPicHref() {
		return picHref;
	}
	public void setPicHref(String picHref) {
		this.picHref = picHref;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public int getCommentsNum() {
		return commentsNum;
	}
	public void setCommentsNum(int commentsNum) {
		this.commentsNum = commentsNum;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	
	
}
