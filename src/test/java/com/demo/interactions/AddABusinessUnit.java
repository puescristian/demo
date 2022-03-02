package com.demo.interactions;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.demo.ui.login.BusinessUnits.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddABusinessUnit {

    public static Performable newBusinessUnit() {
        return Task.where("{0} click on new business unit button ",
                WaitUntil.the(NEW_BUSINESS_UNIT_BUTTON, isVisible()),
                Click.on(NEW_BUSINESS_UNIT_BUTTON)
        );
    }

    public static Performable name(String name) {
        return Task.where("{0} add a name #name",
                        Click.on(BUSINESS_UNIT_NAME.of(name))
                                .then(Enter.theValue(name).into(BUSINESS_UNIT_NAME)))
                .with("name").of(name);
    }

    public static Performable parentName(String parentName) {
        return Task.where("{0} select the parent unit #parentName",
                Click.on(PARENT_UNIT),
                WaitUntil.the(PARENT_UNIT_OPTION.of(parentName), isVisible())
                        .then(
                                Click.on(PARENT_UNIT_OPTION.of(parentName))
                        )
        ).with("parentName").of(parentName);
    }

    public static Performable saveRecord() {
        return Task.where("{0} save the new business unit",
                Click.on(SAVE_BUTTON)
        );
    }

}
