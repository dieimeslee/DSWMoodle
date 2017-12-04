package com.moodle.project.controller;

import br.com.caelum.vraptor.*;
import com.moodle.project.dao.DefaultUserDao;
import com.moodle.project.interceptor.Public;
import com.moodle.project.model.User;

import javax.inject.Inject;


/**
 * The resource <code>UsersController</code> handles all user
 * operations, such as adding new users, listing users, and so on.
 */
@Controller
public class UserController {

    private final Result result;
    private String message;
    private final DefaultUserDao userDao;
    /**
     * @deprecated CDI eyes only
     */
    protected UserController () {
        this(null, null);
    }

    /**
     * Receives dependencies through the constructor.
     *
     * @param result VRaptor result handler.
     */
    @Inject
    public UserController (Result result, DefaultUserDao userDao) {
        this.result = result;
        this.userDao = userDao;
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
    public void create(String firstName, String lastName, String userType, String email, String user, String password) {
        resultDefaults();
        if(userDao.add(new User(user, password, firstName, lastName, email, userType))) {
            message = "Usuário criado com sucesso";
        } else {
            message = "Erro! Usuário não foi criado";
        }
        result.include("message", message);
        result.redirectTo(com.moodle.project.controller.UserController.class).index();
    }

    private void resultDefaults() {
        result.include("pageTitle", "Usuários");
        result.include("siteName", "Moodle");
    }

}
