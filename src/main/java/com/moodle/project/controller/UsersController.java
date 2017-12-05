package com.moodle.project.controller;

import br.com.caelum.vraptor.*;
//import br.com.caelum.vraptor..Validator;
import com.moodle.project.dao.EventDao;
import com.moodle.project.dao.UserDao;
import com.moodle.project.interceptor.Public;
import com.moodle.project.interceptor.UserInfo;
import com.moodle.project.model.User;
import com.moodle.project.validation.LoginAvailable;
import jdk.jfr.events.ExceptionThrownEvent;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.validation.Valid;

/**
 * The resource <code>UsersController</code> handles all user
 * operations, such as adding new users, listing users, and so on.
 */
@Controller
public class UsersController {

  private final Result result;
  private final UserDao userDao;
  private final UserInfo userInfo;
  private final EventDao eventDao;


  /**
   * @deprecated CDI eyes only
   */
  protected UsersController() {
    this(null, null, null, null);
  }

  /**
   * Receives dependencies through the constructor.
   *
   * @param factory dao factory.
   * @param userInfo info on the logged user.
   * @param result VRaptor result handler.
   * @param validator VRaptor validator.
   * @param userInfo
   */
  @Inject
  public UsersController(UserDao dao, Result result,
                         UserInfo userInfo, EventDao eventDao) {

    this.userDao = dao;
    this.result = result;
    this.userInfo = userInfo;
    this.eventDao = eventDao;
  }

  /**
   * Accepts HTTP GET requests.
   *
   * URL:  /home
   * View: /WEB-INF/jsp/users/index.jsp
   *
   * Shows user's home page containing his Music collection.
   */
  @Get
  @Public
  public void index() {resultDefaults();  }

  /**
   * Accepts HTTP GET requests.
   *
   * URL:  /users (only GET requests for this URL)
   * View: /WEB-INF/jsp/user/list.jsp
   *
   * Lists all users.
   */
  @Get("/users")
  public void list() {
    resultDefaults();
    result.include("users", userDao.listAll());
  }

  @Get
  public void task() {
    resultDefaults();
  }

  @Post
  public void task(String name, String downloadLink, String description, String _class, String date, String time) {
    resultDefaults();
    eventDao.add("Gregorian", UserInfo.getUser().getEmail() + "123", UserInfo.getUser().getPassword(), UserInfo.getUser().getLogin(), name, "IFSP", date + " 13", date + " 15");
    try {
      com.moodle.project.http.endpoint.User user = new com.moodle.project.http.endpoint.User();
      try {
        if (user.createTask(name, downloadLink, description, _class, date, time))
          result.include("message", "Tarefa adicionada com sucesso");
        else
          result.include("message", "Tarefa não foi adicionada com sucesso");
      } catch (Exception e) {
        result.include("message", "Tarefa não foi adicionada com sucesso");
      }
    }
    catch (Exception e) {
      result.include("message", "Tarefa não foi adicionada com sucesso");
    }
    result.redirectTo(UsersController.class).task();
  }


  private String addHtmlElement(String element) {
    return "<td>" + element + "</td>";
  }

  @Get
  public void showTasks() {
    resultDefaults();

    try {
      com.moodle.project.http.endpoint.User user = new com.moodle.project.http.endpoint.User();
      try {
        String _result = user.getTask(), htmlStr = "<table><tr><th>Tarefa</th><th>Turma</th><th>Descricao</th><th>Link</th><th>Data</th></tr>";
        String[] splittedResult = _result.split("|");

        for (int i = 0; i < splittedResult.length; i ++){
          htmlStr += "<tr>";
          JSONObject json = new JSONObject(splittedResult[i]);
          htmlStr += addHtmlElement(json.getString("name"));
          htmlStr += addHtmlElement(json.getString("class"));
          htmlStr += addHtmlElement(json.getString("description"));
          htmlStr += addHtmlElement(json.getString("downloadLink"));
          htmlStr += addHtmlElement(json.getString("date"));
        }
        htmlStr += "</table>";
        result.include("table", htmlStr);
      } catch (Exception e) {
        result.include("message", "Tarefas não puderam ser carregadas");
      }
    }
    catch (Exception e) {
      result.include("message", "Tarefa não foi adicionada com sucesso");
    }
  }

  @Get
  public void reminder() {
    resultDefaults();
  }

  @Post("/setReminder")
  public void setReminder(String status) {
    resultDefaults();
    com.moodle.project.http.endpoint.User user = new com.moodle.project.http.endpoint.User();
    try {
      if (user.setReminder(status))
        result.include("message", "Lembrete configurado com sucesso");
      else
        result.include("message", "Lembrete não foi configurado com sucesso");
    } catch (Exception e) {
      result.include("message", "Lembrete não foi configurado com sucesso");
    }
    result.redirectTo(UsersController.class).reminder();
  }
  /**
   * Accepts HTTP POST requests.
   *
   * URL:	 /users
   * View: /WEB-INF/jsp/user/add.jsp
   *
   * The "user" parameter will be populated with the request
   * parameters, for example:
   *
   * POST	/user
   * user.name=Nico
   * user.login=555555
   *
   * automatically populates the name and login parameters on
   * the user object with values Nico and 555555.
   *
   * Adds new users to the database.
   */
  @Path("/users")
  @Post
  @Public
  public void add(String username, String password, String email, String firstName, String lastName, String userType) {
    resultDefaults();
    User user = new User();
    user.setLogin(username);
    user.setPassword(password);
    user.setEmail(email);
    user.setFirstName(firstName);
    user.setLastName(lastName);
    user.setUserType(userType);
    userDao.add(user);

    result.include("notice", "User " + user.getFirstName() + " successfully added");
    result.redirectTo(RootController.class).login(UserInfo.getUser().getLogin(), UserInfo.getUser().getPassword());
  }


  private void resultDefaults() {
    result.include("pageTitle", "User");
    result.include("siteName", "Moodle");
    result.include("userName", UserInfo.getUser().getFirstName() + " " + UserInfo.getUser().getLastName());
  }

}

