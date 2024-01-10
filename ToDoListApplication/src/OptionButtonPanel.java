import java.awt.Color;

import javax.swing.JPanel;
/*
 * PANEL WITH ALL THE BUTTONS FOR CRUD
 * */
public class OptionButtonPanel extends JPanel {
	
	OptionButtonPanel(SwitchablePanel switchPanel){
		ScreenHandler screenHandler = new ScreenHandler(switchPanel);
		setBackground(new Color(37,51,71));
		add(new ShowToDoItemButton(screenHandler));
		add(new CreateToDoItemButton(screenHandler));
		add(new SaveButton());
		add(new RetrieveServerToDoItems());
		
	}
}
