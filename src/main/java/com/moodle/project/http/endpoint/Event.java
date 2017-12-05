package com.moodle.project.http.endpoint;

import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.form.FormEncoder;

import java.io.IOException;

import static com.moodle.project.http.Client.api;

public class Event {
    private final String endpoint = "login";
    private IEvent event;

    public Event(){
        try {
            ConfigurationManager.loadPropertiesFromResources("client.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        event = Feign.builder()
                .encoder(new FormEncoder())
                .target(IEvent.class, "http://192.168.64.208:8080");
    }

    public String post(String name) {
        return event.newEvent(name);
    }

}
