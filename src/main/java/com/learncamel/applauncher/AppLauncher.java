package com.learncamel.applauncher;

import com.learncamel.jms2dbroute.jms2DBRoute;
import org.apache.camel.Main;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class AppLauncher {

    public static void main(String[] args) throws  Exception{

        Main main = new Main();

        String url = "jdbc:postgresql://localhost:5432/localDB";

        main.bind("myDataSource",setUpDataSource(url));
        main.addRouteBuilder(new jms2DBRoute());

        System.out.println("App Launched and ActiveMq ---> Camel ---> PostgreSQL Route Started");

        main.run();

    }

    private static DataSource setUpDataSource(String url) {

        BasicDataSource ds = new BasicDataSource();

        ds.setUsername("postgres");
        ds.setPassword("admin");

        ds.setDriverClassName("org.postgresql.Driver");

        ds.setUrl(url);

        return ds;


    }
}
