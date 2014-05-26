package di.laser.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import di.laser.LaserTest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new LaserTest(), config);
		config.title = "Laser Test";
		config.samples = 4;
		config.vSyncEnabled = true;
	}
}
