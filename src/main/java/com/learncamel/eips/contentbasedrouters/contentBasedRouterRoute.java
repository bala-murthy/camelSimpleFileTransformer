package com.learncamel.eips.contentbasedrouters;


import org.apache.camel.builder.RouteBuilder;

public class contentBasedRouterRoute extends RouteBuilder{
   public void configure() throws Exception{
       from("file:data/contentbased-input?noop=true").
               log("log:?level=INFO&showBody=true&showHeaders=true").
               choice().
               when(header("CamelFileNameConsumed").endsWith(".xml")).
               to("file:data/output/xml").
               when(header("CamelFileNameConsumed").endsWith(".html")).
               to("file:data/output/html").
               when(header("CamelFileNameConsumed").endsWith(".txt")).
               to("file:data/output/txt").
               otherwise().to("file:data/output/unknownfiles").end().to("file:data/output/all");
   }

}
