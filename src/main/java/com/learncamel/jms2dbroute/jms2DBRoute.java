package com.learncamel.jms2dbroute;

import com.learncamel.exceptions.pgsqlExceptionHandler;
import com.learncamel.processor.InsertSQLProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.postgresql.util.PSQLException;

import static java.util.logging.Level.INFO;

public class jms2DBRoute extends RouteBuilder {

    public void configure() throws Exception {

        // Below code snippet ensures that the exceptions are handled and logged gracefully

        onException(PSQLException.class).handled(true).log("Exception while connecting to PostgresSQL Server").process(new pgsqlExceptionHandler());

        // This code snippet sends messages from direct component.
        // In the following code block we see how the message from ActiveMQ is sent to DB.

        /*from("direct:dbInput").
                to("log:?level=INFO&showBody=true").
                process(new InsertSQLProcessor()).
                to("jdbc:myDataSource").
                to("sql:select * from messages?dataSource=myDataSource").
                to("log:?level=INFO&showBody=true");*/

        from("activemq:queue:testQueue").
                to("log:?level=INFO&showBody=true").
                process(new InsertSQLProcessor()).
                to("jdbc:myDataSource").
                to("sql:select * from public.messages?dataSource=myDataSource").
                to("log:?level=INFO&showBody=true");
                //to("direct:directDBOutput")
                // the above line has been commented since we are running this using a main launcher app
                // the above line is needed if we need to unit test with the result being output to direct component.

    }
}
