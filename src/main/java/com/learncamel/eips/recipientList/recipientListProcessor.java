package com.learncamel.eips.recipientList;

import org.apache.camel.Exchange;

public class recipientListProcessor implements org.apache.camel.Processor {

    public void process(Exchange incomingExchange) throws Exception{

        String employeeType =
                incomingExchange.getIn().getHeader("type", String.class);
        if (employeeType.equals("senior")) {
            incomingExchange.getIn().setHeader("type", "file:xmlsenior");
        } else {
            incomingExchange.getIn().setHeader("type", "file:xmljunior");
        }

    }
}
