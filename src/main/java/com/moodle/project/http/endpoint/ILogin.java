package com.moodle.project.http.endpoint;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface ILogin {
  @RequestLine("POST /login?user={user}&password={password}")
  @Headers({"Content-Type: application/json", "Content-Length: 0"})
  String login(@Param("user") String user, @Param("password") String password);

  @RequestLine("PUT /login?token={token}")
  @Headers({"Content-Type: application/json", "Content-Length: 0"})
  String logout(@Param("token") String authToken);

}
