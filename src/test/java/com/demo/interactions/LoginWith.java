package com.demo.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.demo.ui.login.LoginPage.*;

public class LoginWith implements Interaction {

    private String username;
    private String password;

    public LoginWith(String username) {
        this.username = username;
    }

    public static LoginWith username(String username) {
        return new LoginWith(username);
    }

    public LoginWith andPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(USERNAME)
                        .then(Clear.field(USERNAME))
                        .then(
                                Enter.theValue(username).into(USERNAME)
                        ),
                Click.on(PASSWORD)
                        .then(Clear.field(PASSWORD))
                        .then(
                                Enter.theValue(password).into(PASSWORD)
                        ),
                Click.on(SIGN_IN_BUTTON)
        );
    }
}
