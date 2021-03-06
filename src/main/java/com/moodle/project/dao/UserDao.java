package com.moodle.project.dao;

/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.moodle.project.model.User;

import java.util.List;


/**
 * Data Access Object of User entity.
 *
 * @author Lucas Cavalcanti
 * @author Rodrigo Turini
 */
public interface UserDao {

  /**
   * Finds an user by login and password.
   *
   * @return found user if it is unique
   */
  User find(String login, String password);

  /**
   * Finds an user by login
   *
   * @return found user if it is unique
   */
  User find(String login);

  /**
   * Adds the user on database
   */
  Boolean add(User user);

  /**
   * Synchronize the user data with the database.
   * Any not saved modification on user will be overwritten.
   * @return
   */
  void refresh(User user);

  /**
   * Update the user on database.
   */
  void update(User user);


  /**
   * Recover password.
   */
  Boolean recover(String user, String password, String email);


  /**
   * Retrieves all users from database.
   */
  List<User> listAll();

  /**
   * Checks if there is already an user with given login.
   *
   * @return true if there exists a user
   */
  boolean containsUserWithLogin(String login);

}