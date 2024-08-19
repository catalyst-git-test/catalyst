var mailContent = "<center><b>List of failures in the report : </b><br><br> <table border=\"3\"><tr><th>Case id</th><th>Case description</th><th>Case result</th><th>Component</th></tr>";
function runCases() {
  console.log("inside runcases");
  window.table = document.getElementById("data_table");
    starttime();
    parallelCases();
    console.log(document.getElementById("email").value);
    if (document.getElementById("email").value == "") {
        validateFunction();
    } else {
        var but = document.getElementById("rundatastore");
        but.style.display = "none";
        showLoader();
        //ajaxCall1();
    }
}

function starttime() {
    var x = document.getElementById("starttime");
    var current = new Date();
    x.innerHTML = current.toLocaleString();
}

function endtime() {
    var x = document.getElementById("endtime");
    var current = new Date();
    x.innerHTML = current.toLocaleString();
}

function totaltime() {
    var x = document.getElementById("totaltime");
    var timetaken = document.getElementById("endtime").value - document.getElementById("starttime").value;
    var msec = timetaken;
    var hh = Math.floor(msec / 1000 / 60 / 60);
    msec -= hh * 1000 * 60 * 60;
    var mm = Math.floor(msec / 1000 / 60);
    msec -= mm * 1000 * 60;
    var ss = Math.floor(msec / 1000);
    msec -= ss * 1000;
}

function showLoader() {
    var x = document.getElementById("loader");
    x.style.display = "block";
}

function hideLoader() {
    var x = document.getElementById("loader");
    x.style.display = "none";
}

function responseValidation(responseBody, rowno, table) {
    if (responseBody.value != "exception") {
        hideLoader();
        if (responseBody.flag == false) {
            table.rows[rowno].cells[2].innerHTML = responseBody.message;
            document.getElementById("row" + rowno).style.color = 'green';
        } else {
            table.rows[rowno].cells[2].innerHTML = responseBody.message;
            document.getElementById("row" + rowno).style.color = 'red';
        }
    } else {
        hideLoader();
        table.rows[rowno].cells[2].innerHTML = responseBody.message;
        document.getElementById("row" + rowno).style.color = 'red';
    }
}

function errorPrint(err, rowno, responseBody, table) {
    hideLoader();
    console.log(err.error);
    table.rows[rowno].cells[2].innerHTML = responseBody.message;
    document.getElementById("row" + rowno).style.color = 'red';
}
//DATASTORE
function ajaxCall1() {
  console.log("inside 1");
    name = document.getElementById("fname").innerHTML;
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase1",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                if (responseBody.flag == false && !name.includes("app")) {
                    var config = {
                        "method": "GET",
                        "args": {
                            "case": "testCase1",
                            "name": name
                        }
                    };
                    var functions = catalyst.function;
                    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
                    var functionPromise = functionObject.execute(config);
                    functionPromise
                        .then((response) => {
                            response.json().then(responseBody => {
                                hideLoader();
                                if (responseBody.flag == false) {
                                    table.rows[1].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row1").style.color = 'green';
                                } else {
                                    table.rows[1].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row1").style.color = 'red';
                                }
                                ajaxCall2();
                            });
                        })
                        .catch((err) => {
                            hideLoader();
                            console.log(err.error);
                            table.rows[1].cells[2].innerHTML = responseBody.message;
                            document.getElementById("row1").style.color = 'red';
                            ajaxCall2();
                        });
                } else {
                    hideLoader();
                    if (name.includes("app")) {
                        table.rows[1].cells[2].innerHTML = responseBody.message;
                        document.getElementById("row1").style.color = 'green';
                        ajaxCall2();
                    } else {
                        table.rows[1].cells[2].innerHTML = responseBody.message;
                        document.getElementById("row1").style.color = 'red';
                        ajaxCall2();
                    }
                }
            })
        })
        .catch((err) => {
            hideLoader();
            console.log(err);
            table.rows[1].cells[2].innerHTML = err;
            document.getElementById("row1").style.color = 'red';
            ajaxCall2();
        });
}

