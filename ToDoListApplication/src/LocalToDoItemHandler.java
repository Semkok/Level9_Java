import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * CLASS FOR EDITING THE CSV FILE WICH STORES THE LOCAL PROCCESED TODOITEMS FROM THE DATABASE
 * */

public class LocalToDoItemHandler {
	
	private BasicPanel basicPanel;
	
	private String filePath = "LocalToDoItems.csv";
	
	public ArrayList<ToDoItem> itemsToRemove = new ArrayList<ToDoItem>();
	
	private String filter = "";	// for holding the view its current filter 
	
	// reads the file and fills the toDoList with the toDoItems in the CSV
	public void getToDoItems(ToDoList toDoList) {
		 try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Split the line into fields using a comma
	            	line.trim();
	                String[] fields = line.split(",");
	                	toDoList.add(new ToDoItem(fields[1],Boolean.parseBoolean(fields[2]), Integer.parseInt(fields[0])));
	            }
	        }
		 	catch (IOException e) {
	            e.printStackTrace(); 
	        }
	}
	
	public void createToDoItem(String name, String iD) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath), true));
            // Write the new data to the file
            writer.write(iD + "," + name + "," + "false");
            writer.newLine(); // newline so the bufferedWriter starts on a new line the next time 
            writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeToDoItems(ToDoList toDoList) {
		for(ToDoItem toDoItem : itemsToRemove) {
			toDoList.remove(toDoItem);
		}
		
		updateNewCSV(toDoList); //  makes a new csv file with the contents of the new 
	}
	
	private void refreshPanel() {
		this.basicPanel.removeAll();
		this.basicPanel.repaint();
		this.basicPanel.revalidate();
	}
	
	public void filterByStatus(ToDoList toDoList) {
		refreshPanel();
		filter = "status";
		addToDoItemPanels(toDoList,this.basicPanel);
	}
	
	public void filterByName(ToDoList toDoList) {
		refreshPanel();
		filter = "name";
		addToDoItemPanels(toDoList,this.basicPanel);
	}
	
	private void updateNewCSV(ToDoList toDoList) {
		ToDoListBuilder toDoListBuilder = new ToDoListBuilder();
		toDoListBuilder.setToDoList(toDoList); // adds the new values with the new toDoList
		toDoListBuilder.storeToDoListLocally();
		refreshPanel();
		addToDoItemPanels(toDoList,this.basicPanel);
	}
	
	public void editToDoItem(ToDoList toDoList, ToDoItem toDoItem, String newName) {
		int indexOfOld = toDoList.indexOf(toDoItem);
		toDoList.remove(toDoItem);
		toDoItem.setName(newName);
		toDoList.add(indexOfOld,toDoItem); // lets the new editted toDoItem on the same old place in the arraylist 
		updateNewCSV(toDoList); // makes a new csv file with the contents of the new 
	}
	
	public void editToDoItem(ToDoList toDoList, ToDoItem toDoItem, boolean newStatus) {
		int indexOfOld = toDoList.indexOf(toDoItem);
		toDoList.remove(toDoItem);
		toDoItem.setStatus(!toDoItem.getStatus()); // flips the boolean
		toDoList.add(indexOfOld,toDoItem); // lets the new editted toDoItem on the same old place in the arraylist 
		updateNewCSV(toDoList); // makes a new csv file with the contents of the new one
	}
	
	// adds a panel to the panel for with the toDoItem
	public void addToDoItemPanels(ToDoList toDoList, BasicPanel basicPanel) {
		this.basicPanel = basicPanel;
		ArrayList<ToDoItemPanel> toDoItemPanels = new ArrayList<ToDoItemPanel>();
		
		for(int i =0; i < toDoList.size(); i++) {
			toDoItemPanels.add(new ToDoItemPanel(toDoList.get(i), toDoList,this,itemsToRemove));
		}
		
		ConfigItemsPanel configPanel = new ConfigItemsPanel(itemsToRemove,toDoList,this,toDoItemPanels);
		
		if(filter.equals("name")) {
			Collections.sort(toDoItemPanels, new SortByName());
		}
		
		else if(filter.equals("status")) {
			Collections.sort(toDoItemPanels, new SortByStatusASC());
		}
		else {
			Collections.reverse(toDoItemPanels); // revererse the arrya list so the newest added toDoItems will be shown first
		}
		
		basicPanel.add(configPanel);	
		
		for(ToDoItemPanel toDoItemPanel : toDoItemPanels) {
			basicPanel.add(toDoItemPanel);
		}
		
	}
}
