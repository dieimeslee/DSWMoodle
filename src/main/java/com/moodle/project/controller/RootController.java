package com.moodle.project.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import javax.inject.Inject;

import com.moodle.project.dao.DefaultUserDao;
import com.moodle.project.dao.UserDao;
import com.moodle.project.interceptor.Public;
import com.moodle.project.interceptor.UserInfo;
import com.moodle.project.model.User;
import org.apache.log4j.Logger;

import java.lang.annotation.Annotation;

@Controller
public class RootController{

  final static Logger logger = Logger.getLogger(RootController.class);



  private final Result result;
  //  private final Validator validator;
  private final UserInfo userInfo;
  private final DefaultUserDao dao;
  /**
   * @deprecated CDI eyes only
   */
  protected RootController() {
    this(null, null, null);
  }

  @Inject
  public RootController(DefaultUserDao dao, UserInfo userInfo, Result result) {
    this.dao = dao;
    this.result = result;
    this.userInfo = userInfo;
  }

  public void setMessage(String message) {
    result.include("message", message);
  }

  @Get("/logout")
  @Public
  public void logout() {
    UserInfo.logout();
    result.redirectTo(RootController.class).index();
  }

  @Post
  @Public
  public void login(String login, String password) {
    resultDefaults();
    try {
      final User currentUser = dao.find(login, password);
      UserInfo.login(currentUser);
      result.redirectTo(UsersController.class).index();
    } catch (Exception e) {
      result.include("message", "usuário ou senha incorretos");
      result.redirectTo(RootController.class).index();
    }

  }

  @Get("/recover")
  @Public
  public void recover() {
    resultDefaults();
  }

  @Post("/recover")
  @Public
  public void recover(String user, String newPassword, String email) {
    resultDefaults();
    if(dao.recover(user, newPassword, email)) {
      setMessage("User's password changed with success :-)");
      result.redirectTo(RootController.class).index();
    } else {
      setMessage("Invalid info try again!");
      result.redirectTo(RootController.class).recover();

    }
  }

  @Get("/")
  @Public
  public void index() {
    resultDefaults();
  }

  private void resultDefaults() {
    result.include("pageTitle", "Login");
    result.include("siteName", "Moodle");
  }

  @Get("/register")
  @Public
  public void register() {
    resultDefaults();
  }

  @Post("/register")
  @Public
  public void register(String firstName, String lastName, String userType, String email, String user, String password) {
      try {
        if (dao.add(new User(user, password, firstName, lastName, email, userType)))
          result.include("message", "Usuário " + user + " criado com sucesso!");
        else
          result.include("message", "Usuário " + user + " não pode ser criado!");
      } catch (Exception e) {
        result.include("message", "Usuário " + user + " não pode ser criado!");
      }
  }

}
