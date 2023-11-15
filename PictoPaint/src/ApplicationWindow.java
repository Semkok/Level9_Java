import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/*
 * MAIN JFRAME FOR THE PICOPAINT APPLICATION
 * */


public class ApplicationWindow extends JFrame {
	
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // object for getting the user its screen size
	
	public final static int WIDTH = (int)screenSize.getWidth() ,HEIGHT = (int)screenSize.getHeight();
	
	ApplicationWindow(){
		System.out.println(HEIGHT);
		setTitle("PictoPaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setSize(WIDTH,HEIGHT);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
	}
	
	
	
	

}
