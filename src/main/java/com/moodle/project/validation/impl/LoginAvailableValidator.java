package com.moodle.project.validation.impl;

import com.moodle.project.dao.UserDao;
import com.moodle.project.model.User;
import com.moodle.project.validation.LoginAvailable;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LoginAvailableValidator
    implements ConstraintValidator<LoginAvailable, User> {

  @Inject
  private UserDao userDao;

  @Override
  public void initialize(LoginAvailable constraintAnnotation) {

  }

  @Override
  public boolean isValid(User user, ConstraintValidatorContext context) {
    return userDao.containsUserWithLogin(user.getLogin());
  }
}
