package main;

import model.Task;
import model.Project;
import model.Priority;
import model.TaskType;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		Project project = new Project("Website Redesign");
		
		// example task adds
		project.addTask(new Task("Update homepage", "Redesign hero section", Priority.HIGH, TaskType.TASK, LocalDate.of(2026, 5, 10)));
		project.addTask(new Task("Launch website", "Go live", Priority.CRITICAL, TaskType.MILESTONE, LocalDate.of(2026, 6, 5)));
		
		System.out.println("Project: " + project.getName());
		System.out.println("Tasks: " + project.getTaskCount());
		for (Task task : project.getTasks()) {
			System.out.println(task);
		}
	}

}
