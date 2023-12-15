import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;


public class ShowToDoItemPanel extends BasicPanel{
	
	private ToDoList toDoList = new ToDoList();
	private JLabel dummy = new JLabel("Show panel");
	
	ShowToDoItemPanel(){
		LocalToDoItemHandler lToDoItemHandler = new LocalToDoItemHandler();
		GridLayout gridLayout = new GridLayout(40,2,25,25);
		setLayout(gridLayout);
		add(dummy);
		lToDoItemHandler.getToDoItems(dummy,toDoList);
		if(!toDoList.isEmpty()) {
			lToDoItemHandler.addToDoItemPanels(toDoList,this);
			System.out.println(toDoList.get(1).getStatus());
		}
		
	}
	
	
	// gets the to do items from the local csv and adds them to the toDoList
	
	
	
	
}
