package com.demo.task.login;

import com.demo.interactions.LoginWith;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class DoLogin {

    public static Performable withCredentials() {
        return Task.where("{0} do login page with credentials",
                LoginWith
                        .username("admin")
                        .andPassword("serenity")
        );
    }
}
