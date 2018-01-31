package com.learncamel.eips.recipientlist;


import com.learncamel.eips.recipientList.recipientListRouter;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class recipientListRouterTest extends CamelTestSupport {

    @Override
    public RouteBuilder createRouteBuilder() {
        return new recipientListRouter();
    }

    @Test
    public void testRCPListRouter() throws InterruptedException {

        Thread.sleep(5000);
        File rcpListOPDir = new File("xmlsenior");
        assertTrue(rcpListOPDir.isDirectory());

    }

}
