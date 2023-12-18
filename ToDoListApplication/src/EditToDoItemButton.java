import java.awt.event.ActionEvent;
/*
 * BUTTON FOR GOING TO THE EDIT ITEM PANEL
 * */
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
public class EditToDoItemButton extends JButton {
	
	ScreenHandler screenHandler;
	
	EditToDoItemButton(SwitchablePanel switchPanel, ScreenHandler screenHandler){
		setText("Edit item");
		this.screenHandler = screenHandler;
		addActionListener(new ButtonAction());
	}
	
	private class ButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			screenHandler.setNewPanel(new JScrollPane(new EditToDoItemPanel()));
		}
		
	}
}
