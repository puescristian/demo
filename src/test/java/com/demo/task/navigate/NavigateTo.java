package com.demo.task.navigate;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demo.ui.login.Menu.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class NavigateTo {

    public static Performable homePage() {
        return Task.where("{0} opens home page",
                Open.url(theActorInTheSpotlight().recall("baseUrl")));
    }

    public static Performable businessUnits() {
        return Task.where("{0} navigate to business units",
                WaitUntil.the(ORGANIZATION, isVisible()),
                Click.on(ORGANIZATION),
                Click.on(BUSINESS_UNITS)
                );
    }

    public static Performable meetings() {
        return Task.where("{0} navigate to meetings",
                WaitUntil.the(MEETING, isVisible()),
                Click.on(MEETING),
                Click.on(MEETINGS)
        );
    }
}
