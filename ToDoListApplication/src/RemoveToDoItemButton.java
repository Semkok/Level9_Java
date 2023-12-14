import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
public class RemoveToDoItemButton extends JButton {
	
	ScreenHandler screenHandler;
	
	RemoveToDoItemButton(SwitchablePanel switchPanel, ScreenHandler screenHandler){
		setText("Remove Item");
		this.screenHandler = screenHandler;
		addActionListener(new ActionButton());
	}
	
	private class ActionButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			screenHandler.setNewPanel(new JScrollPane(new RemoveToDoItemPanel()));
		}
		
	}
	
}
