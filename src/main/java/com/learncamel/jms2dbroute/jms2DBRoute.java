package com.learncamel.jms2dbroute;

import com.learncamel.processor.InsertSQLProcessor;
import org.apache.camel.builder.RouteBuilder;

import static java.util.logging.Level.INFO;

public class jms2DBRoute extends RouteBuilder {

    public void configure() throws Exception {
        from("direct:dbInput").
                to("log:?level=INFO&showBody=true").
                process(new InsertSQLProcessor()).
                to("jdbc:myDataSource").
                to("sql:select * from messages?dataSource=myDataSource").
                to("log:?level=INFO&showBody=true");

    }
}