function ajaxCall2() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase2",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 2, table);
                ajaxCall3();
            });
        })
        .catch((err) => {
            errorPrint(err, 2, responseBody, table);
            ajaxCall3();
        });
}

function ajaxCall3() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase3",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 3, table);
                ajaxCall4();
            });
        })
        .catch((err) => {
            errorPrint(err, 3, responseBody, table);
            ajaxCall4();
        });
}

function ajaxCall4() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase4",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 4, table);
                ajaxCall5();
            });
        })
        .catch((err) => {
            errorPrint(err, 4, responseBody, table);
            ajaxCall5();
        });
}

function ajaxCall5() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase5",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 5, table);
                ajaxCall6();
            });
        })
        .catch((err) => {
            errorPrint(err, 5, responseBody, table);
            ajaxCall6();
        });
}

function ajaxCall6() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase6",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 6, table);
                ajaxCall7();
            });
        })
        .catch((err) => {
            errorPrint(err, 6, responseBody, table);
            ajaxCall7();
        });
}

function ajaxCall7() {
    var name = document.getElementById("fname").innerHTML;
    var table = document.getElementById("data_table");
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase7",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 7, table);
                ajaxCall8();
            });
        })
        .catch((err) => {
            errorPrint(err, 7, responseBody, table);
            ajaxCall8();
        });
}

function ajaxCall8() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase8",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 8, table);
                ajaxCall9();
            });
        })
        .catch((err) => {
            errorPrint(err, 8, responseBody, table);
            ajaxCall9();
        });
}

function ajaxCall9() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase9",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 9, table);
                ajaxCall10();
            });
        })
        .catch((err) => {
            errorPrint(err, 9, responseBody, table);
            ajaxCall10();
        });
}

function ajaxCall10() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase10",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 10, table);
                ajaxCall96();
            });
        })
        .catch((err) => {
            errorPrint(err, 10, responseBody, table);
            ajaxCall96();
        });
}

function ajaxCall96() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase96",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 96, table);
                ajaxCall97();
            });
        })
        .catch((err) => {
            errorPrint(err, 96, responseBody, table);
            ajaxCall97();
        });
}

function ajaxCall97() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase97",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 97, table);
                ajaxCall98();
            });
        })
        .catch((err) => {
            errorPrint(err, 97, responseBody, table);
            ajaxCall98();
        });
}

function ajaxCall98() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase98",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 98, table);
                ajaxCall44();
            });
        })
        .catch((err) => {
            errorPrint(err, 98, responseBody, table);
            ajaxCall44();
        });
}
//AUTHENTICATION
function ajaxCall11(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase11",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                if (responseBody.value != "exception") {
                    var config = {
                        "method": "GET",
                        "args": {
                            "case": "testCase11",
                            "name": name
                        }
                    };
                    var functions = catalyst.function;
                    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
                    var functionPromise = functionObject.execute(config);
                    functionPromise
                        .then((response) => {
                            response.json().then(responseBody => {
                                hideLoader();
                                console.log(responseBody);
                                if (responseBody.flag == true && responseBody.value != "exception") {
                                    console.log("if");
                                    table.rows[11].cells[2].innerHTML = responseBody.alert + "<br>" + responseBody.message;
                                    document.getElementById("row11").style.color = 'red';
                                } else if (responseBody.flag == true && responseBody.value == "exception") {
                                    console.log("else if");
                                    table.rows[11].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row11").style.color = 'red';
                                } else {
                                    console.log(responseBody.value);
                                    table.rows[11].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row11").style.color = 'green';
                                }
                                ajaxCall12();
                            });
                        })
                        .catch((err) => {
                            hideLoader();
                            console.log(err.error);
                            table.rows[11].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row11").style.color = 'red';
                            ajaxCall12();
                        });
                } else {
                    hideLoader();
                    table.rows[11].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row11").style.color = 'red';
                    ajaxCall12();
                }
            })
        })
        .catch((err) => {
            hideLoader();
            console.log(err);
            table.rows[11].cells[2].innerHTML = err;
            document.getElementById("row11").style.color = 'red';
            ajaxCall12();
        });
}

