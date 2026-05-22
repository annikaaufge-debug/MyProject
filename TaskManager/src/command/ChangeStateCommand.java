package command;

import model.Task;
import state.ITaskState;

public class ChangeStateCommand implements ICommand {
	private Task task;
	private ITaskState previousState;
	
	public ChangeStateCommand(Task task) {
		this.task = task;
	}

	@Override
	public void execute() {
		previousState = task.getState();
		task.forward();

	}

	@Override
	public void undo() {
		task.setState(previousState);
	}

}
