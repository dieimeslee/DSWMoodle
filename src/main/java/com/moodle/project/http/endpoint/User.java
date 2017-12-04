package com.moodle.project.http.endpoint;

import com.moodle.project.http.Client;
import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.form.FormEncoder;

import java.io.IOException;

public class User implements Client {

  private final String endpoint = "user";
  private IUser client;

  public User(){
    try {
      ConfigurationManager.loadPropertiesFromResources("client.properties");
    } catch (IOException e) {
      e.printStackTrace();
    }
    client = Feign.builder()
        .encoder(new FormEncoder())
        .target(IUser.class, api);
  }

  public String post(String user, String password, String email, String firstName, String lastName, String userType) {
    return client.create(user, password, email, firstName, lastName, userType, "{\"avoiding\": \"Error 411\"}");
  }

  public Boolean put(String user, String password, String email) {
    try{
      return !client.recover(user, password, email).contains("ERROR");
    } catch (Exception e) {
      return false;
    }
  }

  public String put(String user) {
    return client.update(user);
  }

  public String get(String user) { return client.find(user);}
}
