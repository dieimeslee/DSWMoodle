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
    // search for the user in the database
    final User currentUser = dao.find(login, password);

    // if no user is found, adds an error message to the validator
    // "invalid_login_or_password" is the message key from messages.properties,
    // and that key is used with the fmt taglib in index.jsp, for example: <fmt:message key="error.key">
//    validator.check(currentUser != null, new SimpleMessage("login", "invalid_login_or_password"));

    // you can use "this" to redirect to another logic from this controller
//    validator.onErrorUsePageOf(this).login(login, password);

    // the login was valid, add user to session
    UserInfo.login(currentUser);

    // we don't want to go to default page (/WEB-INF/jsp/home/login.jsp)
    // we want to redirect to the user's home
    result.redirectTo(UsersController.class).index();
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
    dao.add(new User(user, password, firstName, lastName, email, userType));
  }

}
