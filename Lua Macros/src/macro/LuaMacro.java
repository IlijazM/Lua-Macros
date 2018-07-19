package macro;

import java.util.ArrayList;

public class LuaMacro {
	
	public String path;
	public ArrayList<Integer> keyCode;
	public String inputstring;
	
	public LuaMacro() {
		this.keyCode = new ArrayList<>();
	}
	
	public LuaMacro(String path) {
		this.path = path;
		this.keyCode = new ArrayList<>();
	}
	
	public LuaMacro(String path, ArrayList<Integer> keyCode) {
		this.path = path;
		this.keyCode = keyCode;
	}
	
	public LuaMacro(String path, ArrayList<Integer> keyCode, String inputstring) {
		this.path = path;
		this.keyCode = keyCode;
		this.inputstring = inputstring;
	}
	
}
