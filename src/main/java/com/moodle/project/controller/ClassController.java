package com.moodle.project.controller;

import br.com.caelum.vraptor.*;
import com.moodle.project.dao.DefaultClassDao;
import com.moodle.project.interceptor.Public;

import javax.inject.Inject;


/**
 * The resource <code>UsersController</code> handles all user
 * operations, such as adding new users, listing users, and so on.
 */
@Controller
public class ClassController {

  private final Result result;
  private String message;
  private final DefaultClassDao classDao;
  /**
   * @deprecated CDI eyes only
   */
  protected ClassController() {
    this(null, null);
  }

  /**
   * Receives dependencies through the constructor.
   *
   * @param factory dao factory.
   * @param result VRaptor result handler.
   * @param validator VRaptor validator.
   */
  @Inject
  public ClassController(Result result, DefaultClassDao classDao) {
    this.result = result;
    this.classDao = classDao;
  }

  /**
   * Accepts HTTP GET requests.
   *
   * URL:  /home
   * View: /WEB-INF/jsp/class/index.jsp
   *
   * Shows user's home page containing his Music collection.
   */
  @Get
  @Public
  public void index() {resultDefaults();  }


  @Post
  @Public
  public void create(String name, String quantity) {
    resultDefaults();
    if (classDao.add(name, quantity)) {
      message = "Turma criada com sucesso";
    } else {
      message = "Turma não pode ser criada, tente outro nome";
    }
    result.include("message", message);
    result.redirectTo(ClassController.class).index();
  }

  private void resultDefaults() {
    result.include("pageTitle", "Classes");
    result.include("siteName", "Moodle");
  }

}

