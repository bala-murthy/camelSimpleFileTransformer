package com.learncamel.eips.multicastrouters;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class MultiCastRouterTest extends CamelTestSupport {

  @Override
    public RouteBuilder createRouteBuilder() {
      return new MultiCastRouter();
  }
    @Test
    public void testMultiCastRouter() throws InterruptedException{
        File opDir1 = new File("F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\output\\multicastop\\op1");
        File opDir2 = new File("F:\\ApacheCamel\\CamelWS\\learncamel-transform\\data\\output\\multicastop\\op2");

        Thread.sleep(5000);

        assertTrue(opDir1.isDirectory());
        assertTrue(opDir2.isDirectory());
    }
}
