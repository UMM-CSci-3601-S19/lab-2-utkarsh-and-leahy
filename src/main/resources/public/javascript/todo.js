function getAllTodos() {
  console.log("Getting all the todos");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function (returned_json) {
    document.getElementById('jsonDumpTodo').innerHTML = returned_json;
  });
}
