package com.moodle.project.http.endpoint;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ILogin {
  @RequestLine("POST /login?user={user}&password={password}")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  String login(@Param("user") String user, @Param("password") String password);

  @RequestLine("PUT /login?token={token}")
  @Headers("Content-Type: application/x-www-form-urlencoded")
  String logout(@Param("token") String authToken);

}
