import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;


public class ShowToDoItemPanel extends BasicPanel{
	
	private ToDoList toDoList = new ToDoList();
	private JLabel dummy = new JLabel("Show panel");
	
	ShowToDoItemPanel(){
		
		add(dummy);
		getToDoItems();
		
		if(!toDoList.isEmpty()) {
			addToDoItemPanels();
			System.out.println(toDoList.get(1).getStatus());
		}
		
	}
	
	
	// gets the to do items from the local csv and adds them to the toDoList
	private void getToDoItems() {
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
		 		dummy.setText("The file was not found");
		 	}
		 
		 	
		 	catch (IOException e) {
	            e.printStackTrace(); 
	        }
	}
	
	private void addToDoItemPanels() {
		ToDoItemPanel[] toDoItemPanels = new ToDoItemPanel[toDoList.size()];
		for(int i =0; i < toDoList.size(); i++) {
			toDoItemPanels[i] = new ToDoItemPanel(toDoList.get(i).getName());
			toDoItemPanels[i].setVisible(true);
			add(toDoItemPanels[i]);
		}
	}
	
}