function ajaxCall12() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase12",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 12, table);
                ajaxCall13();
            });
        })
        .catch((err) => {
            errorPrint(err, 12, responseBody, table);
            ajaxCall13();
        });
}

function ajaxCall13() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase13",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                if (responseBody.value != "exception") {
                    var config = {
                        "method": "GET",
                        "args": {
                            "case": "testCase13",
                            "name": name
                        }
                    };
                    var functions = catalyst.function;
                    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
                    var functionPromise = functionObject.execute(config);
                    functionPromise
                        .then((response) => {
                            response.json().then(responseBody => {
                                hideLoader();
                                console.log(responseBody);
                                if (responseBody.flag == true && responseBody.value != "exception") {
                                    console.log("if");
                                    table.rows[13].cells[2].innerHTML = responseBody.alert + "<br>" + responseBody.message;
                                    document.getElementById("row13").style.color = 'red';
                                } else if (responseBody.flag == true && responseBody.value == "exception") {
                                    console.log("else if");
                                    table.rows[13].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row13").style.color = 'red';
                                } else {
                                    console.log(responseBody.value);
                                    table.rows[13].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row13").style.color = 'green';
                                }
                                ajaxCall14();
                            });
                        })
                        .catch((err) => {
                            hideLoader();
                            console.log(err.error);
                            table.rows[13].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row13").style.color = 'red';
                            ajaxCall14();
                        });
                } else {
                    hideLoader();
                    table.rows[13].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row13").style.color = 'red';
                    ajaxCall14();
                }
            })
        })
        .catch((err) => {
            hideLoader();
            console.log(err);
            table.rows[13].cells[2].innerHTML = err;
            document.getElementById("row13").style.color = 'red';
            ajaxCall14();
        });
}

function ajaxCall14() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase14",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 14, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 14, responseBody, table);
        });
}

//CACHE CASES
function ajaxCall15(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase15",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 15, table);
                ajaxCall16();
            });
        })
        .catch((err) => {
            errorPrint(err, 15, responseBody, table);
            ajaxCall16();
        });
}

function ajaxCall16() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase16",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 16, table);
                ajaxCall17();
            });
        })
        .catch((err) => {
            errorPrint(err, 16, responseBody, table);
            ajaxCall17();
        });
}

function ajaxCall17() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase17",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 17, table);
                ajaxCall18();
            });
        })
        .catch((err) => {
            errorPrint(err, 17, responseBody, table);
            ajaxCall18();
        });
}

function ajaxCall18() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase18",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 18, table);
                ajaxCall19();
            });
        })
        .catch((err) => {
            errorPrint(err, 18, responseBody, table);
            ajaxCall19();
        });
}

function ajaxCall19() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase19",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 19, table);
                ajaxCall20();
            });
        })
        .catch((err) => {
            errorPrint(err, 19, responseBody, table);
            ajaxCall20();
        });
}

function ajaxCall20() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase20",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 20, table);
                ajaxCall21();
            });
        })
        .catch((err) => {
            errorPrint(err, 20, responseBody, table);
            ajaxCall21();
        });
}

function ajaxCall21() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase21",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 21, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 21, responseBody, table);
        });
}

//CRON CASES
function ajaxCall22(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase22",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 22, table);
                ajaxCall23();
            });
        })
        .catch((err) => {
            errorPrint(err, 22, responseBody, table);
            ajaxCall23();
        });
}

function ajaxCall23() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase23",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 23, table);
                ajaxCall24();
            });
        })
        .catch((err) => {
            errorPrint(err, 23, responseBody, table);
            ajaxCall24();
        });
}

