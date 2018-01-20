package task;

import macro.Macro;

class KeyRelease extends Task {

	@Override
	public String name() {
		return "keyrelease";
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			return;
		}
		
		try {
			System.out.println(args[0]);
			
			int keycode = Integer.parseInt(args[0]);
			
			Macro.robot.keyRelease(keycode);
		} catch (NumberFormatException e) {
			
		}
	}

}
