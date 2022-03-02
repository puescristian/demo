package com.demo.task.proFeatures;

import com.demo.interactions.AddAMeeting;
import com.demo.models.Contact;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;


public class AddMeetings implements Task {

    private final List<Performable> meetingInformation;

    public AddMeetings() {
        meetingInformation = new ArrayList<>();
        meetingInformation.add(AddAMeeting.newMeeting());
    }

    public static AddMeetings with(){
        return new AddMeetings();
    }

    public AddMeetings meetingName(String name) {
        this.meetingInformation.add(AddAMeeting.meetingName(name));
        return this;
    }

    public AddMeetings meetingType(String type) {
        this.meetingInformation.add(AddAMeeting.meetingType(type));
        return this;
    }

    public AddMeetings meetingNumber(String number) {
        this.meetingInformation.add(AddAMeeting.meetingNumber(number));
        return this;
    }

    public AddMeetings starDate(String date, String hour) {
        this.meetingInformation.add(AddAMeeting.starDate(date,hour));
        return this;
    }

    public AddMeetings endDate(String date, String hour) {
        this.meetingInformation.add(AddAMeeting.endDate(date,hour));
        return this;
    }

    public AddMeetings location(String location) {
        this.meetingInformation.add(AddAMeeting.location(location));
        return this;
    }

    public AddMeetings unit(String unit) {
        this.meetingInformation.add(AddAMeeting.unit(unit));
        return this;
    }

    public AddMeetings organizedBy(String organizedBy) {
        this.meetingInformation.add(AddAMeeting.organizedBy(organizedBy));
        return this;
    }

    public AddMeetings reporter(String reporter) {
        this.meetingInformation.add(AddAMeeting.reporter(reporter));
        return this;
    }
    public AddMeetings contact(String contact) {
        this.meetingInformation.add(AddAMeeting.contact(contact));
        return this;
    }

    public AddMeetings newContact(Contact contact) {
        this.meetingInformation.add(AddAMeeting.newContact(contact));
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        this.meetingInformation.add(AddAMeeting.saveRecord());
        actor.attemptsTo(
                actions()
        );
    }

    private Performable[] actions(){
        return this.meetingInformation.toArray(new Performable[this.meetingInformation.size()]);
    }


}
