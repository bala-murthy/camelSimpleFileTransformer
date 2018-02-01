package com.learncamel.jms2dbroute;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class JmsRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new JmsRoute();
    }

    @Test
    public void testJmsRoute() {
        String expectedMessage="123";
        String receivedMessage = consumer.receiveBody("direct:activemqDestination",String.class);
        System.out.println("Received Message from ActiveMQ is ::"+receivedMessage);

        assertEquals(expectedMessage,receivedMessage);


    }
}
