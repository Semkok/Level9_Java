import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
/*
 * BUTTON WHICH IS USED FOR MAKING A CONNECTION WITH THE SERVER
 * */
public class RetrieveServerToDoItems extends JButton {
	RetrieveServerToDoItems(){
		setText("Retrieve Server Items");
		addActionListener(new GetConnection());
	}
	
	
	private class GetConnection implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ServerConnection serverConnection = new ServerConnection();
			try {
				serverConnection.getValuesFromTable();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
}
