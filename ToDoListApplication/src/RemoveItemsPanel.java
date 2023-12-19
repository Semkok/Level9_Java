import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RemoveItemsPanel extends JPanel {
	ArrayList<ToDoItem> toBeRemovedItems; // the items that are selected to be removed
	ToDoList toDoList; // the list from where the items need to be removed
	LocalToDoItemHandler lHandler;
	RemoveItemsPanel(ArrayList<ToDoItem> toBeRemovedItems, ToDoList toDoList, LocalToDoItemHandler lHandler){
		this.toBeRemovedItems = toBeRemovedItems;
		this.toDoList = toDoList;
		this.lHandler = lHandler;
		setVisible(true);
		add(new RemoveItemsButton());
	}
	
	private class RemoveItemsButton extends JButton implements ActionListener{
		
		RemoveItemsButton(){
			addActionListener(this);
			setText("Delete selected items");
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.removeToDoItems(toDoList);
		}
		
	}
}
