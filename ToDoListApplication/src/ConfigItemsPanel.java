import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ConfigItemsPanel extends JPanel {
	ArrayList<ToDoItem> toBeRemovedItems; // the items that are selected to be removed
	ToDoList toDoList; // the list from where the items need to be removed
	LocalToDoItemHandler lHandler;
	ArrayList<ToDoItemPanel> toDoItemPanels;
	
	ConfigItemsPanel(ArrayList<ToDoItem> toBeRemovedItems, ToDoList toDoList, LocalToDoItemHandler lHandler, ArrayList<ToDoItemPanel> toDoItemPanels){
		this.toBeRemovedItems = toBeRemovedItems;
		this.toDoList = toDoList;
		this.lHandler = lHandler;
		this.toDoItemPanels = toDoItemPanels;
		setVisible(true);
		add(new RemoveItemsButton());
		add(new SortItemsByNameButton());
		add(new SortItemsByStatusButton());
	}
	
	private class RemoveItemsButton extends JButton implements ActionListener{
		
		RemoveItemsButton(){
			super("Delete selected items");
			addActionListener(this);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.removeToDoItems(toDoList);
		}
		
	}
	
	private class SortItemsByNameButton extends JButton implements ActionListener{
		
		SortItemsByNameButton(){
			super("Sort by a-z");
			addActionListener(this);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.filterByName(toDoList);
		}
		
	}
	
	private class SortItemsByStatusButton extends JButton implements ActionListener{
		
		SortItemsByStatusButton(){
			super("Sort by status");
			addActionListener(this);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.filterByStatus(toDoList);
		}
		
	}
}
