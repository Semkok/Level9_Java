import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * A PANEL THAT DISPLAYS THE CONTENTS OF ONE TODOITEM
 * */
public class ToDoItemPanel extends JPanel{
	
	
	
	
	JRadioButton radioButton = new JRadioButton();
	LocalToDoItemHandler lHandler;
	ToDoList toDoList;
	ToDoItem toDoItem;
	ArrayList<ToDoItem>toBeRemovedItems;
	
	ToDoItemPanel(ToDoItem toDoItem, ToDoList toDoList,LocalToDoItemHandler lHandler, ArrayList<ToDoItem>toBeRemovedItems){
		this.toDoItem = toDoItem;
		this.toDoList = toDoList;
		this.lHandler = lHandler;
		this.toBeRemovedItems = toBeRemovedItems;
		
		
		
		JRadioButton statusButton = new JRadioButton();
		add(new JLabel("" +toDoItem.getId()));
		setPreferredSize(new Dimension(400,300));
		add(new EditNameField());
		setVisible(true);
		add(new RemoveItemCheckBox());
		add(new ToggleStatus());
		
	}
	
	private class EditNameField extends JTextField implements ActionListener{
		EditNameField(){
			setText(toDoItem.getName());
			addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.editToDoItem(toDoList,toDoItem,this.getText());
		}
		
	}
	
	private class ToggleStatus extends JCheckBox implements ActionListener{
		ToggleStatus(){
			addActionListener(this);
			if(toDoItem.getStatus()) {
				setSelected(true);
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.editToDoItem(toDoList,toDoItem,toDoItem.getStatus());
		}
		
	}
	
	// THE CHECKBOX FOR THE TODOITEM REMOVAL
	private class RemoveItemCheckBox extends JCheckBox implements ActionListener{
		RemoveItemCheckBox(){
			addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(this.isSelected()) {
				toBeRemovedItems.add(toDoItem);
			}
			else{ // if the item is unselected it will remove it from the toberemoved item arraylist
				toBeRemovedItems.remove(toDoItem);
			}
			
			
		}
		
	}
	
	
	public String getName() {
		return toDoItem.getName();
	}
	
	public Boolean getStatus() {
		return toDoItem.getStatus();
	}
	
}
