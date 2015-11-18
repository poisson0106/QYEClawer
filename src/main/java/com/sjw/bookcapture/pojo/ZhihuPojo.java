package com.sjw.bookcapture.pojo;

public class ZhihuPojo {
	private String name;
	private String qtitle;
	private String qhref;
	private String qtype;
	private String acontent;
	private String qtime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQtitle() {
		return qtitle;
	}
	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}
	public String getQhref() {
		return qhref;
	}
	public void setQhref(String qhref) {
		this.qhref = qhref;
	}
	public String getQtype() {
		return qtype;
	}
	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getQtime() {
		return qtime;
	}
	public void setQtime(String qtime) {
		this.qtime = qtime;
	}
	@Override
	public String toString() {
		return name+qtype+qtitle+"("+qhref+") : "+acontent+" at "+qtime;
	}
	
}
