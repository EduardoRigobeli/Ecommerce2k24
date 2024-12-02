/*Implemente uma classe abstrata TaskManager que represente um sistema de gerenciamento de tarefas. Ela deve ter um método abstrato addTask(task: string): void e outro listTasks(): string[].

Crie duas subclasses: Project e DailyTasks.
Project deve permitir adicionar tarefas específicas de um projeto e retornar uma lista de todas as tarefas do projeto.
DailyTasks deve permitir adicionar tarefas diárias e listar as tarefas adicionadas.
Cada tarefa deve ser única; implemente uma lógica que evite tarefas duplicadas.
Dica: para diferenciar as tarefas e dizer se ela são de projetos ou diárias, utilizem objetos*/
abstract class TaskManager {
    protected tasks: Set<string>;
  
    constructor() {
      this.tasks = new Set<string>();
    }
  
    abstract addTask(task: string): void;
  
    listTasks(): string[] {
      return Array.from(this.tasks);
    }
}
  
class Project extends TaskManager {
    private projectName: string;
  
    constructor(projectName: string) {
      super();
      this.projectName = projectName;
    }
  
    addTask(task: string): void {
      this.tasks.add(task);
    }
  
    listTasks(): string[] {
      return Array.from(this.tasks).map(task => `Project Task: ${task}`);
    }
}
  
class DailyTasks extends TaskManager {
    addTask(task: string): void {
      this.tasks.add(task);
    }
  
    listTasks(): string[] {
      return Array.from(this.tasks).map(task => `Daily Task: ${task}`);
    }
}

const project = new Project("Novo Projeto");
project.addTask("Terminar o Front-End");
project.addTask("Fazer implementações no Back-End");
  
const dailyTasks = new DailyTasks();
dailyTasks.addTask("Reunião de equipe");
dailyTasks.addTask("Enviar relatório");
  
console.log(project.listTasks());
console.log(dailyTasks.listTasks());