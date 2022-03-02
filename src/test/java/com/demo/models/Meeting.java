package com.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Meeting {
    private String key;
    private String meetingName;
    private String meetingType;
    private String parentUnit;
    private String meetingNumber;
    private String startDate;
    private String endDate;
    private String startHour;
    private String endHour;
    private String location;
    private String unit;
    private String organizedBy;
    private String reporter;
    private String contact;
}
