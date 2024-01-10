import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.*;

import java.awt.Color;


/*
 * A PANEL THAT DISPLAYS THE CONTENTS OF ONE TODOITEM
 * */
public class ToDoItemPanel extends JPanel{
	
	
	
	
	private JRadioButton radioButton = new JRadioButton();
	private LocalToDoItemHandler lHandler;
	private ToDoList toDoList;
	private ToDoItem toDoItem;
	private ArrayList<ToDoItem> toBeRemovedItems;
	
	private Color stickynoteColor =  new Color(255,247,64);
	private Border stickynoteBorder = BorderFactory.createLineBorder(Color.BLACK, 2);
	private Font stickynoteFont = new Font("Comic Sans MS", Font.PLAIN, 24);
	
	
	ToDoItemPanel(ToDoItem toDoItem, ToDoList toDoList,LocalToDoItemHandler lHandler, ArrayList<ToDoItem>toBeRemovedItems){
		    this.toDoItem = toDoItem;
	        this.toDoList = toDoList;
	        this.lHandler = lHandler;
	        this.toBeRemovedItems = toBeRemovedItems;

	        // Set BorderLayout for the ToDoItemPanel
	        setLayout(new BorderLayout());
	        setPreferredSize(new Dimension(400, 300));
	        setBackground(stickynoteColor);  // Color for stickynote
	        setBorder(stickynoteBorder);

	        // Add EditNameField to the NORTH position of the panel
	        add(new EditNameField(), BorderLayout.NORTH);
	        add(new StickyNoteBody());
		
	}
	
	public String getName() {
		return toDoItem.getName();
	}
	
	public Boolean getStatus() {
		return toDoItem.getStatus();
	}
	
	private class EditNameField extends JTextField implements ActionListener{
		EditNameField(){
			setBackground(stickynoteColor);
			setText(toDoItem.getName());
			setFont(stickynoteFont);
			setBorder(stickynoteBorder);
			setPreferredSize(new Dimension(400,100));
			setHorizontalAlignment(JTextField.CENTER);  // Set text alignment to center
			addActionListener(this);
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			lHandler.editToDoItem(toDoList,toDoItem,this.getText());
		}
	}
	
	private class StickyNoteBody extends JPanel{
		StickyNoteBody(){
			setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			setBackground(stickynoteColor);
			setPreferredSize(new Dimension(400,300));
			
			
			GroupHorizontalPanel[] groupHorizontalPanel = new GroupHorizontalPanel[3];
			for(int i = 0; i < 3; i++) {
				groupHorizontalPanel[i] = new GroupHorizontalPanel();
			}
			groupHorizontalPanel[0].add(new LabelComicSans("ID: " + toDoItem.getId()));
			groupHorizontalPanel[1].add(new LabelComicSans("Remove item: "));
			groupHorizontalPanel[1].add(new RemoveItemCheckBox());
			groupHorizontalPanel[2].add(new LabelComicSans("Toggle status: "));
			groupHorizontalPanel[2].add(new ToggleStatus());
	        for(JPanel gHP : groupHorizontalPanel) {
				add(gHP);
			}
		}
	}
	
	
	private class GroupHorizontalPanel extends JPanel{
		GroupHorizontalPanel(){
			setLayout(new FlowLayout());
			setBackground(new Color(255,247,64));
			
			
			
		}
	}
	
	private class LabelComicSans extends JLabel {
		LabelComicSans(String text){
			setText(text);
			setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		}
		
	}
	
	
	
	private class ToggleStatus extends JCheckBox implements ActionListener{
		ToggleStatus(){
			addActionListener(this);
			if(toDoItem.getStatus()) {
				setSelected(true);
				setBackground(Color.GREEN);
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
	
	
}
