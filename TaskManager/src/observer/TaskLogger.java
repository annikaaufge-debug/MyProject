package observer;

import model.Project;

public class TaskLogger implements IObserver {
	private Project project;
	
	public TaskLogger(Project project) {
		this.project = project;
	}

	@Override
	public void update() {
		System.out.println("[TaskLogger] Project Update - Total tasks: " + project.getTaskCount());

	}

}
