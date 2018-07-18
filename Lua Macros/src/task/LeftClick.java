package task;

import macro.Macro;

class LeftClick extends Task {

	@Override
	public String name() {
		return "LeftClick";
	}

	@Override
	public void execute(String[] args, boolean fromKey) {
		Macro.robot.mousePress(16);
		Macro.robot.mouseRelease(16);
	}

}
