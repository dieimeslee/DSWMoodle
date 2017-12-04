package com.moodle.project.http.endpoint;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IClass {
  @RequestLine("POST /class?nome={name}&limiteAluno={limit}")
  @Headers("Content-Type: application/json")
  String create(@Param("name") String name, @Param("limit") String limit, String requestBody);

}
