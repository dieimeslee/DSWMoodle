package com.moodle.project.http.endpoints;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

/*
For Feign usage reference, navigate to https://github.com/OpenFeign/feign-form
*/

public interface ILogin {
    @RequestLine("POST /login")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    String login(@Param("user") String user, @Param("password") String password);

    @RequestLine("PUT /login")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    String logout(@Param("token") String authToken);

}