package com.demo.interactions;

import com.demo.models.Contact;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demo.ui.login.Meetings.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddAMeeting {

    public static Performable newMeeting() {
        return Task.where("{0} click on new meeting button ",
                WaitUntil.the(NEW_MEETING_BUTTON, isVisible()),
                Click.on(NEW_MEETING_BUTTON)
        );
    }

    public static Performable meetingName(String name) {
        return Task.where("{0} add a meeting name #name",
                        Click.on(MEETING_NAME)
                                .then(Enter.theValue(name).into(MEETING_NAME)))
                .with("name").of(name);
    }

    public static Performable meetingType(String type) {
        return Task.where("{0} select the meeting type #type",
                Click.on(MEETING_TYPE),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(type).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(type), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(type))
                        )
        ).with("type").of(type);
    }

    public static Performable meetingNumber(String number) {
        return Task.where("{0} add a meeting number #number",
                        Click.on(MEETING_NUMBER)
                                .then(Enter.theValue(number).into(MEETING_NUMBER)))
                .with("number").of(number);
    }

    public static Performable starDate(String date, String hour) {
        return Task.where("{0} add a meeting start date #date #hour ",
                        Click.on(STAR_DATE)
                                .then(Enter.theValue(date).into(STAR_DATE)),
                        SelectFromOptions.byVisibleText(hour)
                                .from(STAR_DATE_HOUR))
                .with("date").of(date)
                .with("hour").of(hour);
    }

    public static Performable endDate(String date, String hour) {
        return Task.where("{0} add a meeting end date #date",
                        Click.on(END_DATE)
                                .then(Enter.theValue(date).into(END_DATE)),
                        SelectFromOptions.byVisibleText(hour)
                                .from(END_DATE_HOUR))
                .with("date").of(date)
                .with("hour").of(hour);
    }

    public static Performable location(String location) {
        return Task.where("{0} select the location #location",
                Click.on(LOCATION),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(location).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(location), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(location))
                        )
        ).with("location").of(location);
    }

    public static Performable unit(String unit) {
        return Task.where("{0} select the unit #unit",
                Click.on(UNIT),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(unit).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(unit), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(unit))
                        )
        ).with("unit").of(unit);
    }

    public static Performable organizedBy(String organizer) {
        return Task.where("{0} select the organizer #organizer",
                Click.on(ORGANIZED_BY),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(organizer).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(organizer), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(organizer))
                        )
        ).with("organizer").of(organizer);
    }

    public static Performable reporter(String reporter) {
        return Task.where("{0} select the reporter #reporter",
                Click.on(REPORTER),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(reporter).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(reporter), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(reporter))
                        )
        ).with("reporter").of(reporter);
    }

    public static Performable contact(String contact) {
        return Task.where("{0} select the contact #contact",
                Click.on(SELECT_CONTACT),
                Click.on(INPUT_SEARCH_OPTION)
                        .then(Enter.theValue(contact).into(INPUT_SEARCH_OPTION)),
                WaitUntil.the(LIST_OPTION.of(contact), isVisible())
                        .then(
                                Click.on(LIST_OPTION.of(contact))
                        )
        ).with("contact").of(contact);
    }

    public static Performable newContact(Contact contact) {
        return Task.where("{0} create the contact #firstname #lastname",
                        Click.on(NEW_CONTACT),
                        WaitUntil.the(NEW_CONTACT_TITLE, isVisible()),
                        Click.on(NEW_CONTACT_TITLE)
                                .then(
                                        Enter.theValue(contact.getTitle()).into(NEW_CONTACT_TITLE)
                                ),
                        Click.on(NEW_CONTACT_FIRST_NAME)
                                .then(
                                        Enter.theValue(contact.getFirstName()).into(NEW_CONTACT_FIRST_NAME)
                                ),
                        Click.on(NEW_CONTACT_LAST_NAME)
                                .then(
                                        Enter.theValue(contact.getLastName()).into(NEW_CONTACT_LAST_NAME)
                                ),
                        Click.on(NEW_CONTACT_EMAIL)
                                .then(
                                        Enter.theValue(contact.getEmail()).into(NEW_CONTACT_EMAIL)
                                ),
                        Click.on(NEW_CONTACT_IDENTITY_NO)
                                .then(
                                        Enter.theValue(contact.getIdentityNo()).into(NEW_CONTACT_IDENTITY_NO)
                                ),
                        Click.on(NEW_CONTACT_SAVE_BUTTON)
                )
                .with("firstname").of(contact.getFirstName())
                .with("lastname").of(contact.getLastName());
    }


    public static Performable saveRecord() {
        return Task.where("{0} save the new business unit",
                Click.on(SAVE_BUTTON)
        );
    }

}
