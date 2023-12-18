import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/*
 * EXIT BUTTON CLASS FOR EXITING THE APPLICATION
 * */

public class CloseApplicationWindowButton extends JButton {
	
	ApplicationWindow appWindow;
	
	CloseApplicationWindowButton(ApplicationWindow appWindow){
		this.appWindow = appWindow;
		setText("Exit");
		addActionListener(new ExitApplication());
	}
	
	private class ExitApplication implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			appWindow.dispose(); // disposes off the AppWindow
		}
		
	}
}
