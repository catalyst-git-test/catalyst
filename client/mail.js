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
      "args":{"case":"testCase36","name":name}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000556017); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   functionPromise
      .then((response) => {
          response.json().then(responseBody => {
            if(responseBody.value!="exception"){
            hideLoader();
              table.rows[1].cells[2].innerHTML=responseBody.message;
              document.getElementById("row1").style.color='green';
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
        "args":{"case":"testCase37","name":name}
     };
     var functions = catalyst.function;
     var functionObject = functions.functionId(1926000000556017); //can pass Function Id or Function Name as argument
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
              ajaxCall3();
  }
  else{
    hideLoader();
    table.rows[2].cells[2].innerHTML=responseBody.message;
    document.getElementById("row2").style.color='red';
    ajaxCall3();
  }
  });
  })
  .catch((err) => {
  hideLoader();
  console.log(err.error);
  table.rows[2].cells[2].innerHTML=responseBody.message;
  document.getElementById("row2").style.color='red';
  ajaxCall3();
  });
    }
    function ajaxCall3()
    {
      var name = document.getElementById("fname").innerHTML;
      var table=document.getElementById("data_table");
      var config = {
          "method":"POST",
          "args":{"case":"testCase38","name":name}
       };
       var functions = catalyst.function;
       var functionObject = functions.functionId(1926000000556017); //can pass Function Id or Function Name as argument
       var functionPromise = functionObject.execute(config);
       functionPromise
          .then((response) => {
              response.json().then(responseBody => {
                if(responseBody.value!="exception"){
                hideLoader();
                if(responseBody.flag==false){
                  table.rows[3].cells[2].innerHTML=responseBody.message;
                  document.getElementById("row3").style.color='green';}
                  else{
                    table.rows[3].cells[2].innerHTML=responseBody.message;
                    document.getElementById("row3").style.color='red';
                  }
            //    ajaxCall4();
    }
    else{
      hideLoader();
      table.rows[3].cells[2].innerHTML=responseBody.message;
      document.getElementById("row3").style.color='red';
  //    ajaxCall4();
    }
    });
    })
    .catch((err) => {
    hideLoader();
    console.log(err.error);
    table.rows[3].cells[2].innerHTML=responseBody.message;
    document.getElementById("row3").style.color='red';
  //  ajaxCall4();
    });
      }
