package org.academiadecodigo.tropadelete.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.tropadelete.Game;
import org.academiadecodigo.tropadelete.GlobalVariables;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		config.title = "LetterBox";
		config.width = GlobalVariables.WINDOW_WITDH;
		config.height = GlobalVariables.WINDOW_HEIGHT;

		config.fullscreen = false;

		new LwjglApplication(new Game(), config);
	}
}
