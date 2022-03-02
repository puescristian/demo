package com.demo.features;


import com.demo.conf.BaseConf;
import com.demo.data.ContactFactory;
import com.demo.data.MeetingFactory;
import com.demo.models.Contact;
import com.demo.models.Meeting;
import com.demo.task.login.DoLogin;
import com.demo.task.proFeatures.AddBusinessUnit;
import com.demo.task.proFeatures.AddMeetings;
import com.demo.task.navigate.NavigateTo;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.FileNotFoundException;
import java.time.Duration;

import static com.demo.ui.login.Meetings.MEETING_RECORD;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

@RunWith(SerenityRunner.class)
@Narrative(text = {"In order to ....",
        "As a ....",
        "I want to be able to ...."})
@WithTag("login")
public class signUp extends BaseConf {

    @Before
    public void navigate() {
        actor.attemptsTo(
                NavigateTo
                        .homePage(),
                DoLogin
                        .withCredentials());
    }

    @Test
    @WithTagValuesOf({"loginWitCredentials"})
    public void should_UserCreateBusinessUnitAndMeetings_When_HeSendsCompleteInformation() throws FileNotFoundException {

        Contact contact = ContactFactory.getContactByKeyWithRandomData();
        Meeting meeting = MeetingFactory.getMeetingByKeyWithRandomData();

        actor.attemptsTo(
                NavigateTo
                        .businessUnits(),
                AddBusinessUnit
                        .with()
                        .name(meeting.getParentUnit()),
                AddBusinessUnit
                        .with()
                        .name(meeting.getUnit())
                        .parentUnit(meeting.getParentUnit()),
                NavigateTo
                        .meetings(),
                AddMeetings
                        .with()
                        .meetingName(meeting.getMeetingName())
                        .meetingType(meeting.getMeetingType())
                        .meetingNumber(meeting.getMeetingNumber())
                        .starDate(meeting.getStartDate(), meeting.getStartHour())
                        .endDate(meeting.getEndDate(), meeting.getEndHour())
                        .location(meeting.getLocation())
                        .unit(meeting.getUnit())
                        .organizedBy(meeting.getOrganizedBy())
                        .reporter(meeting.getReporter())
                        .contact(meeting.getContact())
                        .newContact(contact)
        );

        actor.should(
                seeThat("Meeting was created successfully", response ->
                        the(MEETING_RECORD.of(meeting.getMeetingName()).waitingForNoMoreThan(Duration.ofSeconds(20))).answeredBy(actor).isVisible()
                ));
    }


}