package lua;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import macro.Macro;
import main.KeyboardEvent;
import me.bleuzen.javux.Javux;
import me.bleuzen.javux.ProcessResult;
import me.bleuzen.javux.Script;
import me.bleuzen.javux.ScriptInterpreter;
import task.Task;

public class Lua {
	
	public static void runLua(String path, String inputstring) {
		boolean fromKey = inputstring.isEmpty();
		
		String command = "lua Hotkey.lua \"" + path + "\" \"" + inputstring + "\" \"";

		for (int i = 0; i < KeyboardEvent.keyStatus.length; i++) {
			if (KeyboardEvent.keyStatus[i]) {
				command += "1";
			} else {
				command += "0";
			}
		}

		command += "\"";
		
		try {
			if(Javux.isLinux) {
				Script script = new Script(ScriptInterpreter.SH);
				script.addLine(command);

				ProcessResult result = script.exec();

				// TODO: add wait

				String output = result.getOutput();

				readInputSH(output, fromKey);

				if (result.getExitCode() == 1) {
					readErrSH(output);
				}
			} else {
				Process process = Runtime.getRuntime().exec(command);

				readInputJava(process, fromKey);
				readErrJava(process);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void runAll() {
		runAll("");
	}
	
	public static void runAll(String inputstring) {
		for (int i = 0; i < Macro.macroPaths.size(); i++) {
			runLua(Macro.macroPaths.get(i), inputstring);
		}
	}
	
	private static void readInputJava(Process process, boolean mode) throws IOException {
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			Task.executeMatching(line, mode);
		}
	}

	private static void readErrJava(Process process) throws IOException {
		InputStream is = process.getErrorStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line = null;

		while ((line = br.readLine()) != null) {
			System.err.println(line);
		}
	}

	private static void readInputSH(String output, boolean mode) {
		String[] lines = output.split(System.lineSeparator());

		for (String line : lines) {
			Task.executeMatching(line, mode);
		}
	}

	private static void readErrSH(String output) {
		String[] linesArray = output.split(System.lineSeparator());

		ArrayList<String> lines = new ArrayList<>();

		for (String line : linesArray) {
			lines.add(line);
		}

		for (int i = 0; i < lines.size(); i++) {
			for (Task task : Task.tasks) {
				if (lines.get(i).startsWith(task.name())) {
					lines.remove(i);
					i--;
					break;
				}
			}
		}

		String error = "";

		for (String line : lines) {
			error += line + System.lineSeparator();
		}

		System.err.print(error);
	}
	
}