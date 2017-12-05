package com.moodle.project.http.endpoint;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface IEvent {

    @RequestLine("POST /if-calendar/newEvent")
    @Headers("Content-Type: application/json")
    String newEvent(String requestBody);
}
