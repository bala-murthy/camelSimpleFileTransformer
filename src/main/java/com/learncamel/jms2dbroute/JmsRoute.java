package com.learncamel.jms2dbroute;


import org.apache.camel.builder.RouteBuilder;

public class JmsRoute extends RouteBuilder {

    //This class just consumes message from ActiveMQ and sends to direct component
    //called "activemqDestination. No further processing is done."

    public void configure() throws Exception {
        from("activemq:queue:testQueue").
                to("log:?level=INFO&showBody=true").
                to("direct:activemqDestination");

    }
}
