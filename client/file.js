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
  var name=document.getElementById("fname").innerHTML;
  var table=document.getElementById("data_table");
  var config = {
      "method":"POST",
      "args":{"case":"testCase28","name":name}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   functionPromise
      .then((response) => {
          response.json().then(responseBody => {
            if(responseBody.value!="exception"){
            var config = {
                "method":"GET",
                "args":{"case":"testCase28","name":name}
             };
             var functions = catalyst.function;
             var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
             var functionPromise = functionObject.execute(config);
             functionPromise
                .then((response) => {
                    response.json().then(responseBody => {
                      hideLoader();
                      console.log(responseBody);
                      if(responseBody.flag==true&&responseBody.value!="exception"){
                        console.log("if");
                        table.rows[1].cells[2].innerHTML=responseBody.alert+"<br>"+responseBody.message;
                        document.getElementById("row1").style.color='red';
                      }
                      else if(responseBody.flag==true&&responseBody.value=="exception"){
                        console.log("else if");
                        table.rows[1].cells[2].innerHTML=responseBody.message;
                        document.getElementById("row1").style.color='red';
                      }
                      else{
                        console.log(responseBody.value);
                        table.rows[1].cells[2].innerHTML=responseBody.message;
                        document.getElementById("row1").style.color='green';
                      }
                      ajaxCall2();
          });
      })
      .catch((err) => {
        hideLoader();
          console.log(err.error);
          table.rows[1].cells[2].innerHTML=responseBody.value;
          document.getElementById("row1").style.color='red';
          ajaxCall2();
      });
  }
  else{
    hideLoader();
    table.rows[1].cells[2].innerHTML=responseBody.message;
    document.getElementById("row1").style.color='red';
    ajaxCall2();
  }
})})
  .catch((err) => {
    hideLoader();
    console.log(err);
    table.rows[1].cells[2].innerHTML=err;
    document.getElementById("row1").style.color='red';
    ajaxCall2();
  });
}
function ajaxCall2()
{
  var table=document.getElementById("data_table");
  var config = {
      "method":"POST",
      "args":{"case":"testCase29","name":name}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
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
    var table=document.getElementById("data_table");
    var config = {
        "method":"POST",
        "args":{"case":"testCase30","name":name}
     };
     var functions = catalyst.function;
     var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
     var functionPromise = functionObject.execute(config);
     functionPromise
        .then((response) => {
            response.json().then(responseBody => {
              if(responseBody.value!="exception"){
              hideLoader();
                table.rows[3].cells[2].innerHTML=responseBody.message;
                document.getElementById("row3").style.color='green';
              ajaxCall4();
  }
  else{
    hideLoader();
    table.rows[3].cells[2].innerHTML=responseBody.message;
    document.getElementById("row3").style.color='red';
    ajaxCall4();
  }
  });
  })
  .catch((err) => {
  hideLoader();
  console.log(err.error);
  table.rows[3].cells[2].innerHTML=responseBody.message;
  document.getElementById("row3").style.color='red';
  ajaxCall4();
  });
    }
    function ajaxCall4()
    {
      var table=document.getElementById("data_table");
      var config = {
          "method":"POST",
          "args":{"case":"testCase31","name":name}
       };
       var functions = catalyst.function;
       var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
       var functionPromise = functionObject.execute(config);
       functionPromise
          .then((response) => {
              response.json().then(responseBody => {
                if(responseBody.value!="exception"){
                hideLoader();
                if(responseBody.flag==true){
                  table.rows[4].cells[2].innerHTML=responseBody.message;
                  document.getElementById("row4").style.color='red';
                }
                else{
                  table.rows[4].cells[2].innerHTML=responseBody.message;
                  document.getElementById("row4").style.color='green';
                }
                ajaxCall5();
    }
    else{
      hideLoader();
      table.rows[4].cells[2].innerHTML=responseBody.message;
      document.getElementById("row4").style.color='red';
      ajaxCall5();
    }
    });
    })
    .catch((err) => {
    hideLoader();
    console.log(err.error);
    table.rows[4].cells[2].innerHTML=responseBody.message;
    document.getElementById("row4").style.color='red';
    ajaxCall5();
    });
      }
      function ajaxCall5()
      {
        var table=document.getElementById("data_table");
        var config = {
            "method":"POST",
            "args":{"case":"testCase32","name":name}
         };
         var functions = catalyst.function;
         var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
         var functionPromise = functionObject.execute(config);
         functionPromise
            .then((response) => {
                response.json().then(responseBody => {
                  if(responseBody.value!="exception"){
                  hideLoader();
                  if(responseBody.flag==true){
                    table.rows[5].cells[2].innerHTML=responseBody.message;
                    document.getElementById("row5").style.color='red';
                  }
                  else{
                    table.rows[5].cells[2].innerHTML=responseBody.message;
                    document.getElementById("row5").style.color='green';
                  }
                  ajaxCall6();
      }
      else{
        hideLoader();
        table.rows[5].cells[2].innerHTML=responseBody.message;
        document.getElementById("row5").style.color='red';
        ajaxCall6();
      }
      });
      })
      .catch((err) => {
      hideLoader();
      console.log(err.error);
      table.rows[5].cells[2].innerHTML=responseBody.message;
      document.getElementById("row5").style.color='red';
      ajaxCall6();
      });
        }
        function ajaxCall6()
        {
          var table=document.getElementById("data_table");
          var config = {
              "method":"POST",
              "args":{"case":"testCase33","name":name}
           };
           var functions = catalyst.function;
           var functionObject = functions.functionId(1926000000291089); //can pass Function Id or Function Name as argument
           var functionPromise = functionObject.execute(config);
           functionPromise
              .then((response) => {
                  response.json().then(responseBody => {
                    if(responseBody.value!="exception"){
                    hideLoader();
                    if(responseBody.flag==true){
                      table.rows[6].cells[2].innerHTML=responseBody.message;
                      document.getElementById("row6").style.color='red';
                    }
                    else{
                      table.rows[6].cells[2].innerHTML=responseBody.message;
                      document.getElementById("row6").style.color='green';
                    }
                  //  ajaxCall3();
        }
        else{
          hideLoader();
          table.rows[6].cells[2].innerHTML=responseBody.message;
          document.getElementById("row6").style.color='red';
      //    ajaxCall3();
        }
        });
        })
        .catch((err) => {
        hideLoader();
        console.log(err.error);
        table.rows[6].cells[2].innerHTML=responseBody.message;
        document.getElementById("row6").style.color='red';
      //  ajaxCall3();
        });
          }
