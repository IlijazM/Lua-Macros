package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import frame.Frame;
import lua.Lua;
import macro.Macro;
import task.Task;

public class Init {
	
	private static BufferedReader initFileReader;
	@SuppressWarnings("unused")
	private static BufferedWriter initFileWriter;
	
	public static void initAll() {
		init();
		
		loadFiles();
		Lua.initAll();
		
		initFrame();
	}
	
	public static void init() {
		Macro.init();
		Task.init();
		Lua.init();
		
		// init keylisteners from jnativehook
		
		KeyboardEvent.init();
	}
	
	public static void initFrame() {
		Main.frame = new Frame("Lua Macros", 400, 250);
	}
	
	public static void loadFiles() {
		File file = AppDir.getAppDir("Lua-Macros");
		file = new File(file.getAbsolutePath() + File.separator + "Init.init");
		
		if (!file.exists()) {
			FileWriter fileWriter;
			try {
				fileWriter = new FileWriter(file);
				initFileWriter = new BufferedWriter(fileWriter);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		
		try {
			FileReader fileReader = new FileReader(file);
			initFileReader = new BufferedReader(fileReader);
			
			ReadInitFile.read(initFileReader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
