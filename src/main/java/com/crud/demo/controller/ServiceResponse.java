package com.crud.demo.controller;

public class ServiceResponse {

    private String return_msg;

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    @Override
    public String toString() {
        return "ServiceResponse{" +
                "return_msg='" + return_msg + '\'' +
                '}';
    }
}
