package com.moodle.project.http.endpoint;

import com.moodle.project.http.Client;
import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.form.FormEncoder;

import java.io.IOException;

public class Class implements Client {

  private final String endpoint = "login";
  private IClass client;

  public Class(){
    try {
      ConfigurationManager.loadPropertiesFromResources("client.properties");
    } catch (IOException e) {
      e.printStackTrace();
    }
    client = Feign.builder()
        .encoder(new FormEncoder())
        .target(IClass.class, api);
  }

  public String post(String name, String limit) {
    return client.create(name, limit, "{\"avoiding\": \"Error 411\"}");
  }

}
