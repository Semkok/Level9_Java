import java.awt.GridLayout;
import javax.swing.JLabel;
/*
 * PANEL THAT DISPLAYS THE TODOITEMS
 * */
public class ShowToDoItemPanel extends BasicPanel{
	
	private ToDoList toDoList = new ToDoList();
	private JLabel dummy = new JLabel("Show panel");
	
	ShowToDoItemPanel(){
		LocalToDoItemHandler lToDoItemHandler = new LocalToDoItemHandler();
		GridLayout gridLayout = new GridLayout(5,4,25,25);
		
		setLayout(gridLayout);
		
		lToDoItemHandler.getToDoItems(toDoList); // reads the toDoItemList from CSV and fills the toDoList with its conetents
		
		if(!toDoList.isEmpty()) {
			lToDoItemHandler.addToDoItemPanels(toDoList,this);
		}
		
	}
	
}
