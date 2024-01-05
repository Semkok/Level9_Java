import java.awt.GridLayout;
/*
 * PANEL THAT DISPLAYS THE TODOITEMS
 * */
public class ShowToDoItemPanel extends BasicPanel{
	
	private ToDoList toDoList = new ToDoList();
	
	ShowToDoItemPanel(){
		LocalToDoItemHandler lToDoItemHandler = new LocalToDoItemHandler();
		GridLayout gridLayout = new GridLayout(20,4,25,25);
		
		setLayout(gridLayout);
		
		lToDoItemHandler.getToDoItems(toDoList); // reads the toDoItemList from CSV and fills the toDoList with its contents
		
		if(!toDoList.isEmpty()) {
			lToDoItemHandler.addToDoItemPanels(toDoList,this);
		}
		
	}
	
}
