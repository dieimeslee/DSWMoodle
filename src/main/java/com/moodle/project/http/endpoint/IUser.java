package com.moodle.project.http.endpoint;

import br.com.caelum.vraptor.HeaderParam;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IUser {
  @RequestLine("POST /user?user={user}&password={password}&email={email}&firstName={firstName}&lastName={lastName}&userType={userType}")
  @Headers("Content-Type: application/json")
  String create(@Param("user") String user,
                @Param("password") String password,
                @Param("email") String email,
                @Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("userType") String userType,
                String requestBody);

  @RequestLine("POST /task?name={name}&downloadLink={downloadLink}&description={description}&class={class}&date={date}")
  @Headers("Content-Type: application/json")
  String task(@Param("name") String name,
                @Param("downloadLink") String downloadLink,
                @Param("description") String description,
                @Param("class") String _class,
                @Param("date") String date,
                String requestBody);

  @RequestLine("PUT /user?user={user}")
  @Headers("Content-Length: 0")
  String update(@Param("user") String user);

  @RequestLine("GET /user?user={user}&newPassword={password}&email={email}")
  @Headers("Content-Length: 0")
  String recover(@Param("user") String user, @Param("password") String password, @Param("email") String email);

  @RequestLine("GET /user?user={user}")
  @Headers("Content-Length: 0")
  String find(@Param("user") String user);

}
