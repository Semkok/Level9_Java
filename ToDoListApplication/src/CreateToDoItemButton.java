import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/*
 * BUTTON FOR GOING TO THE CREATE ITEM PANEL
 * */
public class CreateToDoItemButton extends JButton implements ActionListener {
	
	ScreenHandler screenHandler;
	
	CreateToDoItemButton(SwitchablePanel switchPanel, ScreenHandler screenHandler){
		setText("Create item");
		this.screenHandler = screenHandler;
		addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		screenHandler.setNewPanel(new CreateToDoItemPanel());
	}
}
