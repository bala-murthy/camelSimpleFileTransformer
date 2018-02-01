package com.learncamel.processor;

import org.apache.camel.Exchange;

public class InsertSQLProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String incomingMessage = (String) exchange.getIn().getBody();

        String insertSQL = "insert into messages values ('1','"+incomingMessage+"')";

        exchange.getIn().setBody(insertSQL);

        System.out.println("Incoming Message is ::"+incomingMessage);
        System.out.println("insertSQL formed is  ::"+insertSQL);



    }
}
