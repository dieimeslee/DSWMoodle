package com.moodle.project.interceptor;

import com.moodle.project.model.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class UserInfo implements Serializable {

  private static final long serialVersionUID = 773496171272411714L;
  private static User user;

  public static User getUser() {
    return user;
  }

  public static void login(User newUser) {
    user = newUser;
  }

  public static void logout() {
    user = null;
  }
}
