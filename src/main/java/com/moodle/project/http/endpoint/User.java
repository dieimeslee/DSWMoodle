package com.moodle.project.http.endpoint;

import com.moodle.project.http.Client;
import com.moodle.project.interceptor.UserInfo;
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

  public Boolean createTask(String name, String downloadLink, String description, String _class, String date, String time) {
    try {
      return !client.task(name, downloadLink, description, _class, date + " " + time, "{\"avoiding\": \"Error 411\"}").contains("ERROR");
    } catch (Exception e){
      return false;
    }
  }


  public String getTask() {
    try {
      return client.getTasks();
    } catch (Exception e){
      return "";
    }
  }
  public Boolean setReminder(String status) {
    try {
      return !client.setReminder(UserInfo.getUser().getLogin() , status, "{\"avoiding\": \"Error 411\"}").contains("ERROR");
    } catch (Exception e){
      return false;
    }
  }

  public String put(String user) {
    return client.update(user);
  }

  public String get(String user) { return client.find(user);}
}
