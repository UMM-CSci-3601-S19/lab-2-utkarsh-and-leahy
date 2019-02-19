
function getAllTodos() {
  console.log("Getting all the todos");

  var httpClient = new HttpClient();
  httpClient.get("/api/todo", function (returned_json) {
    document.getElementById('jsonDumpTodos').innerHTML = returned_json;
  });
}

function getEverything(){
  console.log("Master function");

  var httpClient = new HttpClient();
  var URL = "/api/todo?";
  var limit = document.getElementById("limit").value;
  var wordSearch = document.getElementById("wordSearch").value;
  var owner = document.getElementById("owner").value;
  var category = document.getElementById("category").value;
  var sortBy = document.getElementById("sortBy").value;

  if (owner !== "") {
    URL = URL + "owner=" + owner + "&"
  }


  if (category !== "") {
    URL = URL + "category=" + category + "&"
  }

  if(wordSearch !== ""){
    URL = URL + "contains=" + wordSearch + "&";
  }

  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

  if(sortBy !== "") {
    URL = URL + "orderBy=" + sortBy + "&";
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
  var wordSearch = document.getElementById("wordSearch").value;
  var owner = document.getElementById("owner").value;
  var category = document.getElementById("category").value;




  if (owner !== "") {
    URL = URL + "owner=" + owner + "&"
  }

  if (category !== "") {
    URL = URL + "category=" + category + "&"
  }

  if(wordSearch !== ""){
    URL = URL + "contains=" + wordSearch + "&";
  }

  URL = URL + "status=" + status + "&";

  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

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
  var wordSearch = document.getElementById("wordSearch").value;
  var owner = document.getElementById("owner").value;
  var category = document.getElementById("category").value;


  if (owner !== "") {
    URL = URL + "owner=" + owner + "&"
  }


  if (category !== "") {
    URL = URL + "category=" + category + "&"
  }

  if(wordSearch !== ""){
    URL = URL + "contains=" + wordSearch + "&";
  }

  URL = URL + "status=" + status + "&";

  if(limit !== ""){
    URL = URL + "limit=" + limit + "&";
  }

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
