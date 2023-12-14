import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class UpperBarPanel extends JPanel {
	UpperBarPanel(ApplicationWindow appWindow, SwitchablePanel switchPanel){
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(appWindow.getWidth(),appWindow.getHeight() / 32));
		setBackground(new Color(37,51,71));
		
		//ADD BUTTONS
		add(new OptionButtonPanel(switchPanel), BorderLayout.WEST);
		add(new CloseApplicationWindowButton(appWindow), BorderLayout.EAST);
		
		
	}
}
