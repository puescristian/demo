package com.demo.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusinessUnits {

    public static final Target NEW_BUSINESS_UNIT_BUTTON = Target.the("New business unit button")
            .locatedBy("//i[@class='fa fa-plus-circle text-green']");

    public static final Target BUSINESS_UNIT_NAME = Target.the("business unit name")
            .locatedBy("//input[@name='Name']");

    public static final Target PARENT_UNIT = Target.the("Parent unit")
            .located(By.cssSelector("[id^='s2id_Serenity_Pro_Organization_BusinessUnitDialog']"));

    public static final Target PARENT_UNIT_OPTION = Target.the("Parent unit option")
            .locatedBy("//div[@role='option'][text()='{0}']");

    public static final Target SAVE_BUTTON = Target.the("Save button")
            .locatedBy("//span[@class='button-inner'][normalize-space()='Save']");

}
