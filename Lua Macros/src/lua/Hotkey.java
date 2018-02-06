package lua;

import task.Task;

class Hotkey extends Lua {

	@Override
	public String GetLuaInterpreterFile() {
		return "Hotkey";
	}

	@Override
	public void read(String line, boolean mode) {
		Task.executeMatching(line, mode);
	}

}
