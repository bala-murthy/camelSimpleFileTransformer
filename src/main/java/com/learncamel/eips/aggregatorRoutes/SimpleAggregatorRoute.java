package com.learncamel.eips.aggregatorRoutes;

import com.learncamel.eips.aggregatorStrategies.simpleAggregatorStrategy;
import org.apache.camel.builder.RouteBuilder;

public class SimpleAggregatorRoute extends RouteBuilder {

    public void configure() throws Exception{
        from("direct:simpleAggregatorIP").
                log("Received message is ${body} and header is ${header.aggregatorId}").
                aggregate(header("aggregatorId"),new simpleAggregatorStrategy()).completionSize(3).
                log("Aggregated message is ${body}").
                to("mock:simpleAggregatorMockOP");
    }
}
