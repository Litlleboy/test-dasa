package com.dasa.pages.todo;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class TodoPage extends PageObject {

    @FindBy(css = "#field_todoTask")
    private WebElementFacade txtTask;

    @FindBy(css = "#btn_todoAddTask")
    private WebElementFacade btnAdicionarTask;

    @FindBy(css = "ul li[class]")
    private WebElementFacade taskDisappear;

    @FindBy(css = "ul li span")
    private List<WebElementFacade> listaItens;

    @FindBy(css = "#done")
    private WebElementFacade btnDone;

    public void preencheNomeTask(String task) {
        txtTask.type(task);
    }

    public void adicionaTask() {
        btnAdicionarTask.click();
    }

    public List<String> listaItens() {
        return listaItens.stream().map(items -> items.getText().split("\n")[0]).collect(Collectors.toList());
    }

    public void excluirTask(String task) {
        WebElementFacade taskInList = listaItens
                .stream()
                .filter(item -> item.getText().contains(task))
                .findFirst()
                .get();

        taskInList.find(By.xpath("../button")).click();

        waitTaskDisappear();
    }

    public void moveTaskDone(String task) {
        WebElementFacade taskInList = listaItens
                .stream()
                .filter(item -> item.getText().contains(task))
                .findFirst()
                .get();

        taskInList.find(By.xpath("../input")).click();

        waitTaskDisappear();
    }

    public void selecionaDone() {
        btnDone.click();
    }

    public void waitTaskDisappear() {
        taskDisappear.waitUntilNotVisible();
    }
}
