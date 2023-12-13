import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
			screenHandler.setNewPanel(new EditToDoItemPanel());
		}
		
	}
}
