package macro;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

public class Macro {
	
	public static ArrayList<LuaMacro> luaMacros;
	public static Robot robot;
	
	public static void init() {
		luaMacros = new ArrayList<>();
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	// print
	
	public static void Log(Object ... messages) {
		for (int i = 0; i < messages.length; i++) {
			System.out.print(String.valueOf((i != 0 ? ", " : "") + messages[i]));
		}
		
		System.out.println("");
	}
	
}
