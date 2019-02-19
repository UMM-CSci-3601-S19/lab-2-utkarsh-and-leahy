package umm3601.todo;
import java.util.Comparator;

public class CompareStatus implements Comparator<Todo> {
  public int compare(Todo todo1, Todo todo2){
    if(todo1.status == null || todo2.status == null){
      return 0;
    }
    return todo1.status.compareTo(todo2.status);
  }
}

