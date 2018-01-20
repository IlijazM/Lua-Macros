package task;

import macro.Macro;

class KeyType extends Task {

	@Override
	public String name() {
		return "keytype";
	}

	@Override
	public void execute(String[] args) {
		if (args.length < 1) {
			return;
		}
		
		try {
			System.out.println(args[0]);
			
			int keycode = Integer.parseInt(args[0]);
			
			Macro.robot.keyPress(keycode);
			Macro.robot.keyRelease(keycode);
		} catch (NumberFormatException e) {
			
		}
	}

}
