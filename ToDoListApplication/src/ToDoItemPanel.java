import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/*
 * A PANEL THAT DISPLAYS THE CONTENTS OF ONE TODOITEM
 * */
public class ToDoItemPanel extends JPanel implements ActionListener{
	
	private String name;
	private boolean status;
	private int id;
	
	JLabel jlabel = new JLabel();
	JRadioButton radioButton = new JRadioButton();
	LocalToDoItemHandler lHandler;
	ToDoList toDoList;
	ToDoItem toDoItem;
	
	ToDoItemPanel(ToDoItem toDoItem, ToDoList toDoList,LocalToDoItemHandler lHandler){
		this.toDoItem = toDoItem;
		this.toDoList = toDoList;
		this.lHandler = lHandler;
		
		String text = String.format("<html>%s<br>%b<br>%d</html>",this.toDoItem.getName(),this.toDoItem.getStatus(),this.toDoItem.getId());
		setPreferredSize(new Dimension(400,300));
		// every JPanel has a JRadiobutton for checking if the toDoItem is done
		radioButton.addActionListener(this);
		add(radioButton);
		jlabel.setText(text);
		add(jlabel);
		setVisible(true);
		
		//removing the jpanel
		RemoveItemButton removeButton = new RemoveItemButton();
		
		add(removeButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(radioButton.isSelected()) {
			status = true;
			String text = String.format("<html>%s<br>%b<br>%d</html>",this.name,this.status,this.id);
			jlabel.setText(text);
		}
		
		else {
			status = false;
			String text = String.format("<html>%s<br>%b<br>%d</html>",this.name,this.status,this.id);
			jlabel.setText(text);
		}
		
	}
	
	public void setValueInCSV() {
		
	}
	
	private class RemoveItemButton extends JButton implements ActionListener{
		RemoveItemButton(){
			addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			lHandler.removeToDoItem(toDoList,toDoItem);
			
		}
		
	}
	
}
