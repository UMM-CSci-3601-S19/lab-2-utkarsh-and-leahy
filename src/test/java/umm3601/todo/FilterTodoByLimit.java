package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodoByLimit {

  @Test
  public void filterTodoByLimit() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] limit5Todos = db.limitTodo(allTodos, 5);
    assertEquals("Incorrect number of todos with limit 5", 5, limit5Todos.length);

    Todo[] limit10Todos = db.limitTodo(allTodos, 10);
    assertEquals("Incorrect number of todos with limit 10", 10, limit10Todos.length);
  }

}
