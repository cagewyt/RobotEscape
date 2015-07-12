package com.sagereducation.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.sagereducation.robotescape.RobotEscape;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Robot Escape";
	      config.width = 1080/2;
	      config.height = 720/2;
	      config.fullscreen = false;  
	      config.useGL30 = false;  
	      config.forceExit = true;  
	      config.vSyncEnabled = true;  
		new LwjglApplication(new RobotEscape(), config);
	}
}
