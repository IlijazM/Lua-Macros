package task;

import macro.Macro;

class RightClick extends Task {

	@Override
	public String name() {
		return "RightClick";
	}

	@Override
	public void execute(String[] args, boolean fromKey) {
		Macro.robot.mousePress(16);
		Macro.robot.mouseRelease(16);
	}

}
