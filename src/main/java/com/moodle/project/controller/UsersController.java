package com.moodle.project.controller;

import br.com.caelum.vraptor.*;
//import br.com.caelum.vraptor..Validator;
import com.moodle.project.dao.UserDao;
import com.moodle.project.interceptor.Public;
import com.moodle.project.interceptor.UserInfo;
import com.moodle.project.model.User;
import com.moodle.project.validation.LoginAvailable;

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

  /**
   * @deprecated CDI eyes only
   */
  protected UsersController() {
    this(null, null, null);
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
                         UserInfo userInfo) {

    this.userDao = dao;
    this.result = result;
    this.userInfo = userInfo;
  }

  /**
   * Accepts HTTP GET requests.
   *
   * URL:  /home
   * View: /WEB-INF/jsp/user/index.jsp
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
  public void add(@LoginAvailable User user) {
    resultDefaults();
//    validator.onErrorUsePageOf(RootController.class).login(userInfo.getUser().getLogin(), userInfo.getUser().getPassword());

    userDao.add(user);

    // you can add objects to result even in redirects. Added objects will
    // survive one more request when redirecting.
    result.include("notice", "User " + user.getFirstName() + " successfully added");
    result.redirectTo(RootController.class).login(UserInfo.getUser().getLogin(), UserInfo.getUser().getPassword());
  }


  private void resultDefaults() {
    result.include("pageTitle", "User");
    result.include("siteName", "Moodle");
    result.include("userName", UserInfo.getUser().getFirstName() + " " + UserInfo.getUser().getLastName());
  }

}

