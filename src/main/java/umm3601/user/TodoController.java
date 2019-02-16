package umm3601.user;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import java.io.IOException;

import static umm3601.Util.*;

public class TodoController {

  private final Gson gson;
  private Database database;

  public TodoController(Database database){
    gson = new Gson();
    this.database = database;
  }

  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = database.getTodo(id);
    if(todo != null){
      return buildSuccessJsonResponse("todo",gson.toJsonTree(todo));
    } else {
      String message = "There are no Todo with ID " + id;
      return buildFailJsonResponse("id", message);
    }
  }

  public JsonObject getTodos(Request req,Response res) {
    res.type("application/json");
    Todo[] todos = database.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todo",gson.toJsonTree(todos));
  }

}
