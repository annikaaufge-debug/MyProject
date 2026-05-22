package command;

import model.Task;
import model.Project;

public class DeleteTaskCommand implements ICommand {
	private Project project;
	private Task task;
	
	public DeleteTaskCommand(Project project, Task task) {
		this.project = project;
		this.task = task;
	}

	@Override
	public void execute() {
		project.removeTask(task);

	}

	@Override
	public void undo() {
		project.addTask(task);
	}

}
