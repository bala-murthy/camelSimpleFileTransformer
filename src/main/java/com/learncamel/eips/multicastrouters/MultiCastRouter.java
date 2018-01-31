package com.learncamel.eips.multicastrouters;

import org.apache.camel.builder.RouteBuilder;

public class MultiCastRouter extends RouteBuilder{

    public void configure() throws Exception{
        from("file:data/input?noop=true").multicast().
                to("file:F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\output\\multicastop\\op1","file:F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\output\\multicastop\\op2");

        // Try parallelprocessing() and stopOnException() methods

        //from("file:data/input?noop=true")
          //    .to("file:data/output/multicastop/op1").to("file:data/multicastop/op2");
    }
}
