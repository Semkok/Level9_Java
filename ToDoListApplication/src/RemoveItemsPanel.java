import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RemoveItemsPanel extends JPanel {
	ArrayList<ToDoItem> toBeRemovedItems;
	
	
	RemoveItemsPanel(ArrayList<ToDoItem> toBeRemovedItems, ArrayList<ToDoItem> toDoList){
		setVisible(true);
		this.toBeRemovedItems = toBeRemovedItems;
	}
	
	
	private class RemoveItemsButton extends JButton implements ActionListener{
		
		RemoveItemsButton(){
			addActionListener(this);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
