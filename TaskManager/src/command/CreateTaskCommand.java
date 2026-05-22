package command;

import model.Task;
import model.Project;

public class CreateTaskCommand implements ICommand {
	private Project project;
	private Task task;
	
	public CreateTaskCommand(Project project, Task task) {
		this.project = project;
		this.task = task;
	}

	@Override
	public void execute() {
		project.addTask(task);
	}

	@Override
	public void undo() {
		project.removeTask(task);
	}

}
