package com.learncamel.eips.aggregatorStrategies;

import org.apache.camel.Exchange;

public class simpleAggregatorStrategy implements org.apache.camel.processor.aggregate.AggregationStrategy {


    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(oldExchange == null){
            return newExchange;
        }

        String oldBody = (String) oldExchange.getIn().getBody();
        String newBody = (String) newExchange.getIn().getBody();

        newBody = newBody.concat(oldBody);

        newExchange.getIn().setBody(newBody);

        return newExchange;

    }
}
