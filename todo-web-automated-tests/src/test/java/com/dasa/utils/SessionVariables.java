package com.dasa.utils;

import net.serenitybdd.core.Serenity;

import java.util.List;

public class SessionVariables {

    public static List<String> getListTask() {
        return Serenity.sessionVariableCalled("task");
    }

    public static void setTask(List<String> task) {
        Serenity.setSessionVariable("task").to(task);
    }
}
