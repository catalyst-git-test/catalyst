function runCases()
{
  var but=document.getElementById("rundatastore");
  but.style.display = "none";
  showLoader();
  ajaxCall1();
}
function showLoader()
{
  var x = document.getElementById("loader");
  x.style.display="block";
}
function hideLoader()
{
  var x = document.getElementById("loader");
  x.style.display="none";
  catalyst.auth.isUserAuthenticated().then(result => {
        var first_name = "First Name: " + result.content.first_name;
        document.getElementById("fname").innerHTML = first_name;
}).catch(err => {
    });
}
function ajaxCall1()
{
  var name = document.getElementById("fname").innerHTML;
  var table=document.getElementById("data_table");
  var config = {
      "method":"POST",
      "args":{"case":"testCase34","name":name}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000460037); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   functionPromise
      .then((response) => {
          response.json().then(responseBody => {
            if(responseBody.value!="exception"){
            hideLoader();
            if(responseBody.flag==true){
              table.rows[1].cells[2].innerHTML=responseBody.message;
              document.getElementById("row1").style.color='red';
            }
            else{
              table.rows[1].cells[2].innerHTML=responseBody.message;
              document.getElementById("row1").style.color='green';
            }
            ajaxCall2();
}
else{
  hideLoader();
  table.rows[1].cells[2].innerHTML=responseBody.message;
  document.getElementById("row1").style.color='red';
  ajaxCall2();
}
});
})
.catch((err) => {
hideLoader();
console.log(err.error);
table.rows[1].cells[2].innerHTML=responseBody.message;
document.getElementById("row1").style.color='red';
ajaxCall2();
});
  }
  function ajaxCall2()
  {
    var name = document.getElementById("fname").innerHTML;
    var table=document.getElementById("data_table");
    var config = {
        "method":"POST",
        "args":{"case":"testCase35","name":name}
     };
     var functions = catalyst.function;
     var functionObject = functions.functionId(1926000000460037); //can pass Function Id or Function Name as argument
     var functionPromise = functionObject.execute(config);
     functionPromise
        .then((response) => {
            response.json().then(responseBody => {
              if(responseBody.value!="exception"){
              hideLoader();
              if(responseBody.flag==true){
                table.rows[2].cells[2].innerHTML=responseBody.message;
                document.getElementById("row2").style.color='red';
              }
              else{
                table.rows[2].cells[2].innerHTML=responseBody.message;
                document.getElementById("row2").style.color='green';
              }
              countCalculation();
  }
  else{
    hideLoader();
    table.rows[2].cells[2].innerHTML=responseBody.message;
    document.getElementById("row2").style.color='red';
    countCalculation();
  }
  });
  })
  .catch((err) => {
  hideLoader();
  console.log(err);
  table.rows[2].cells[2].innerHTML=responseBody.message;
  document.getElementById("row2").style.color='red';
  countCalculation();
  });
    }
    function countCalculation(){
      var value="";
      var failCount=0;
      var table = document.getElementById("cases_table");
      for (var i = 1;i<=2;i++) {
        value="row"+i;
        console.log(value);
        if(document.getElementById(value).style.color=='red'){
          failCount+=1;
        }
       }
       document.getElementById("count").innerHTML="<br><br>Total number of failures - "+failCount;
    }
