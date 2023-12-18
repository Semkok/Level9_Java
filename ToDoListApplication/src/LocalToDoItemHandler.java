import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;

import javax.swing.JLabel;

/*
 * CLASS FOR EDITING THE CSV FILE WICH STORES THE LOCAL PROCCESED TODOITEMS FROM THE DATABASE
 * */

public class LocalToDoItemHandler {
	
	
	BasicPanel basicPanel;
	
	private String filePath = "LocalToDoItems.csv";
	
	
	// reads the file and fills the toDoList with the toDoItems in the CSV
	public void getToDoItems(JLabel label, ToDoList toDoList) {
		
		 try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                // Split the line into fields using a comma
	                String[] fields = line.split(",");
	                int id = Integer.parseInt(fields[0].trim());
	                String name = fields[1].trim();
	                boolean status = Boolean.parseBoolean(fields[2].trim());
	                ToDoItem toDoItem = new ToDoItem(name,status, id);
	                toDoList.add(toDoItem);
	            }
	        }
		 		
		 	catch(FileNotFoundException e) {
		 		label.setText("The file was not found");
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
	
	public void removeToDoItem(ToDoList toDoList, ToDoItem toDoItem) {
		toDoList.remove(toDoItem);
		updateNewCSV(toDoList); //  makes a new csv file with the contents of the new 
	}
	
	public void refreshPanelWithNewValues() {
		this.basicPanel.removeAll();
		this.basicPanel.repaint();
		this.basicPanel.revalidate();
	}
	
	private void updateNewCSV(ToDoList toDoList) {
		ToDoListBuilder toDoListBuilder = new ToDoListBuilder();
		toDoListBuilder.setToDoList(toDoList); // adds the new values with the new toDoList
		toDoListBuilder.storeToDoListLocally();
		refreshPanelWithNewValues();
		addToDoItemPanels(toDoList,this.basicPanel);
	}
	
	public void editToDoItem(ToDoList toDoList, ToDoItem toDoItem, String newName) {
		toDoList.remove(toDoItem);
		toDoItem.setName(newName);
		toDoList.add(toDoItem);
		updateNewCSV(toDoList); //  makes a new csv file with the contents of the new 
	}

	public void editToDoItem(ToDoList toDoList, ToDoItem toDoItem, int newId) {
		
	}
	
	public void editToDoItem(ToDoList toDoList, ToDoItem toDoItem, boolean newStatus) {
		
	}
	
	
	
	// adds a panel to the panel for with the toDoItem
	public void addToDoItemPanels(ToDoList toDoList, BasicPanel basicPanel) {
		this.basicPanel = basicPanel;
		ArrayList<ToDoItemPanel> toDoItemPanels = new ArrayList<ToDoItemPanel>();
		for(int i =0; i < toDoList.size(); i++) {
			toDoItemPanels.add(i, new ToDoItemPanel(toDoList.get(i), toDoList,this));
			basicPanel.add(toDoItemPanels.get(i));
		}
	}
}
