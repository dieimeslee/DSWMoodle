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
package com.moodle.project.dao;


import com.moodle.project.model.User;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import com.moodle.project.http.endpoint.Login;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Default implementation for UserDao
 *
 * @author Lucas Cavalcanti
 * @author Rodrigo Turini
 */
public class DefaultUserDao implements UserDao {


	/**
	 * Creates a new UserDao. You can receive dependencies 
	 * through constructor adding CDI's \@Inject annotation.
	 * 
	 */
	@Inject
	public DefaultUserDao() {	}

	@Override
	public User find(String login, String password) {
			String response =  new Login().get(login, password);
			User user = new User();
			if (!response.contains("Error")) {
				user.setLogin(login);
				user.setPassword(password);
				try {
					JSONObject jsonObj = new JSONObject(response);
					user.setFirstName(jsonObj.get("firstName").toString());
					user.setLastName(jsonObj.get("lastName").toString());
					user.setEmail(jsonObj.get("email").toString());
					user.setUserType(jsonObj.get("role").toString());
					user.setAuthToken(jsonObj.get("auth-token").toString());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return user;
			} else
				return null;
	}

	@Override
	public User find(String login) {
		User user = new User();
		String response = new com.moodle.project.http.endpoint.User().get(login);
		user.setLogin(response);
		return user;
	}

	@Override
	public List<User> listAll() {
		List list = new ArrayList<>();
		User user = new User();
		String response = new com.moodle.project.http.endpoint.User().get("");
		user.setLogin(response);
		list.add(user);
		return list;
	}
	
	@Override
	public boolean containsUserWithLogin(String login) {
		String response = new com.moodle.project.http.endpoint.User().get(login);
		return !response.contains("ERROR");
	}
	
	@Override
	public Boolean add(User user) {
		return !new com.moodle.project.http.endpoint.User().post(user.getLogin(), user.getPassword(), user.getEmail(), user.getFirstName(), user.getLastName(), user.getUserType()).contains("ERROR");
	}

	@Override
	public Boolean recover(String user, String password, String email) {
		return new com.moodle.project.http.endpoint.User().put(user, password, email);
	}

	@Override
	public void refresh(User user) {
		new com.moodle.project.http.endpoint.User().get(user.getLogin());
	}

	@Override
	public void update(User user) {
		new com.moodle.project.http.endpoint.User().put(user.getLogin());
	}

}
