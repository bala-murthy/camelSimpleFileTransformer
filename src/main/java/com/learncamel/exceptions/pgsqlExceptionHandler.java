package com.learncamel.exceptions;

import org.apache.camel.Exchange;

public class pgsqlExceptionHandler implements org.apache.camel.Processor {

    public void process(Exchange exchange) throws Exception {

        Exception e = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);

        System.out.println("Acutal Exception Message " + e.getMessage());
        System.out.println("Acutal Exception Class " + e.getClass());

        String failedEndoint = (String) exchange.getProperty(Exchange.FAILURE_ENDPOINT);
        System.out.println("Failed Endpoint : " + failedEndoint);


        exchange.getIn().setBody("Exception happened in the route.");


    }
}