function ajaxCall24() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase24",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 24, table);
                ajaxCall25();
            });
        })
        .catch((err) => {
            errorPrint(err, 24, responseBody, table);
            ajaxCall25();
        });
}

function ajaxCall25() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase25",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 25, table);
                ajaxCall26();
            });
        })
        .catch((err) => {
            errorPrint(err, 25, responseBody, table);
            ajaxCall26();
        });
}

function ajaxCall26() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase26",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 26, table);
                ajaxCall27();
            });
        })
        .catch((err) => {
            errorPrint(err, 26, responseBody, table);
            ajaxCall27();
        });
}

function ajaxCall27() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase27",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 27, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 27, responseBody, table);
        });
}

function ajaxCall62() {
    var table = document.getElementById("data_table");
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase62",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 62, table);
                ajaxCall63();
            });
        })
        .catch((err) => {
            errorPrint(err, 62, responseBody, table);
            ajaxCall63();
        });
}
//FILE STORE
function ajaxCall28(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase28",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                if (responseBody.value != "exception") {
                    var config = {
                        "method": "GET",
                        "args": {
                            "case": "testCase28",
                            "name": name
                        }
                    };
                    var functions = catalyst.function;
                    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
                    var functionPromise = functionObject.execute(config);
                    functionPromise
                        .then((response) => {
                            response.json().then(responseBody => {
                                hideLoader();
                                console.log(responseBody);
                                if (responseBody.flag == true && responseBody.value != "exception") {
                                    console.log("if");
                                    table.rows[28].cells[2].innerHTML = responseBody.alert + "<br>" + responseBody.message;
                                    document.getElementById("row28").style.color = 'red';
                                } else if (responseBody.flag == true && responseBody.value == "exception") {
                                    console.log("else if");
                                    table.rows[28].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row28").style.color = 'red';
                                } else {
                                    console.log(responseBody.value);
                                    table.rows[28].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row28").style.color = 'green';
                                }
                                ajaxCall29();
                            });
                        })
                        .catch((err) => {
                            hideLoader();
                            console.log(err.error);
                            table.rows[28].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row28").style.color = 'red';
                            ajaxCall29();
                        });
                } else {
                    hideLoader();
                    table.rows[28].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row28").style.color = 'red';
                    ajaxCall29();
                }
            })
        })
        .catch((err) => {
            hideLoader();
            console.log(err);
            table.rows[28].cells[2].innerHTML = err;
            document.getElementById("row28").style.color = 'red';
            ajaxCall29();
        });
}

function ajaxCall29() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase29"
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 29, table);
                ajaxCall30();
            });
        })
        .catch((err) => {
            errorPrint(err, 29, responseBody, table);
            ajaxCall30();
        });
}

function ajaxCall30() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase30",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 30, table);
                ajaxCall31();
            });
        })
        .catch((err) => {
            errorPrint(err, 30, responseBody, table);
            ajaxCall31();
        });
}

function ajaxCall31() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase31",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 31, table);
                ajaxCall32();
            });
        })
        .catch((err) => {
            errorPrint(err, 31, responseBody, table);
            ajaxCall32();
        });
}

function ajaxCall32() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase32",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 32, table);
                ajaxCall33();
            });
        })
        .catch((err) => {
            errorPrint(err, 32, responseBody, table);
            ajaxCall33();
        });
}

function ajaxCall33() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase33",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 33, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 33, responseBody, table);
        });
}

//FUNCTION CASES
function ajaxCall34(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase34",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343678); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 34, table);
                ajaxCall35();
            });
        })
        .catch((err) => {
            errorPrint(err, 34, responseBody, table);
            ajaxCall35();
        });
}

