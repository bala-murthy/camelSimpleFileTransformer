package com.learncamel.routes;

import com.learncamel.processor.CamelFileSampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyFileProcessorRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("file:F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\input?noop=true").
                log("File body that was read is ${body} and the headers are ${headers} and this file is going to be transformed now").
                process(new CamelFileSampleProcessor()).
                to("file:F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\output?fileName=outputPostTransform.txt").
                to("mock:output");
    }
}
