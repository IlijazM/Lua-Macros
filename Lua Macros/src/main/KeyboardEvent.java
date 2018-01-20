package main;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.jnativehook.AbstractSwingInputAdapter;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

@SuppressWarnings("serial")
public class KeyboardEvent extends AbstractSwingInputAdapter implements NativeKeyListener {
	
	static void init() {
		try {
			Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
			logger.setLevel(Level.WARNING);

			logger.setUseParentHandlers(false);

			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(new KeyboardEvent());

		} catch (NativeHookException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent key) {
		// Macro.Log(key.getKeyCode());
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent key) {
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent key) {}
	
}