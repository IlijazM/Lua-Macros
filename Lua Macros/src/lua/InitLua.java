package lua;

import macro.Macro;

class InitLua extends Lua {

	@Override
	public String GetLuaInterpreterFile() {
		return "Init";
	}

	@Override
	public void read(String line, boolean mode) {
		String string1 = line.split(" ")[0];
		String string2 = line.substring(string1.length() + 1);
		
		switch (string1) {
		case "Keycode":
			try {
				Macro.luaMacros.get(Lua.i).keyCode = Integer.parseInt(string2);
			} catch (NumberFormatException e) { }
			break;
		}
	}
	
}
