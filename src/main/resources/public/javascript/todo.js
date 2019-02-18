
function getAllTodos() {
  console.log("Getting all the todos");

  var httpClient = new HttpClient();
  httpClient.get("/api/todo", function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });
}

function getTodosByLimit() {
  console.log("Getting the specified amount of todos.");

  var httpClient = new HttpClient();
  httpClient.get("/api/todo?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });
}

function getAllCompleteTodos() {
  console.log("Filtering out the incomplete todos")

  /*var httpClient = new HttpClient();
  httpClient.get("/api/todo?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });*/
}

function getAllIncompleteTodos() {
  console.log("Filtering out the complete todos")

  /*var httpClient = new HttpClient();
  httpClient.get("/api/todo?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });*/
}

function HttpClient() {
  this.get = function (aUrl, aCallback) {
    var anHttpRequest = new XMLHttpRequest();

    anHttpRequest.onreadystatechange = function () {

      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
