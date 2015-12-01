package com.sjw.bookcapture.utils;

public enum WeiboType {
	ORIGINAL(0),
	FWCOMMENT(1),
	FWCONTENT(2);
	
	WeiboType(int num){
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	private int num;
	
}
