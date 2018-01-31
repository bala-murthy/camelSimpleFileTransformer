package com.learncamel.eips.aggregatorRoutes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SimpleAggregatorRouteTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder(){
        return new SimpleAggregatorRoute();
    }

   @Test
    public void testSimpleAggregatorRoute() throws InterruptedException {

       MockEndpoint mockOP = getMockEndpoint("mock:simpleAggregatorMockOP");
       mockOP.expectedBodiesReceived("123");


       template.sendBodyAndHeader("direct:simpleAggregatorIP","3","aggregatorId",1);
       template.sendBodyAndHeader("direct:simpleAggregatorIP","2","aggregatorId",1);
       template.sendBodyAndHeader("direct:simpleAggregatorIP","1","aggregatorId",1);

       assertMockEndpointsSatisfied();

   }
}
