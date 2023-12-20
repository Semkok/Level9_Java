import java.util.Comparator;
public class SortByStatusASC implements Comparator<ToDoItemPanel>{

	@Override
	public int compare(ToDoItemPanel o1, ToDoItemPanel o2) {
		return Boolean.compare(o1.getStatus(), o2.getStatus()); // Ascending sorts from false to true 
	}

}
