package umm3601.todo;
import java.util.Comparator;

public class CompareBody implements Comparator<Todo> {
  public int compare(Todo todo1, Todo todo2){
    if(todo1.body == null || todo2.body == null){
      return 0;
    }
    return todo1.body.compareTo(todo2.body);
  }
}
