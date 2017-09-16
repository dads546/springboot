package com.sxl.springboot.Enum;

public enum ErrorCode {
	SUCCESS(1,"请求成功"),
	FAILED(-1,"服务器内部错误"),
	ERRORUSERINFO(2,"用户信息错误"),
	NOSUCHSCHOOL(3,"没有这个学校");
	private Integer code;
	
	private String msg;
	
	ErrorCode(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
}
