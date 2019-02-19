package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterByBody {

  @Test
  public void filterTodoByBody() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todosEst = db.findStringInTodo(allTodos, "est");
    assertEquals("Incorrect Amount With Matching Body", 80, todosEst.length);

    Todo[] todosTempor = db.findStringInTodo(allTodos, "tempor");
    assertEquals("Incorrect Amount With Matching Body", 68, todosTempor.length);
  }
}
