package com.demo.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Meetings {

    public static final Target NEW_MEETING_BUTTON = Target.the("New meeting button")
            .locatedBy("//i[@class='fa fa-plus-circle text-green']");

    public static final Target MEETING_NAME = Target.the("Meeting name")
            .locatedBy("//input[@name='MeetingName']");

    public static final Target MEETING_TYPE = Target.the("Meeting type")
            .located(By.cssSelector("[id^='s2id_Serenity_Pro_Meeting_MeetingDialog']"));

    public static final Target MEETING_NUMBER = Target.the("Meeting number")
            .locatedBy("//input[@name='MeetingNumber']");

    public static final Target STAR_DATE = Target.the("Star date")
            .locatedBy("//input[@name='StartDate']");

    public static final Target STAR_DATE_HOUR = Target.the("Star date hour")
            .locatedBy("//input[@name='StartDate']/..//select");

    public static final Target STAR_DATE_HOUR_OPTION = Target.the("Star date hour option")
            .locatedBy("//input[@name='StartDate']/..//select/option[@value='{0}']");

    public static final Target END_DATE = Target.the("End date")
            .locatedBy("//input[@name='EndDate']");

    public static final Target END_DATE_HOUR = Target.the("End date hour")
            .locatedBy("//input[@name='EndDate']/..//select");


    public static final Target INPUT_SEARCH_OPTION = Target.the("Search option")
            .locatedBy("//div[@role='option']/../../..//input");

    public static final Target LIST_OPTION = Target.the("List option {0}")
            .locatedBy("//div[@role='option']/span[text()='{0}']");

    public static final Target LOCATION = Target.the("Location")
            .locatedBy("//label[@title='Location']/following-sibling::div[1]/a");

    public static final Target UNIT = Target.the("Unit")
            .locatedBy("//label[@title='Unit']/following-sibling::div[1]/a");

    public static final Target ORGANIZED_BY = Target.the("Organized by")
            .locatedBy("//label[@title='Organized By']/following-sibling::div[1]/a");

    public static final Target REPORTER = Target.the("Reporter by")
            .locatedBy("//label[@title='Reporter']/following-sibling::div[1]/a");

    public static final Target SELECT_CONTACT = Target.the("Select contact")
            .locatedBy("(//label[@title='Attendee List']/..//a)[1]");

    public static final Target NEW_CONTACT = Target.the("new contact")
            .locatedBy("//input[@placeholder='--select contact to add--']/following-sibling::a");

    public static final Target NEW_CONTACT_TITLE = Target.the("new contact title")
            .locatedBy("//div[@class='s-DialogContent']//input[@name='Title']");

    public static final Target NEW_CONTACT_FIRST_NAME = Target.the("new contact First Name")
            .locatedBy("//div[@class='s-DialogContent']//input[@name='FirstName']");

    public static final Target NEW_CONTACT_LAST_NAME = Target.the("new contact Last Name")
            .locatedBy("//div[@class='s-DialogContent']//input[@name='LastName']");

    public static final Target NEW_CONTACT_EMAIL = Target.the("new contact Email")
            .locatedBy("//div[@class='s-DialogContent']//input[@name='Email']");

    public static final Target NEW_CONTACT_IDENTITY_NO = Target.the("new contact Identity No")
            .locatedBy("//div[@class='s-DialogContent']//input[@name='IdentityNo']");

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//span[@class='button-inner'][normalize-space()='Save']");

    public static final Target NEW_CONTACT_SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//div[@class='s-DialogContent']//span[@class='button-inner'][normalize-space()='Save']");

    public static final Target MEETING_RECORD = Target.the("the meeting number {0}")
            .locatedBy("//a[text()='{0}']");
}
