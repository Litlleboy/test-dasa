# language: pt

@regressivo
Funcionalidade: To-Do
  Como usuário do To-Do
  Eu quero inserir minhas tasks
  Para que eu possa ter melhor controle das minhas atividades

  Contexto:
    Dado que estou no To-Do

  Cenário: Inserir nova task
    Quando novas tasks são inseridas
      | task                           |
      | Levantar requisitos            |
      | Desenvolver feature            |
      | Desenvolver cenários de testes |
      | Automatizar cenários de testes |
    Então as tasks devem ser exibidas na listagem


  Cenário: Excluir uma task existente
    E as tasks estão previamente cadastradas
      | task                           |
      | Levantar requisitos            |
      | Desenvolver feature            |
      | Desenvolver cenários de testes |
      | Automatizar cenários de testes |
    Quando a exclusão da primeira task existente é realizada
    Então a task não deve ser exibida na listagem

  Cenário: Definir uma task como DONE
    E as tasks estão previamente cadastradas
      | task                           |
      | Levantar requisitos            |
    Quando a task é definida como DONE
    Então a task deve ser movida para DONE