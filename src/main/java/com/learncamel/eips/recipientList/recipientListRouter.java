package com.learncamel.eips.recipientList;

import org.apache.camel.builder.RouteBuilder;

public class recipientListRouter extends RouteBuilder {

    public void configure() throws Exception{

        //from("file:data/input?noop=true").recipientList("data/output/rcpListOP");



        from("file://data/input?FileName=ip-xmlFile.xml&noop=true").
                 setHeader("type",xpath("/employee/@type"))
                .process(new recipientListProcessor())
                .recipientList(header("type"));




    }
}
