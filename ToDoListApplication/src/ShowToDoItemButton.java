import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class ShowToDoItemButton extends JButton {
	
	ScreenHandler screenHandler;
	
	
	ShowToDoItemButton(SwitchablePanel switchPanel, ScreenHandler screenHandler){
		setText("Show items");
		this.screenHandler = screenHandler;
		addActionListener(new ButtonAction());
	}
	
	
	private class ButtonAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			screenHandler.setNewPanel(new ShowToDoItemPanel());
			
		}
		
	}
}
