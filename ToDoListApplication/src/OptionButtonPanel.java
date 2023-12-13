import java.awt.Color;

import javax.swing.JPanel;

public class OptionButtonPanel extends JPanel {
	
	OptionButtonPanel(){
		setBackground(new Color(37,51,71));
		add(new ShowToDoItemButton());
		add(new CreateToDoItemButton());
		add(new RemoveToDoItemButton());
		add(new EditToDoItemButton());
	}
}
