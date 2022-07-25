package com.tudip.spring_boot_starter.enums;

public enum ResponseEnum {

    SUCCESS("", 200),
    NOT_FOUND("No Record Found", 404),
    BAD_REQUEST_PARAMETER("Request Parameter cannot be null", 400),
    INTERNAL_SERVER_ERROR("Internal error", 500);

    private String message;
    private Integer statusCode;


    ResponseEnum(String message, Integer statusCode){

        this.message = message;

        this.statusCode = statusCode;

    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
