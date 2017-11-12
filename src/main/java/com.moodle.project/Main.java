package com.moodle.project;

import org.apache.catalina.startup.Tomcat;
import java.util.*;

public class Main {
    public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    public static final Optional<String> env = Optional.ofNullable(System.getenv("ENV"));
    public static void main(String[] args) throws Exception {
        String _port = port.orElse("8080"), contextPath = "/", appBase = ".";
        Tomcat tomcat = new Tomcat();
        if (!env.equals("production"))
            tomcat.setPort(Integer.valueOf(_port));
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
}