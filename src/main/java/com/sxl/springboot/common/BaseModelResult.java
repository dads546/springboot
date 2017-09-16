package com.sxl.springboot.common;

import com.sxl.springboot.Enum.ErrorCode;

public class BaseModelResult<T> {
	private ErrorCode errorCode;
	
	private T data;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
