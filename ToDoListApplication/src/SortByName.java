import java.util.Comparator;
public class SortByName implements Comparator<ToDoItemPanel>{

	@Override
	public int compare(ToDoItemPanel o1, ToDoItemPanel o2) {
		
		return Character.compare(o1.getName().charAt(0),o2.getName().charAt(0));
	}

}
