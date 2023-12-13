
public class ToDoListBuilder {
	private ToDoList toDoList = new ToDoList();
	
	public ToDoList getToDoList() {
		return this.toDoList;
	}
	
	public void addToDoItem(ToDoItem toDoItem) {
		this.toDoList.add(toDoItem);
	}
	
}
