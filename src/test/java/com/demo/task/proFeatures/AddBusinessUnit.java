package com.demo.task.proFeatures;

import com.demo.interactions.AddABusinessUnit;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import java.util.ArrayList;
import java.util.List;


public class AddBusinessUnit implements Task {

    private final List<Performable> businessUnitsInformation;

    public AddBusinessUnit() {
        businessUnitsInformation = new ArrayList<>();
        businessUnitsInformation.add(AddABusinessUnit.newBusinessUnit());
    }

    public static AddBusinessUnit with(){
        return new AddBusinessUnit();
    }

    public AddBusinessUnit name(String name) {
        this.businessUnitsInformation.add(AddABusinessUnit.name(name));
        return this;
    }

    public AddBusinessUnit parentUnit(String parentName) {
        this.businessUnitsInformation.add(AddABusinessUnit.parentName(parentName));
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        this.businessUnitsInformation.add(AddABusinessUnit.saveRecord());
        actor.attemptsTo(
                actions()
        );
    }

    private Performable[] actions(){
        return this.businessUnitsInformation.toArray(new Performable[this.businessUnitsInformation.size()]);
    }
}
