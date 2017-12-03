package com.moodle.project.model;

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


import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
/**
 * User entity representing the User table from the database.
 * A persisted object of this class represents a record in the
 * database.
 */
@Resource
public class User implements Serializable {

  private static final long serialVersionUID = 4548298563023480676L;

  @NotNull
  @Pattern(regexp = "[a-z0-9_]+", message = "{invalid_login}")
  private String login;

  @NotNull
  private String password;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;

  @NotNull
  private String email;

  @NotNull
  private String userType;

  @NotNull
  private String authToken;


  public String getAuthToken() { return authToken; }

  public void setAuthToken(String authToken) { this.authToken = authToken; }

  public String getUserType() { return userType; }

  public void setUserType(String userType) { this.userType = userType; }

  public String getEmail() { return email; }

  public void setEmail(String email) { this.email = email; }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getLastName() { return lastName; }

  public void setLastName(String lastName) { this.lastName = lastName; }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }



}
