package task;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import macro.Macro;

class Write extends Task {

	@Override
	public String name() {
		return "Write";
	}

	@Override
	public void execute(String[] args, boolean fromKey) {
		if (args.length == 0) {
			return;
		}
		
		StringSelection stringSelection = new StringSelection(args[0]);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, stringSelection); // TODO: reset clipboard

		Macro.robot.keyPress(KeyEvent.VK_CONTROL);
		Macro.robot.keyPress(KeyEvent.VK_V);
		Macro.robot.keyRelease(KeyEvent.VK_V);
		Macro.robot.keyRelease(KeyEvent.VK_CONTROL);
	}

}
