
function getAllTodos() {
  console.log("Getting all the todos");

  var httpClient = new HttpClient();
  httpClient.get("/api/todo", function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = JSON.stringify(returned_json, null, 1);
  });
}

function getLimit(){
  console.log("Master function");

  var httpClient = new HttpClient();
  var URL = "/api/todo?";
  var limit = document.getElementById("limit").value;

  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

  console.log("Master URL is:" + URL);

  httpClient.get(URL,function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });

}

function getCompleteTodos() {
  console.log("Filtering out the incomplete todos");

  var httpClient = new HttpClient();
  var URL = "/api/todo?";
  var limit = document.getElementById("limit").value;
  var status = document.getElementById("complete").value;


  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

  URL = URL + "status=" + status + "&";

  console.log("The complete URL is:" + URL);

  httpClient.get(URL,function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });
}

function getIncompleteTodos() {
  console.log("Filtering out the complete todos");

  var httpClient = new HttpClient();
  var URL = "/api/todo?";
  var limit = document.getElementById("limit").value;
  var status = document.getElementById("incomplete").value;


  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

  URL = URL + "status=" + status + "&";

  console.log("The incomplete URL is:" + URL);

  httpClient.get(URL,function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });
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
