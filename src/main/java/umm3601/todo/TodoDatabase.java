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

    //Filter by status. Parses the string attached to status(which should be "true" or "false") as a boolean and calls
    // appropriate method below
    if(queryParams.containsKey("status")){
      String statusString = queryParams.get("status")[0];
      if(statusString.equals("complete")) {
        filteredTodos = completeTodo(filteredTodos);
      } else if(statusString.equals("incomplete")){
        filteredTodos = incompleteTodo(filteredTodos);
      }
    }


    return filteredTodos;
  }

    //Receives an array from listTodo, set a max length for it as determined by targetLimit and returns a new array
  public Todo[] limitTodo(Todo[] todos, int targetLimit){
    return Arrays.stream(todos).limit(targetLimit).toArray(Todo[]::new);
  }

  //Receives an array from the listTodos function and uses filter to find entries where status is true and returns those as a new array
  public Todo[] completeTodo(Todo[] todos){
    return Arrays.stream(todos).filter(x -> x.status == true).toArray(Todo[]::new);
  }
  //Receives an array from the listTodos function and uses filter to find entries where status is false and returns those as a new array
  public Todo[] incompleteTodo(Todo[] todos){
    return Arrays.stream(todos).filter(x -> x.status == false).toArray(Todo[]::new);
  }

}
