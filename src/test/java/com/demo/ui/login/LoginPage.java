package com.demo.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target USERNAME = Target.the("Username ")
            .locatedBy("//input[@name='Username']");

    public static final Target PASSWORD = Target.the("Password")
            .locatedBy("//input[@name='Password']");

    public static final Target SIGN_IN_BUTTON = Target.the("Sign in button")
            .locatedBy("//button[@id='StartSharp_Membership_LoginPanel0_LoginButton']");
}
