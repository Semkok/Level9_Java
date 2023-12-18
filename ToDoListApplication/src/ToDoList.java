import java.util.ArrayList;
/*
 * A LIST OF ALL TODOITEMS FOR GROUPING THE TODOITEMS
 * */
public class ToDoList extends ArrayList<ToDoItem>{
	
	public ToDoItem getToDoItem(int index) {
		return this.get(index);
	}
	
	public void addToDoItem(ToDoItem toDoItem) {
		this.add(toDoItem);
	}

}
