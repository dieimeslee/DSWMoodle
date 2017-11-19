package com.moodle.project.http.endpoints;

import com.moodle.project.http.Client;
import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.form.FormEncoder;

import java.io.IOException;

public class Login implements Client {

    private final String endpoint = "login";
    private ILogin client;

    public Login (){
        try {
            ConfigurationManager.loadPropertiesFromResources("client.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        client = Feign.builder()
                .encoder(new FormEncoder())
                .target(ILogin.class, api);
    }

    public String post(String user, String password) {
        return client.login(user, password);
    }

    public String put(String authToken) {
        return client.logout(authToken);
    }
}
