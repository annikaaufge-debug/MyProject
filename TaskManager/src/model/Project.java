package model;

import java.util.ArrayList;
import java.util.List;
import strategy.ISortStrategy;
import observer.IObserver;
import observer.ISubject;

public class Project implements ISubject {
	private String name;
	private List<Task> tasks;
	private ISortStrategy sortStrategy;
	private List<IObserver> observers;
	
	
	public Project(String name) {
		this.name = name;
		this.tasks = new ArrayList<>();
		this.observers = new ArrayList<>();
	}
	
	public void addTask(Task task) {
		tasks.add(task);
		notifyObservers();
	}
	
	public void removeTask(Task task) {
		tasks.remove(task);
		notifyObservers();
	}
	
	public List<Task> getTasks() {
		if (sortStrategy != null) {
			return sortStrategy.sort(tasks);
		}
		return new ArrayList<>(tasks);
	}
	
	public void setSortStrategy(ISortStrategy sortStrategy) {
		this.sortStrategy = sortStrategy;
		notifyObservers();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getTaskCount() { return tasks.size(); }
	
	@Override
	public void attach(IObserver observer) {
		observers.add(observer);
	}
	
	@Override
	public void detach(IObserver observer) {
		observers.remove(observer);
	}
	
	@Override
	public void notifyObservers() {
		for (IObserver observer : observers) {
			observer.update();
		}
	}
}
