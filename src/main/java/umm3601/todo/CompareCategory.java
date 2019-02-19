package umm3601.todo;
import java.util.Comparator;

public class CompareCategory implements Comparator<Todo> {
  public int compare(Todo todo1, Todo todo2){
    if(todo1.category == null || todo2.category == null){
      return 0;
    }
    return todo1.category.compareTo(todo2.category);
  }
}
