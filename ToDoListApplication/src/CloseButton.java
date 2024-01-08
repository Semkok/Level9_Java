import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/*
 * EXIT BUTTON CLASS FOR EXITING THE APPLICATION
 * */

public class CloseButton extends JButton implements ActionListener {
	
	private ApplicationWindow appWindow;
	
	CloseButton(ApplicationWindow appWindow){
		this.appWindow = appWindow;
		setText("Exit");
		addActionListener(this);
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			appWindow.dispose(); // disposes off the AppWindow like EXIT_ON_CLOSE
		}
		
	
}
