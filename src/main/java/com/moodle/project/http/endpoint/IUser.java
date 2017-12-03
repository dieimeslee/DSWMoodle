package com.moodle.project.http.endpoint;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IUser {
  @RequestLine("POST /user?user={user}&email={email}&firstName={firstName}&lastName={lastName}&userType={userType}")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  String create(@Param("user") String user, @Param("password") String password,
                @Param("email") String email,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("userType") String userType);

  @RequestLine("PUT /user?user={user}")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  String update(@Param("user") String user);

  @RequestLine("GET /user?user={user}")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  String find(@Param("user") String user);

}
