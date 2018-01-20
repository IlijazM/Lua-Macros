package task;

import java.util.ArrayList;

public abstract class Task {
	
	private static ArrayList<Task> tasks;
	
	public static void init() {
		tasks = new ArrayList<>();
		
		tasks.add(new KeyType());
	}
	
	public static void executeMatching(final String task) {
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).executeIfMatches(task);
		}
	}
	
	public void executeIfMatches(final String task) {
		if (task.split(" ")[0].equalsIgnoreCase(name())) {
			execute(task);
		}
	}
	
	public void execute(String task) {
		task = task.substring(task.indexOf(' ') + 1);
		
		execute(task.split(" "));
	}
	
	public abstract String name();
	
	public abstract void execute(String[] args);
	
}
