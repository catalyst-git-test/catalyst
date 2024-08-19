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
      "args":{"case":"testCase22","name":name}
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   functionPromise
      .then((response) => {
          response.json().then(responseBody => {
            if(responseBody.value!="exception"){
            hideLoader();
            if(responseBody.flag==false){
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
        "args":{"case":"testCase23","name":name}
     };
     var functions = catalyst.function;
     var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
     var functionPromise = functionObject.execute(config);
     functionPromise
        .then((response) => {
            response.json().then(responseBody => {
              if(responseBody.value!="exception"){
              hideLoader();
              if(responseBody.flag==false){
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
          "args":{"case":"testCase24","name":name}
       };
       var functions = catalyst.function;
       var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
       var functionPromise = functionObject.execute(config);
       functionPromise
          .then((response) => {
              response.json().then(responseBody => {
                if(responseBody.value!="exception"){
                hideLoader();
                if(responseBody.flag==true){
                  table.rows[3].cells[2].innerHTML=responseBody.message;
                  document.getElementById("row3").style.color='green';}
                  else{
                    table.rows[3].cells[2].innerHTML=responseBody.message;
                    document.getElementById("row3").style.color='red';
                  }
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
            "args":{"case":"testCase25","name":name}
         };
         var functions = catalyst.function;
         var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
         var functionPromise = functionObject.execute(config);
         functionPromise
            .then((response) => {
                response.json().then(responseBody => {
                  if(responseBody.value!="exception"){
                  hideLoader();
                  if(responseBody.flag==false){
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
              "args":{"case":"testCase26","name":name}
           };
           var functions = catalyst.function;
           var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
           var functionPromise = functionObject.execute(config);
           functionPromise
              .then((response) => {
                  response.json().then(responseBody => {
                    if(responseBody.value!="exception"){
                    hideLoader();
                    if(responseBody.flag==false){
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
                "args":{"case":"testCase27","name":name}
             };
             var functions = catalyst.function;
             var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
             var functionPromise = functionObject.execute(config);
             functionPromise
                .then((response) => {
                    response.json().then(responseBody => {
                      if(responseBody.value!="exception"){
                      hideLoader();
                      if(responseBody.flag==false){
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
                  "args":{"case":"testCase62","name":name}
               };
               var functions = catalyst.function;
               var functionObject = functions.functionId(1926000000342695); //can pass Function Id or Function Name as argument
               var functionPromise = functionObject.execute(config);
               functionPromise
                  .then((response) => {
                      response.json().then(responseBody => {
                        if(responseBody.value!="exception"){
                        hideLoader();
                        if(responseBody.flag==false){
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
