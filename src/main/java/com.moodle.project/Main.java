package com.moodle.project;

import org.apache.catalina.startup.Tomcat;
import java.util.*;

public class Main {
    private static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    private static final Optional<String> env = Optional.ofNullable(System.getenv("ENV"));
    public static void main(String[] args) throws Exception {
        String _port = port.orElse("8080"), contextPath = "/", appBase = ".";
        Tomcat tomcat = new Tomcat();
        if (!env.toString().contains("production"))
            tomcat.setPort(Integer.valueOf(_port));
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);
        tomcat.start();
        if (env.toString().contains("test") || env.toString().contains("production")) {
            tomcat.getServer();
            tomcat.stop();
            System.out.println("Ok");
        } else {
            tomcat.getServer().await();
        }
    }
}