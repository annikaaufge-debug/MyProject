package main;

import model.Task;
import model.Project;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;
import command.*;
import observer.TaskLogger;


public class Main {

	public static void main(String[] args) {
		Project project = new Project("Website Redesign");
		CommandManager manager = new CommandManager();
		
		// attach observer
		TaskLogger logger = new TaskLogger(project);
		project.attach(logger);
		
		//create tasks with commands
		Task task1 = new Task("Update homepage", "Redesign hero section", Priority.HIGH, TaskType.TASK, LocalDate.of(2026, 5, 10));
		Task task2 = new Task("Fix bug", "Login not working", Priority.CRITICAL, TaskType.TASK, LocalDate.of(2026, 5, 5));
		
		manager.executeCommand(new CreateTaskCommand(project, task1));
		manager.executeCommand(new CreateTaskCommand(project, task2));
		
		// change state with command
		manager.executeCommand(new ChangeStateCommand(task1));
		System.out.println(task1);
		
		// undo state change
		manager.undo();
		System.out.println(task1);
		
		// undo adding task2
		manager.undo();
		System.out.println("Tasks after undo: " + project.getTaskCount());
		
		// redo adding task2
		manager.redo();
		System.out.println("Tasks after redo: " + project.getTaskCount());
		
	}
}	
	