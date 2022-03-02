package com.demo.ui.login;

import net.serenitybdd.screenplay.targets.Target;

public class Menu {
    public static final Target ORGANIZATION = Target.the("Organization ")
            .locatedBy("//span[@class='s-sidebar-link-text'][text()='Organization']");

    public static final Target BUSINESS_UNITS = Target.the("Business units")
            .locatedBy("//span[@class='s-sidebar-link-text'][text()='Business Units']");

    public static final Target MEETING = Target.the("Meeting")
            .locatedBy("//span[@class='s-sidebar-link-text'][text()='Meeting']");

    public static final Target MEETINGS = Target.the("Meetings")
            .locatedBy("//span[@class='s-sidebar-link-text'][text()='Meetings']");

}
