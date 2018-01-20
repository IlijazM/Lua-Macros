package task;

import macro.Macro;

class KeyPress extends Task {

	@Override
	public String name() {
		return "keypress";
	}

	@Override
	public void execute(String[] args, boolean fromKey) {
		if (args.length < 1) {
			return;
		}
		
		try {
			int keycode = Integer.parseInt(args[0]);
			
			Macro.robot.keyPress(keycode);
		} catch (NumberFormatException e) {
			
		}
	}

}
