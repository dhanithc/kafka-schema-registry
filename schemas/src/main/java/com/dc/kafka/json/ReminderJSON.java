package com.dc.kafka.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaInject;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaString;

@JsonSchemaInject(strings =
        {@JsonSchemaString(path="javaType", value="com.dc.kafka.json")})
public class ReminderJSON {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String event;

    @JsonProperty
    private String date;

    @JsonProperty
    private String time;

    @JsonProperty
    private String test;

    public ReminderJSON() { }

    public ReminderJSON(Integer id, String event, String date, String time, Boolean recurring, String test) {
        this.id = id;
        this.event = event;
        this.date = date;
        this.time = time;
        this.recurring = recurring;
        this.test = test;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getRecurring() {
        return recurring;
    }

    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    private Boolean recurring;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
