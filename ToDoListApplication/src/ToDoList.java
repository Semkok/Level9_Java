import java.util.ArrayList;

public class ToDoList extends ArrayList<ToDoItem>{
	
	public ToDoItem getToDoItem(int index) {
		return this.get(index);
	}
	
	public void addToDoItem(ToDoItem toDoItem) {
		this.add(toDoItem);
	}

}
