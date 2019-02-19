package umm3601.todo;

import org.junit.Test;
import umm3601.user.User;
import umm3601.user.UserDatabase;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodoByOwner {

  @Test
  public void filterTodoByOwner() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] todosBlanche = db.findOwner(allTodos, "Blanche");
    assertEquals("Incorrect Amount With Owner Name", 43, todosBlanche.length);

    Todo[] todosFry = db.findOwner(allTodos, "Fry");
    assertEquals("Incorrect Amount With Owner Name", 61, todosFry.length);
  }
}
