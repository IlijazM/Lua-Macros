package main;

import java.io.BufferedReader;
import java.io.IOException;

import macro.LuaMacro;
import macro.Macro;

public class ReadInitFile {
	
	public static void read(BufferedReader reader) {
		String line = "";
		
		try {
			while ((line = reader.readLine()) != null) {
				executeLine(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void executeLine(String str) {
		String string1 = str.split(" ")[0];
		String string2 = str.substring(string1.length() + 1);
		
		switch (string1) {
		case "+":
			Macro.luaMacros.add(new LuaMacro(string2));
			break;
		}
	}
	
}