function ajaxCall35() {
    // var name = document.getElementById("fname").innerHTML;
    // var table=document.getElementById("data_table");
    // var config = {
    // "method":"POST",
    // "args":{"case":"testCase35","name":name}
    // };
    // var functions = catalyst.function;
    // var functionObject = functions.functionId(1926000004343678); //can pass Function Id or Function Name as argument
    // var functionPromise = functionObject.execute(config);
    // functionPromise
    // .then((response) => {
    // response.json().then(responseBody => {
    // if(responseBody.value!="exception"){
    // hideLoader();
    // if(responseBody.flag==true){
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // }
    // else{
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='green';
    // }
    //   //  ajaxCall36();
    // }
    // else{
    // hideLoader();
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // //  ajaxCall36();
    // }
    // });
    // })
    // .catch((err) => {
    // hideLoader();
    // console.log(err);
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // //  ajaxCall36();
    // });
}

//MAIL CASES
function ajaxCall36(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase36",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 36, table);
                ajaxCall37();
            });
        })
        .catch((err) => {
            errorPrint(err, 36, responseBody, table);
            ajaxCall37();
        });
}

function ajaxCall37() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase37",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 37, table);
                ajaxCall38();
            });
        })
        .catch((err) => {
            errorPrint(err, 37, responseBody, table);
            ajaxCall38();
        });
}

function ajaxCall38() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase38",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 38, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 38, responseBody, table);
        });
}

//SEARCH CASES
function ajaxCall39(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase39",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                hideLoader();
                responseValidation(responseBody, 39, table);
                ajaxCall40();
            });
        })
        .catch((err) => {
            errorPrint(err, 39, responseBody, table);
            ajaxCall40();
        });
}

function ajaxCall40() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase40",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 40, table);
                ajaxCall41();
            });
        })
        .catch((err) => {
            errorPrint(err, 40, responseBody, table);
            ajaxCall41();
        });
}

function ajaxCall41() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase41",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 41, table);
                ajaxCall42();
            });
        })
        .catch((err) => {
            errorPrint(err, 41, responseBody, table);
            ajaxCall42();
        });
}

function ajaxCall42() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase42",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 42, table);
                ajaxCall43();
            });
        })
        .catch((err) => {
            errorPrint(err, 42, responseBody, table);
            ajaxCall43();
        });
}

function ajaxCall43() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase43",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 43, table);
                ajaxCall88();
            });
        })
        .catch((err) => {
            errorPrint(err, 43, responseBody, table);
            ajaxCall88();
        });
}

function ajaxCall88() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase88",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 88, table);
                ajaxCall89();
            });
        })
        .catch((err) => {
            errorPrint(err, 88, responseBody, table);
            ajaxCall89();
        });
}

function ajaxCall89() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase89",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 89, table);
                ajaxCall90();
            });
        })
        .catch((err) => {
            errorPrint(err, 89, responseBody, table);
            ajaxCall90();
        });
}

function ajaxCall90() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase90",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 90, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 90, responseBody, table);
        });
}
//ZCQL CASES
function ajaxCall44() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase44",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 44, table);
                ajaxCall45();
            });
        })
        .catch((err) => {
            errorPrint(err, 44, responseBody, table);
            ajaxCall45();
        });
}

function ajaxCall45() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase45",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 45, table);
                ajaxCall46();
            });
        })
        .catch((err) => {
            errorPrint(err, 45, responseBody, table);
            ajaxCall46();
        });
}

function ajaxCall46() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase46",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 46, table);
                ajaxCall47();
            });
        })
        .catch((err) => {
            errorPrint(err, 46, responseBody, table);
            ajaxCall47();
        });
}

function ajaxCall47() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase47",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 47, table);
                ajaxCall48();
            });
        })
        .catch((err) => {
            errorPrint(err, 47, responseBody, table);
            ajaxCall48();
        });
}

function ajaxCall48() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase48",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 48, table);
                ajaxCall49();
            });
        })
        .catch((err) => {
            errorPrint(err, 48, responseBody, table);
            ajaxCall49();
        });
}

