import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;

public class LocalToDoItemHandler {
	
	
	public void getToDoItems(JLabel label, ToDoList toDoList) {
		String filePath = "LocalToDoItems.csv";
		
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
	
	public void addToDoItemPanels(ToDoList toDoList, BasicPanel basicPanel) {
		ToDoItemPanel[] toDoItemPanels = new ToDoItemPanel[toDoList.size()];
		for(int i =0; i < toDoList.size(); i++) {
			toDoItemPanels[i] = new ToDoItemPanel(toDoList.get(i).getName(),toDoList.get(i).getStatus(),toDoList.get(i).getId());
			toDoItemPanels[i].setVisible(true);
			basicPanel.add(toDoItemPanels[i]);
		}
	}
}
