import java.awt.Color;

import javax.swing.JPanel;

public class OptionButtonPanel extends JPanel {
	
	OptionButtonPanel(SwitchablePanel switchPanel){
		ScreenHandler screenHandler = new ScreenHandler(switchPanel);
		setBackground(new Color(37,51,71));
		add(new ShowToDoItemButton(switchPanel,screenHandler));
		add(new CreateToDoItemButton(switchPanel,screenHandler));
		add(new RemoveToDoItemButton(switchPanel,screenHandler));
		add(new EditToDoItemButton(switchPanel,screenHandler));
		add(new SaveButton());
		add(new RetrieveServerToDoItems());
		
	}
}
