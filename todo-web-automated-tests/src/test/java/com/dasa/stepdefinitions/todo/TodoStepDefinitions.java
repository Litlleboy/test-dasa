package com.dasa.stepdefinitions.todo;

import com.dasa.steps.todo.TodoSteps;
import cucumber.api.DataTable;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import net.thucydides.core.annotations.Steps;

public class TodoStepDefinitions {

    @Steps
    TodoSteps todoSteps;

    @Dado("^que estou no To-Do$")
    public void que_estou_no_To_Do() {
        todoSteps.acessaFeatureTodo();
    }

    @Quando("^novas tasks são inseridas$")
    public void novas_tasks_são_inseridas(DataTable dataTasks) {
        todoSteps.insereNovaTask(dataTasks);
    }

    @Então("^as tasks devem ser exibidas na listagem$")
    public void as_tasks_devem_ser_exibidas_na_listagem() {
        todoSteps.exibeTaskInserida();
    }

    @Dado("^as tasks estão previamente cadastradas$")
    public void as_tasks_estão_previamente_cadastrada(DataTable dataTasks) {
        todoSteps.insereNovaTask(dataTasks);
    }

    @Quando("^a exclusão da primeira task existente é realizada$")
    public void a_exclusão_da_primeira_task_existente_é_realizada() {
        todoSteps.excluiPrimeiraTask();
    }

    @Então("^a task não deve ser exibida na listagem$")
    public void a_task_não_deve_ser_exibida_na_listagem() {
        todoSteps.naoExibeTask();
    }

    @Quando("^a task é definida como DONE$")
    public void a_task_é_definida_como_DONE() {
        todoSteps.moveTaskDone();
    }

    @Então("^a task deve ser movida para DONE$")
    public void a_task_deve_ser_movida_para_DONE() {
        todoSteps.exibeTaskDone();
    }

}
