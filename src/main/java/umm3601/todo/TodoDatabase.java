package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;


public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException{
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader,Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    //Limit the amount of To-Dos shown
    if(queryParams.containsKey("limit")){
      int targetLimit = Integer.parseInt(queryParams.get("limit")[0]);
      // pass filteredTodo array and an integer,targetLimit, to method limitTodo method below and set filteredTodo to the new array returned
      filteredTodos = limitTodo(filteredTodos,targetLimit);
    }

    return filteredTodos;
  }

    //Receives an array from listTodo, set a max length for it as determined by targetLimit and returns a new array
  public Todo[] limitTodo(Todo[] todos, int targetLimit){
    return Arrays.stream(todos).limit(targetLimit).toArray(Todo[]::new);
  }


}
