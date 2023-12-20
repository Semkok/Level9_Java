import java.util.Comparator;
public class SortByName implements Comparator<ToDoItemPanel>{

	@Override
	public int compare(ToDoItemPanel o1, ToDoItemPanel o2) {
		
		return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()); // to lowercase for also sorting the capital characters
	}

}
