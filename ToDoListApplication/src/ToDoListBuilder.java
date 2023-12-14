import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ToDoListBuilder {
	private ToDoList toDoList = new ToDoList();
	
	public ToDoList getToDoList() {
		return this.toDoList;
	}
	
	public void addToDoItem(ToDoItem toDoItem) {
		this.toDoList.add(toDoItem);
	}
	
	// stores the data received as an csv file
	public void storeToDoListLocally() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("LocalToDoItems.csv"))) {
            for (ToDoItem item : toDoList) {
                writer.println(item.getId() + "," + item.getName() + "," + item.getStatus());
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }
	
	
}
