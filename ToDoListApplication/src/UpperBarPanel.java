import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
/*
 * PANEL FOR HOLDING THE OPTIONBUTTONPANEL AND EXIT PROGRAM BUTTON
 * */
public class UpperBarPanel extends JPanel {
	UpperBarPanel(ApplicationWindow appWindow, SwitchablePanel switchPanel){
		setLayout(new BorderLayout());
		
		
		
		if(appWindow.userOS.contains("win")) {
			setPreferredSize(new Dimension(appWindow.getWidth(),appWindow.getHeight() / 32));
		}
		
		setBackground(new Color(37,51,71));
		
		//ADD BUTTONS
		add(new OptionButtonPanel(switchPanel), BorderLayout.WEST);
		add(new CloseApplicationWindowButton(appWindow), BorderLayout.EAST);
		
		
	}
}
