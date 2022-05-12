package com.banking.exception;

import java.util.List;

public class ErrorMessage {
	 Long errorCode;
	 List<String>errorMessage;
	public Long getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}
	public List<String> getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(List<String> errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ErrorMessage(Long errorCode, List<String> errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	 public ErrorMessage() {
	}
}
