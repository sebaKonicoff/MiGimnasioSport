package com.migimnasio.sport.exception;

public class ErrorResponse {
    private int statusCode;
    private String errorType;
    private String errorMessage;

    public ErrorResponse(int statusCode, String errorType, String errorMessage) {
        this.statusCode = statusCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
