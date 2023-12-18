import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;
/*
 * MAIN WINDOW FOR THE APPLICATION TO RUN IN
 * */
public class ApplicationWindow extends JFrame {
	String userOS = System.getProperty("os.name").toLowerCase();
	ApplicationWindow(){
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice device = graphics.getDefaultScreenDevice();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		device.setFullScreenWindow(this);
		setVisible(true);
		add(new ApplicationPanel(this));
		pack();
	}
	
}
