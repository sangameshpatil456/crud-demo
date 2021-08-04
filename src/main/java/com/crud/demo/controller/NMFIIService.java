package com.crud.demo.controller;

public class NMFIIService {
    private ServiceStatus service_status;
    private ServiceResponse service_response;

    public ServiceStatus getService_status ()
    {
        return service_status;
    }

    public void setService_status (ServiceStatus service_status)
    {
        this.service_status = service_status;
    }

    public ServiceResponse getService_response ()
    {
        return service_response;
    }

    public void setService_response (ServiceResponse service_response)
    {
        this.service_response = service_response;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [service_status = "+service_status+", service_response = "+service_response+"]";
    }
}