function ajaxCall49() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase49",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 49, table);
                ajaxCall50();
            });
        })
        .catch((err) => {
            errorPrint(err, 49, responseBody, table);
            ajaxCall50();
        });
}

function ajaxCall50() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase50",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 50, table);
                ajaxCall51();
            });
        })
        .catch((err) => {
            errorPrint(err, 50, responseBody, table);
            ajaxCall51();
        });
}

function ajaxCall51() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase51",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 51, table);
                ajaxCall52();
            });
        })
        .catch((err) => {
            errorPrint(err, 51, responseBody, table);
            ajaxCall52();
        });
}

function ajaxCall52() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase52",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 52, table);
                ajaxCall53();
            });
        })
        .catch((err) => {
            errorPrint(err, 52, responseBody, table);
            ajaxCall53();
        });
}

function ajaxCall53() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase53",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 53, table);
                ajaxCall54();
            });
        })
        .catch((err) => {
            errorPrint(err, 53, responseBody, table);
            ajaxCall54();
        });
}

function ajaxCall54() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase54",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 54, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 54, responseBody, table);
        });
}

function ajaxCall63() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase63",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 63, table);
                ajaxCall64();
            });
        })
        .catch((err) => {
            errorPrint(err, 63, responseBody, table);
            ajaxCall64();
        });
}

function ajaxCall64() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase64",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 64, table);
                ajaxCall65();
            });
        })
        .catch((err) => {
            errorPrint(err, 64, responseBody, table);
            ajaxCall65();
        });
}

function ajaxCall65() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase65",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 65, table);
                ajaxCall66();
            });
        })
        .catch((err) => {
            errorPrint(err, 65, responseBody, table);
            ajaxCall66();
        });
}

function ajaxCall66() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase66",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 66, table);
                ajaxCall67();
            });
        })
        .catch((err) => {
            errorPrint(err, 66, responseBody, table);
            ajaxCall67();
        });
}

function ajaxCall67() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase67",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 67, table);
                ajaxCall68();
            });
        })
        .catch((err) => {
            errorPrint(err, 67, responseBody, table);
            ajaxCall68();
        });
}

function ajaxCall68() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase68",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 68, table);
                ajaxCall69();
            });
        })
        .catch((err) => {
            errorPrint(err, 68, responseBody, table);
            ajaxCall69();
        });
}

function ajaxCall69() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase69",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 69, table);
                ajaxCall70();
            });
        })
        .catch((err) => {
            errorPrint(err, 69, responseBody, table);
            ajaxCall70();
        });
}

function ajaxCall70() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase70",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 70, table);
                ajaxCall71();
            });
        })
        .catch((err) => {
            errorPrint(err, 70, responseBody, table);
            ajaxCall71();
        });
}

function ajaxCall71() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase71",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 71, table);
                ajaxCall72();
            });
        })
        .catch((err) => {
            errorPrint(err, 71, responseBody, table);
            ajaxCall72();
        });
}

function ajaxCall72() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase72",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 72, table);
                ajaxCall73();
            });
        })
        .catch((err) => {
            errorPrint(err, 72, responseBody, table);
            ajaxCall73();
        });
}

function ajaxCall73() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase73",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 73, table);
                ajaxCall74();
            });
        })
        .catch((err) => {
            errorPrint(err, 73, responseBody, table);
            ajaxCall74();
        });
}

function ajaxCall74() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase74",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 74, table);
                ajaxCall75();
            });
        })
        .catch((err) => {
            errorPrint(err, 74, responseBody, table);
            ajaxCall75();
        });
}

function ajaxCall75() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase75",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 75, table);
                ajaxCall76();
            });
        })
        .catch((err) => {
            errorPrint(err, 75, responseBody, table);
            ajaxCall76();
        });
}

function ajaxCall76() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase76",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 76, table);
                ajaxCall77();
            });
        })
        .catch((err) => {
            errorPrint(err, 76, responseBody, table);
            ajaxCall77();
        });
}

