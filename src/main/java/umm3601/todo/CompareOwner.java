package umm3601.todo;
import java.util.Comparator;

public class CompareOwner implements Comparator<Todo> {
  public int compare(Todo todo1, Todo todo2){
    if(todo1.owner == null || todo2.owner == null){
      return 0;
    }
    return todo1.owner.compareTo(todo2.owner);
  }
}
