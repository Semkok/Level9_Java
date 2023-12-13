import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class UpperBarPanel extends JPanel {
	UpperBarPanel(ApplicationWindow appWindow, SwitchablePanel switchPanel){
		setLayout(new BorderLayout());
		setBackground(new Color(37,51,71));
		
		//ADD BUTTONS
		add(new OptionButtonPanel(switchPanel), BorderLayout.WEST);
		add(new CloseApplicationWindowButton(appWindow), BorderLayout.EAST);
		
		
	}
}
