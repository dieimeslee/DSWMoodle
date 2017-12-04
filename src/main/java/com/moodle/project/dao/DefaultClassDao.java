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

/**
 * Default implementation for UserDao
 *
 * @author Lucas Cavalcanti
 * @author Rodrigo Turini
 */
public class DefaultClassDao {


	/**
	 * Creates a new UserDao. You can receive dependencies 
	 * through constructor adding CDI's \@Inject annotation.
	 * 
	 */
	@Inject
	public DefaultClassDao() {	}



	public List<User> listAll() {
//		List list = new ArrayList<>();
//		User user = new User();
//		String response = new com.moodle.project.http.endpoint.User().get("");
//		user.setLogin(response);
//		list.add(user);
//		return list;
		return new ArrayList<>();
	}

	
	public boolean containsUserWithLogin(String login) {
		String response = new com.moodle.project.http.endpoint.User().get(login);
		return !response.contains("ERROR");
	}
	
	
	public Boolean add(String name, String quantity) {
		return !new com.moodle.project.http.endpoint.Class().post(name, quantity).contains("ERROR");
	}

}
