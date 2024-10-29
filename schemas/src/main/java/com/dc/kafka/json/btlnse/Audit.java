package com.dc.kafka.json.btlnse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaInject;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaOptions;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaString;

import java.util.List;

/**
 * Created by dhanith on 1/26/2024
 */
@JsonSchemaInject(strings ={@JsonSchemaString(path="javaType", value="com.dc.kafka.json.btlnse") })
public class Audit {
    @JsonProperty(required = true)
    private String companyId;
    @JsonProperty
    private String eventCreationTime;
    @JsonProperty
    private List<String> inputter;
    @JsonProperty
    private String eventId;
    @JsonProperty
    private List<String> dateTime;

    public Audit() {
    }

    private Audit(String companyId, String eventCreationTime, List<String> inputter, String eventId, List<String> dateTime) {
        this.companyId = companyId;
        this.eventCreationTime = eventCreationTime;
        this.inputter = inputter;
        this.eventId = eventId;
        this.dateTime = dateTime;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Audit setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getEventCreationTime() {
        return eventCreationTime;
    }

    public Audit setEventCreationTime(String eventCreationTime) {
        this.eventCreationTime = eventCreationTime;
        return this;
    }

    public List<String> getInputter() {
        return inputter;
    }

    public Audit setInputter(List<String> inputter) {
        this.inputter = inputter;
        return this;
    }

    public String getEventId() {
        return eventId;
    }

    public Audit setEventId(String eventId) {
        this.eventId = eventId;
        return this;
    }

    public List<String> getDateTime() {
        return dateTime;
    }

    public Audit setDateTime(List<String> dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public static final class Builder {
        private String companyId;
        private String eventCreationTime;
        private List<String> inputter;
        private String eventId;
        private List<String> dateTime;

        private Builder() {
        }

        public static Builder anAudit() {
            return new Builder();
        }

        public Builder withCompanyId(String companyId) {
            this.companyId = companyId;
            return this;
        }

        public Builder withEventCreationTime(String eventCreationTime) {
            this.eventCreationTime = eventCreationTime;
            return this;
        }

        public Builder withInputter(List<String> inputter) {
            this.inputter = inputter;
            return this;
        }

        public Builder withEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }

        public Builder withDateTime(List<String> dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Audit build() {
            Audit audit = new Audit();
            audit.setCompanyId(companyId);
            audit.setEventCreationTime(eventCreationTime);
            audit.setInputter(inputter);
            audit.setEventId(eventId);
            audit.setDateTime(dateTime);
            return audit;
        }
    }

    @Override
    public String toString() {
        return "Audit{" +
                "companyId='" + companyId + '\'' +
                ", eventCreationTime='" + eventCreationTime + '\'' +
                ", inputter=" + inputter +
                ", eventId='" + eventId + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }
}
