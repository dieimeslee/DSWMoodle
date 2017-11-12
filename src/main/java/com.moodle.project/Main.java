package com.moodle.project;

import java.util.Optional;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));
    public static void main(String[] args) throws Exception {
        String port = "8080", contextPath = "/", appBase = ".";
        Map<String, String> env = System.getenv();
        for (String envName : env.keySet())
            if (envName.equals("ENV"))
                if (env.get(envName).equals("production"))
                    port = "80";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(port.orElse("8080") ));
        tomcat.getHost().setAppBase(appBase);
        tomcat.addWebapp(contextPath, appBase);
        tomcat.start();
        tomcat.getServer().await();
    }
}