function ajaxCall77() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase77",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 77, table);
                ajaxCall78();
            });
        })
        .catch((err) => {
            errorPrint(err, 77, responseBody, table);
            ajaxCall78();
        });
}

function ajaxCall78() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase78",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 78, table);
                ajaxCall79();
            });
        })
        .catch((err) => {
            errorPrint(err, 78, responseBody, table);
            ajaxCall79();
        });
}

function ajaxCall79() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase79",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 79, table);
                ajaxCall80();
            });
        })
        .catch((err) => {
            errorPrint(err, 79, responseBody, table);
            ajaxCall80();
        });
}

function ajaxCall80() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase80",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 80, table);
                ajaxCall81();
            });
        })
        .catch((err) => {
            errorPrint(err, 80, responseBody, table);
            ajaxCall81();
        });
}

function ajaxCall81() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase81",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 81, table);
                ajaxCall82();
            });
        })
        .catch((err) => {
            errorPrint(err, 81, responseBody, table);
            ajaxCall82();
        });
}

function ajaxCall82() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase82",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 82, table);
                ajaxCall83();
            });
        })
        .catch((err) => {
            errorPrint(err, 82, responseBody, table);
            ajaxCall83();
        });
}

function ajaxCall83() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase83",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 83, table);
                ajaxCall84();
            });
        })
        .catch((err) => {
            errorPrint(err, 83, responseBody, table);
            ajaxCall84();
        });
}

function ajaxCall84() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase84",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 84, table);
                ajaxCall85();
            });
        })
        .catch((err) => {
            errorPrint(err, 84, responseBody, table);
            ajaxCall85();
        });
}

function ajaxCall85() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase85",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 85, table);
                ajaxCall86();
            });
        })
        .catch((err) => {
            errorPrint(err, 85, responseBody, table);
            ajaxCall86();
        });
}

function ajaxCall86() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase86",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 86, table);
                ajaxCall87();
            });
        })
        .catch((err) => {
            errorPrint(err, 86, responseBody, table);
            ajaxCall87();
        });
}

function ajaxCall87() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase87",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 87, table);
                ajaxCall93();
            });
        })
        .catch((err) => {
            errorPrint(err, 87, responseBody, table);
            ajaxCall93();
        });
}

function ajaxCall91(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase91",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 91, table);
                ajaxCall92();
            });
        })
        .catch((err) => {
            errorPrint(err, 91, responseBody, table);
            ajaxCall92();
        });
}

function ajaxCall92() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase92",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 92, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 92, responseBody, table);
        });
}

function ajaxCall93() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase93",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 93, table);
                ajaxCall94();
            });
        })
        .catch((err) => {
            errorPrint(err, 93, responseBody, table);
            ajaxCall94();
        });
}

function ajaxCall94() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase94",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 94, table);
                ajaxCall95();
            });
        })
        .catch((err) => {
            errorPrint(err, 94, responseBody, table);
            ajaxCall95();
        });
}

function ajaxCall95() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase95",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 95, table);
                //    checkAllCasesRun();
                countCalculation();

            });
        })
        .catch((err) => {
            errorPrint(err, 95, responseBody, table);
            //  checkAllCasesRun();
            countCalculation();

        });
}
//ZIA CASES
function ajaxCall55(name, table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase55",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 55, table);
                ajaxCall56();
            });
        })
        .catch((err) => {
            errorPrint(err, 55, responseBody, table);
            ajaxCall56();
        });
}

function ajaxCall56() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase56",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 56, table);
                ajaxCall57();
            });
        })
        .catch((err) => {
            errorPrint(err, 56, responseBody, table);
            ajaxCall57();
        });
}

function ajaxCall57() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase57",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 57, table);
                ajaxCall58();
            });
        })
        .catch((err) => {
            errorPrint(err, 57, responseBody, table);
            ajaxCall58();
        });
}

