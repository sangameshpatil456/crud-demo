package com.crud.demo.controller;

public class ServiceStatus {
    private String service_return_code;
    private String service_msg;

    public String getService_return_code() {
        return service_return_code;
    }

    public void setService_return_code(String service_return_code) {
        this.service_return_code = service_return_code;
    }

    public String getService_msg() {
        return service_msg;
    }

    public void setService_msg(String service_msg) {
        this.service_msg = service_msg;
    }

    @Override
    public String toString() {
        return "ServiceStatus{" +
                "service_return_code='" + service_return_code + '\'' +
                ", service_msg='" + service_msg + '\'' +
                '}';
    }
}
