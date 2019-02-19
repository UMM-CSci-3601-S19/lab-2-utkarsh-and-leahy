package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterTodoByCategory {

  @Test
  public void filterTodoByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todosGroceries = db.findCategory(allTodos, "groceries");
    assertEquals("Incorrect Amount of Grocery Todos", 76, todosGroceries.length);

    Todo[] todosHomework = db.findCategory(allTodos, "homework");
    assertEquals("Incorrect Amount of Homework Todos", 79, todosHomework.length);
  }
}
