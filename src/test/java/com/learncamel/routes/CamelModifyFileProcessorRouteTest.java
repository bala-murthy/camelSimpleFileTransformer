package com.learncamel.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

import static java.lang.System.lineSeparator;
import static java.lang.Thread.*;

public class CamelModifyFileProcessorRouteTest extends CamelTestSupport {
    @Override
    public RouteBuilder createRouteBuilder() {
        return new CamelModifyFileProcessorRoute();
    }

    @Test
    public void processorTest() throws InterruptedException {

        String expectedValue = "bala:123:TCS" + lineSeparator() +
                "Sham:345:CTS"+ lineSeparator();
        MockEndpoint mockEndPoint = getMockEndpoint("mock:output");
        mockEndPoint.expectedBodiesReceived(expectedValue);



        Thread.sleep(5000);
        File file = new File("data/output");
        assertTrue(file.isDirectory());
        assertMockEndpointsSatisfied();

    }
}
