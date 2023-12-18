/*
* CLASS FOR DESCRIBING A TODOITEM  
*/
public class ToDoItem {
	private String name;
	private boolean status;
	private int id;
	
	ToDoItem(String name, boolean status, int id){
		this.name = name;
		this.status = status;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
}
