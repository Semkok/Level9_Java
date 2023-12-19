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
	
	private String name;
	private boolean status;
	private int id;
	
	JLabel jlabel = new JLabel();
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
		
		String text = String.format("<html>%s<br>%b<br>%d</html>",this.toDoItem.getName(),this.toDoItem.getStatus(),this.toDoItem.getId());
		setPreferredSize(new Dimension(400,300));
		add(new EditNameField());
		jlabel.setText(text);
		add(jlabel);
		setVisible(true);
		
		//removing the jpanel
		RemoveItemButton removeButton = new RemoveItemButton();
		add(removeButton);
		
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
	
	private class RemoveItemButton extends JCheckBox implements ActionListener{
		RemoveItemButton(){
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
	
}
