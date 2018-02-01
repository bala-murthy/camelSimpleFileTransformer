package com.learncamel.jms2dbroute;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.util.ArrayList;

public class jms2DBRouteTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new jms2DBRoute();
    }


    @Override
    protected CamelContext createCamelContext() throws Exception {

        String url = "jdbc:postgresql://localhost:5432/localDB";
        DataSource ds= setupDataSource(url);
        SimpleRegistry registry = new SimpleRegistry();
        registry.put("myDataSource",ds);

        CamelContext context4DataSource = new DefaultCamelContext(registry);

        return context4DataSource;
    }

    private DataSource setupDataSource(String url) {

        BasicDataSource ds = new BasicDataSource();
        ds.setUsername("postgres");
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setPassword("admin");
        ds.setUrl(url);
        return ds;
    }

    @Test
    public void testMQ2DBInsert() {
        String input = "First db input";
        ArrayList responseList =  template.requestBody("direct:dbInput", input, ArrayList.class);
        System.out.println("responseList : " + responseList.size());
        assertNotEquals(0,responseList.size());
    }
}
