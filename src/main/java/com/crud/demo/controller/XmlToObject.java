package com.crud.demo.controller;

import com.fasterxml.jackson.dataformat.xml.*;

public class XmlToObject {
    public static void main(String[] args) throws Exception {
            String a = "<NMFIIService> "
                    + "<service_status> "
                        + "<service_return_code>0</service_return_code> "
                        + "<service_msg>Success</service_msg> "
                    + "</service_status>"
                    + "<service_response>"
                         + "<return_msg>"
                            + "   IIN Created. Customer ID : 5011000042"
                        + "   </return_msg>"
                    + "</service_response>"
                    + "</NMFIIService>";
        try {
            XmlMapper xmlMapper = new XmlMapper();
            NMFIIService pojo = xmlMapper.readValue(a, NMFIIService.class);
            System.out.println(pojo.getService_status().getService_msg());
            System.out.println(pojo.getService_response().getReturn_msg());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
