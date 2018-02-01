package com.learncamel.jms2dbroute;


import org.apache.camel.builder.RouteBuilder;

public class JmsRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("activemq:queue:testQueue").
                to("log:?level=INFO&showBody=true").
                to("direct:activemqDestination");

    }
}
