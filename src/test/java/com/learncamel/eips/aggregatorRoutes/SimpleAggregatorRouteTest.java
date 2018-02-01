package com.learncamel.eips.aggregatorRoutes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleAggregatorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new SimpleAggregatorRoute();
    }

    //List<String> receivedBodies = Arrays.asList("123","321");





    @Test
    public void testSimpleAggregatorRoute() throws InterruptedException {

       MockEndpoint mockOP = getMockEndpoint("mock:simpleAggregatorMockOP");


        //mockOP.expectedBodiesReceivedInAnyOrder("123","321");
        //mockOP.expectedMessagesMatches(body().contains("123"),body().contains("321"));

        mockOP.expectedBodiesReceived("321");

       template.sendBodyAndHeader("direct:simpleAggregatorIP","1","aggregatorId",1);
       template.sendBodyAndHeader("direct:simpleAggregatorIP","2","aggregatorId",1);
       template.sendBodyAndHeader("direct:simpleAggregatorIP","3","aggregatorId",1);

       assertMockEndpointsSatisfied();

   }
}
