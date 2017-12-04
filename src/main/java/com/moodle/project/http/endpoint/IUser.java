package com.moodle.project.http.endpoint;

import br.com.caelum.vraptor.HeaderParam;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IUser {
  @RequestLine("POST /user?user={user}&email={email}&firstName={firstName}&lastName={lastName}&userType={userType}")
  @Headers({"Content-Type: application/json", "Content-Length: 0"})
  String create(@Param("user") String user, @Param("password") String password,
                @Param("email") String email,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("userType") String userType);

  @RequestLine("PUT /user?user={user}")
  @Headers("Content-Type: application/json")
  String update(@Param("user") String user);

  @RequestLine("GET /user?user={user}&newPassword={password}&email={email}")
  @Headers({"Content-Type: application/json", "Content-Length: 0"})
  String recover(@Param("user") String user, @Param("password") String password, @Param("email") String email);

  @RequestLine("GET /user?user={user}")
  @Headers({"Content-Type: application/json", "Content-Length: 0"})
  String find(@Param("user") String user);

}
