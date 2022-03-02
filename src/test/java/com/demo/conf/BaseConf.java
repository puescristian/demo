package com.demo.conf;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class BaseConf {

    protected Actor actor;
    private EnvironmentVariables environmentVariables;

    @Managed
    WebDriver browser;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        actor = theActorCalled("John Wick");

        actor.can(BrowseTheWeb.with(browser));
        browser.manage().window().maximize();


        actor.can(CallAnApi
                .at(
                        EnvironmentSpecificConfiguration.from(environmentVariables)
                                .getProperty("service.base.url")
                ));
        SerenityRest.setDefaultRequestSpecification(defaultRequestSpecification());

        actor.remember("baseUrl",
                EnvironmentSpecificConfiguration.from(environmentVariables)
                        .getProperty("webdriver.base.url"));
    }

    private RequestSpecification defaultRequestSpecification() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        return new RequestSpecBuilder()
                .addFilters(filters).build();
    }
}
