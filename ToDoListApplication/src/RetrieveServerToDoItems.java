import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RetrieveServerToDoItems extends JButton {
	RetrieveServerToDoItems(){
		setText("Retrieve Server Items");
		addActionListener(new GetConnection());
	}
	
	
	private class GetConnection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ServerConnection serverConnection = new ServerConnection();
		}
		
	}
}
