package com.learncamel.eips.contentbasedrouters;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class contentBasedRouterRouteTest  extends CamelTestSupport{
    @Override
    public RouteBuilder createRouteBuilder() {

        return new contentBasedRouterRoute();

    }

    @Test
    public void contentBasedRouterTest() throws InterruptedException{
        Thread.sleep(5000);

        File xmlFolder=new File("data/output/xml");
        File htmlFolder=new File("data/output/html");
        File txtFolder=new File("data/output/txt");

        assertTrue(xmlFolder.isDirectory());
        assertTrue(htmlFolder.isDirectory());
        assertTrue(txtFolder.isDirectory());

    }
}
