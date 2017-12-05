package com.moodle.project.dao;

import com.moodle.project.model.User;

import javax.inject.Inject;

public class EventDao {

    @Inject
    public EventDao() {
    }

    public Boolean add(String nameCalendar, String emailUser, String passwordUser, String nameUser, String nameEvent, String localEvent, String startEvent, String endEvent) {
        String body = "{\"eventApi\":{\"nameCalendar\":\""+ nameCalendar + "\",\"emailUser\":\"" + emailUser + "\",\"passwordUser\":\"" + passwordUser + "\",\"nameUser\":\"" + nameUser + "\",\"nameEvent\":\""+ nameEvent +"\",\"localEvent\":\"" + localEvent + "\",\"startEvent\":\"" + startEvent + "\",\"endEvent\":\"" + endEvent + "\"}}";
        return !new com.moodle.project.http.endpoint.Event().post(body).contains("ERROR");
    }


}
