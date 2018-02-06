package task;

import java.util.ArrayList;

public abstract class Task {
	
	public static ArrayList<Task> tasks;
	
	public static void init() {
		tasks = new ArrayList<>();
		
		tasks.add(new KeyType());
		tasks.add(new KeyPress());
		tasks.add(new KeyRelease());
		tasks.add(new Print());
	}
	
	public static void executeMatching(final String task, boolean fromKey) {
		for (int i = 0; i < tasks.size(); i++) {
			tasks.get(i).executeIfMatches(task, fromKey);
		}
	}
	
	public void executeIfMatches(final String task, boolean fromKey) {
		if (task.split(" ")[0].equalsIgnoreCase(name())) {
			execute(task, fromKey);
		}
	}
	
	public void execute(String task, boolean fromKey) {
		task = task.substring(task.indexOf(' ') + 1);
		
		execute(task.split(" "), fromKey);
	}
	
	public abstract String name();
	
	public abstract void execute(String[] args, boolean fromKey);
	
}
