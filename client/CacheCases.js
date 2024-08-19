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
  var table=document.getElementById("data_table");
  var config = {
      "method":"POST",
      "args":{"case":"testCase15"}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
    var table=document.getElementById("data_table");
    var config = {
        "method":"POST",
        "args":{"case":"testCase16"}
     };
     var functions = catalyst.function;
     var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
          "args":{"case":"testCase17"}
       };
       var functions = catalyst.function;
       var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
            "args":{"case":"testCase18"}
         };
         var functions = catalyst.function;
         var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
              "args":{"case":"testCase19"}
           };
           var functions = catalyst.function;
           var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
                "args":{"case":"testCase20"}
             };
             var functions = catalyst.function;
             var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
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
                      ajaxCall7();
          }
          else{
            hideLoader();
            table.rows[6].cells[2].innerHTML=responseBody.message;
            document.getElementById("row6").style.color='red';
            ajaxCall7();
          }
          });
          })
          .catch((err) => {
          hideLoader();
          console.log(err.error);
          table.rows[6].cells[2].innerHTML=responseBody.message;
          document.getElementById("row6").style.color='red';
          ajaxCall7();
          });
            }
            function ajaxCall7()
            {
              var table=document.getElementById("data_table");
              var config = {
                  "method":"POST",
                  "args":{"case":"testCase21"}
               };
               var functions = catalyst.function;
               var functionObject = functions.functionId(1926000000302001); //can pass Function Id or Function Name as argument
               var functionPromise = functionObject.execute(config);
               functionPromise
                  .then((response) => {
                      response.json().then(responseBody => {
                        if(responseBody.value!="exception"){
                        hideLoader();
                        if(responseBody.flag==true){
                          table.rows[7].cells[2].innerHTML=responseBody.message;
                          document.getElementById("row7").style.color='red';
                        }
                        else{
                          table.rows[7].cells[2].innerHTML=responseBody.message;
                          document.getElementById("row7").style.color='green';
                        }
                      //  ajaxCall3();
            }
            else{
              hideLoader();
              table.rows[7].cells[2].innerHTML=responseBody.message;
              document.getElementById("row7").style.color='red';
            //    ajaxCall3();
            }
            });
            })
            .catch((err) => {
            hideLoader();
            console.log(err.error);
            table.rows[7].cells[2].innerHTML=responseBody.message;
            document.getElementById("row7").style.color='red';
            //  ajaxCall3();
            });
              }
