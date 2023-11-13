import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * MAIN JFRAME FOR THE PICOPAINT APPLICATION
 * */


public class ApplicationWindow extends JFrame {
	
	// object for getting the user its screen size
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	final double WIDTH = screenSize.getWidth();
	final double HEIGHT = screenSize.getHeight();
	
	ApplicationWindow(){
		setTitle("PictoPaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(1280,720);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	}
	

}