function ajaxCall58() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase58",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 58, table);
                ajaxCall59();
            });
        })
        .catch((err) => {
            errorPrint(err, 58, responseBody, table);
            ajaxCall59();
        });
}

function ajaxCall59() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase59",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 59, table);
                ajaxCall60();
            });
        })
        .catch((err) => {
            errorPrint(err, 59, responseBody, table);
            ajaxCall60();
        });
}

function ajaxCall60() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase60",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 60, table);
                ajaxCall61();
            });
        })
        .catch((err) => {
            errorPrint(err, 60, responseBody, table);
            ajaxCall61();
        });
}

function ajaxCall61() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase61",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 61, table);
                ajaxCall62();
            });
        })
        .catch((err) => {
            errorPrint(err, 61, responseBody, table);
            ajaxCall62();
        });
}

//circuits cases

function ajaxCall99(name,table) {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase99",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000006254260); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 99, table);
                ajaxCall100();
            });
        })
        .catch((err) => {
            errorPrint(err, 99, responseBody, table);
            ajaxCall100();
        });
}
function ajaxCall100() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase100",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000006254260); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 100, table);
                ajaxCall1();
            });
        })
        .catch((err) => {
            errorPrint(err, 100, responseBody, table);
            ajaxCall1();
        });
}

function countCalculation() {
    endtime();
    var flag=false;
    var value = "";
    var failCount = 0;
    var passPercentage = 0;
    var table = document.getElementById("data_table");
    for (var i = 1; i <= table.rows.length - 1; i++) {
        value = "row" + i;
        if (document.getElementById(value).style.color == 'red' && document.getElementById(value).style.color != 'green') {
            failCount += 1;
            mailContent = mailContent + "<tr><td>" + i + "</td><td>" + table.rows[i].cells[1].innerHTML + "</td><td style=\"color:red\">" + table.rows[i].cells[2].innerHTML + "</td><td>" + table.rows[i].cells[3].innerHTML + "</td></tr>";
        }
    }
    console.log(table.rows.length);
    passPercentage = (table.rows.length - 1 - failCount) / (table.rows.length - 1);
    console.log(passPercentage);
    passPercentage = Math.round(passPercentage * 100);
    mailContent = mailContent + "</table><br><br><b> Total number of failed cases - " + failCount + "</b><br><br><b>Passed Cases percentage - " + passPercentage + "%</b></center>";
    document.getElementById("count").innerHTML = "<br><br>Total number of failures - " + failCount;
    document.getElementById("percentage").innerHTML = passPercentage;
    mailSend();
    totaltime();
}

function mailSend() {
    var config = {
        "method": "POST",
        "args": {
            "id": document.getElementById("email").value,
            "content": mailContent
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343643); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config);
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {});
        })
        .catch((err) => {});
}

function validateFunction() {
    window.alert("Please enter a valid email address");
}


async function fillTestCases(){
  hideLoader();
  catalyst.auth.isUserAuthenticated().then(result => {
    console.log("auth check");
      var first_name = "First Name: " + result.content.first_name;
      document.getElementById("fname").innerHTML = first_name;
  }).catch(err => {});
  console.log("inside fillTestCases check");
  var table = document.getElementById("data_table");
  var query="Select * from TestcaseTable;";
  var zcql = catalyst.ZCatalystQL;
 var zcqlPromise  = zcql.executeQuery(query);
 zcqlPromise
        .then((response) => {
            for(var itr=0;itr<response.content.length;itr++){
              let table_response = response.content[itr].TestcaseTable;
              let row = table.insertRow(-1);
              let c1 = row.insertCell(0);
              let c2 = row.insertCell(1);
              let c3 = row.insertCell(2);
              c3.id="row"+(itr+1);
              let c4 = row.insertCell(3);
              c1.innerText=table_response.ID;
              c2.innerText=table_response.Case_Description
              c4.innerText=table_response.Component;
            }
        })
        .catch((err) => {
            console.log(err);
        });
}
