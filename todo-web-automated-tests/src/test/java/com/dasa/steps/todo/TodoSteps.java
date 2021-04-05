package com.dasa.steps.todo;

import com.dasa.pages.todo.TodoPage;
import com.dasa.utils.SessionVariables;
import cucumber.api.DataTable;
import net.thucydides.core.annotations.Step;

import java.util.*;

import static com.dasa.utils.SessionVariables.getListTask;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TodoSteps {

    TodoPage todoPage;

    @Step
    public void acessaFeatureTodo() {
        todoPage.open();
    }

    @Step
    public void insereNovaTask(DataTable dataTasks) {

        List<Map<String, String>> mapTasks = dataTasks.asMaps(String.class, String.class);
        List<String> listTask = new ArrayList();

        for (Map<String, String> task : mapTasks) {
            String[] firstUUID = UUID.randomUUID().toString().split("-");
            String taskName = String.format("%s-%s", task.get("task"), firstUUID[0]);
            todoPage.preencheNomeTask(taskName);
            todoPage.adicionaTask();
            listTask.add(taskName);
        }

        SessionVariables.setTask(listTask);
    }

    @Step
    public void exibeTaskInserida() {
        List<String> listTasks = todoPage.listaItens();
        getListTask().remove(1);

        assertThat(listTasks, containsInAnyOrder(getListTask().toArray()));
    }

    @Step
    public void excluiPrimeiraTask() {
        String task = getListTask().get(0);
        todoPage.excluirTask(task);
    }

    @Step
    public void naoExibeTask() {
        List<String> listTasks = todoPage.listaItens();
        String task = getListTask().get(0);

        assertThat(listTasks, not(hasItem(containsString(task))));
    }

    @Step
    public void moveTaskDone() {
        String task = getListTask().get(0);
        todoPage.moveTaskDone(task);
    }

    @Step
    public void exibeTaskDone() {
        todoPage.selecionaDone();
        List<String> listTasks = todoPage.listaItens();
        String task = getListTask().get(0);

        assertThat(listTasks, hasItem(containsString(task)));
    }
}
