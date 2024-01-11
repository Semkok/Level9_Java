import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * MAIN JFRAME FOR THE PICOPAINT APPLICATION
 * */


public class ApplicationWindow extends JFrame {
	
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // object for getting the user its screen size
	
	public final static int WIDTH = (int)screenSize.getWidth() ,HEIGHT = (int)screenSize.getHeight();
	
	ApplicationWindow(){
		setTitle("PictoPaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setPreferredSize(screenSize);
		setResizable(false);
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));
		DrawPanel drawPanel = new DrawPanel();
		ToolBar toolBar = new ToolBar(drawPanel);
		jpanel.add(toolBar);
		jpanel.add(drawPanel);
		add(jpanel);
		pack();
	}
	
	
	
	

}
