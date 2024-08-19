var mailContent = "<center><b>List of failures in the report : </b><br><br> <table border=\"3\"><tr><th>Case id</th><th>Case description</th><th>Case result</th><th>Component</th></tr>";
let functionsArray = [];
async function executeCases() {
  window.table = document.getElementById("data_table");
    await timeStart();
    await caseOrder();
    if (document.getElementById("email").value == "") {
        await validateFunction();
    } else {
        var but = document.getElementById("rundatastore");
        but.style.display = "none";
    }
}

async function timeStart() {
    var x = document.getElementById("starttime");
    var current = new Date();
    x.innerHTML = current.toLocaleString();
}

async function timeEnd() {
    var x = document.getElementById("endtime");
    var current = new Date();
    x.innerHTML = current.toLocaleString();
}

async function totalTime() {
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

async function responseValidation(responseBody, rowno, table) {
    if (responseBody.value != "exception") {
        if (responseBody.flag == false) {
            table.rows[rowno].cells[2].innerHTML = responseBody.message;
            document.getElementById("row" + rowno).style.color = 'green';
        } else {
            table.rows[rowno].cells[2].innerHTML = responseBody.message;
            document.getElementById("row" + rowno).style.color = 'red';
        }
    } else {
        table.rows[rowno].cells[2].innerHTML = responseBody.message;
        document.getElementById("row" + rowno).style.color = 'red';
    }
}

async function errorPrint(err, rowno, responseBody, table) {
    console.log(err.error);
    table.rows[rowno].cells[2].innerHTML = responseBody.message;
    document.getElementById("row" + rowno).style.color = 'red';
}

async function ajaxCall1() {
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
    var functionPromise = functionObject.execute(config); await functionPromise;
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
                                ;
                                if (responseBody.flag == false) {
                                    table.rows[1].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row1").style.color = 'green';
                                } else {
                                    table.rows[1].cells[2].innerHTML = responseBody.message;
                                    document.getElementById("row1").style.color = 'red';
                                }

                            });
                        })
                        .catch((err) => {
                            ;
                            console.log(err.error);
                            table.rows[1].cells[2].innerHTML = responseBody.message;
                            document.getElementById("row1").style.color = 'red';

                        });
                } else {
                    ;
                    if (name.includes("app")) {
                        table.rows[1].cells[2].innerHTML = responseBody.message;
                        document.getElementById("row1").style.color = 'green';

                    } else {
                        table.rows[1].cells[2].innerHTML = responseBody.message;
                        document.getElementById("row1").style.color = 'red';

                    }
                }
            })
        })
        .catch((err) => {
            ;
            console.log(err);
            table.rows[1].cells[2].innerHTML = err;
            document.getElementById("row1").style.color = 'red';

        });
        return "completed";
}

async function ajaxCall2() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase2",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 2, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 2, responseBody, table);

        });
        return "completed";
}

async function ajaxCall3() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase3",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 3, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 3, responseBody, table);

        });
        return "completed";
}

async function ajaxCall4() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase4",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 4, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 4, responseBody, table);

        });
        return "completed";
}

async function ajaxCall5() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase5",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 5, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 5, responseBody, table);

        });
        return "completed";
}

async function ajaxCall6() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase6",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 6, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 6, responseBody, table);

        });
        return "completed";
}

async function ajaxCall7() {
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
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 7, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 7, responseBody, table);

        });
        return "completed";
}

async function ajaxCall8() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase8",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 8, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 8, responseBody, table);

        });
        return "completed";
}

async function ajaxCall9() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase9",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 9, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 9, responseBody, table);

        });
        return "completed";
}

async function ajaxCall10() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase10",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 10, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 10, responseBody, table);

        });
        return "completed";
}

async function ajaxCall96() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase96",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 96, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 96, responseBody, table);

        });
        return "completed";
}

async function ajaxCall97() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase97",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 97, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 97, responseBody, table);

        });
        return "completed";
}

async function ajaxCall98() {
    var config = {
        "method": "GET",
        "args": {
            "case": "testCase98",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343734); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 98, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 98, responseBody, table);

        });
        return "completed";
}
//AUTHENTICATION
async function ajaxCall11() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase11",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
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
                                ;
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

                            });
                        })
                        .catch((err) => {
                            ;
                            console.log(err.error);
                            table.rows[11].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row11").style.color = 'red';

                        });
                } else {
                    ;
                    table.rows[11].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row11").style.color = 'red';

                }
            })
        })
        .catch((err) => {
            ;
            console.log(err);
            table.rows[11].cells[2].innerHTML = err;
            document.getElementById("row11").style.color = 'red';

        });
        return "completed";
}

async function ajaxCall12() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase12",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 12, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 12, responseBody, table);

        });
        return "completed";
}

async function ajaxCall13() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase13",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
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
                                ;
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

                            });
                        })
                        .catch((err) => {
                            ;
                            console.log(err.error);
                            table.rows[13].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row13").style.color = 'red';

                        });
                } else {
                    ;
                    table.rows[13].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row13").style.color = 'red';

                }
            })
        })
        .catch((err) => {
            ;
            console.log(err);
            table.rows[13].cells[2].innerHTML = err;
            document.getElementById("row13").style.color = 'red';

        });
        return "completed";
}

async function ajaxCall14() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase14",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343727); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 14, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 14, responseBody, table);
        });
        return "completed";
}

//CACHE CASES
async function ajaxCall15() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase15",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 15, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 15, responseBody, table);

        });
        return "completed";
}

async function ajaxCall16() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase16",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 16, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 16, responseBody, table);

        });
        return "completed";
}

async function ajaxCall17() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase17",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 17, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 17, responseBody, table);

        });
        return "completed";
}

async function ajaxCall18() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase18",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 18, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 18, responseBody, table);

        });
        return "completed";
}

async function ajaxCall19() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase19",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 19, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 19, responseBody, table);

        });
        return "completed";
}

async function ajaxCall20() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase20",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 20, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 20, responseBody, table);

        });
        return "completed";
}

async function ajaxCall21() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase21",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343713); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 21, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 21, responseBody, table);
        });
        return "completed";
}

//CRON CASES
async function ajaxCall22() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase22",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 22, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 22, responseBody, table);

        });
        return "completed";
}

async function ajaxCall23() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase23",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 23, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 23, responseBody, table);

        });
        return "completed";
}

async function ajaxCall24() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase24",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 24, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 24, responseBody, table);

        });
        return "completed";
}

async function ajaxCall25() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase25",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 25, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 25, responseBody, table);

        });
        return "completed";
}

async function ajaxCall26() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase26",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 26, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 26, responseBody, table);

        });
        return "completed";
}

async function ajaxCall27() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase27",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343706); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 27, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 27, responseBody, table);
        });
        return "completed";
}

async function ajaxCall62() {
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
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 62, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 62, responseBody, table);

        });
        return "completed";

}
//FILE STORE
async function ajaxCall28() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase28",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
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
                                ;
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

                            });
                        })
                        .catch((err) => {
                            ;
                            console.log(err.error);
                            table.rows[28].cells[2].innerHTML = responseBody.value;
                            document.getElementById("row28").style.color = 'red';

                        });
                } else {
                    ;
                    table.rows[28].cells[2].innerHTML = responseBody.message;
                    document.getElementById("row28").style.color = 'red';

                }
            })
        })
        .catch((err) => {
            ;
            console.log(err);
            table.rows[28].cells[2].innerHTML = err;
            document.getElementById("row28").style.color = 'red';

        });
        return "completed";

}

async function ajaxCall29() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase29"
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 29, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 29, responseBody, table);

        });
        return "completed";

}

async function ajaxCall30() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase30",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 30, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 30, responseBody, table);

        });
        return "completed";

}

async function ajaxCall31() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase31",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 31, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 31, responseBody, table);

        });
        return "completed";

}

async function ajaxCall32() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase32",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 32, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 32, responseBody, table);

        });
        return "completed";

}

async function ajaxCall33() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase33",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343720); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 33, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 33, responseBody, table);
        });
        return "completed";

}

//FUNCTION CASES
async function ajaxCall34() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase34",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343678); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 34, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 34, responseBody, table);

        });
        return "completed";
}

async function ajaxCall35() {
    // var name = document.getElementById("fname").innerHTML;
    // var table=document.getElementById("data_table");
    // var config = {
    // "method":"POST",
    // "args":{"case":"testCase35","name":name}
    // };
    // var functions = catalyst.function;
    // var functionObject = functions.functionId(1926000004343678); //can pass Function Id or Function Name as argument
    // var functionPromise = functionObject.execute(config); await functionPromise;
    // functionPromise
    // .then((response) => {
    // response.json().then(responseBody => {
    // if(responseBody.value!="exception"){
    // ;
    // if(responseBody.flag==true){
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // }
    // else{
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='green';
    // }
    //   //
    // }
    // else{
    // ;
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // //
    // }
    // });
    // })
    // .catch((err) => {
    // ;
    // console.log(err);
    // table.rows[35].cells[2].innerHTML=responseBody.message;
    // document.getElementById("row35").style.color='red';
    // //
    // });
    return "completed";
}

//MAIL CASES
async function ajaxCall36() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase36",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 36, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 36, responseBody, table);

        });
        return "completed";

}

async function ajaxCall37() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase37",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 37, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 37, responseBody, table);

        });
        return "completed";

}

async function ajaxCall38() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase38",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343657); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 38, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 38, responseBody, table);
        });
        return "completed";

}

//SEARCH CASES
async function ajaxCall39() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase39",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                ;
                responseValidation(responseBody, 39, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 39, responseBody, table);

        });
        return "completed";

}

async function ajaxCall40() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase40",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 40, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 40, responseBody, table);

        });
        return "completed";

}

async function ajaxCall41() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase41",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 41, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 41, responseBody, table);

        });
        return "completed";

}

async function ajaxCall42() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase42",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 42, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 42, responseBody, table);

        });
        return "completed";

}

async function ajaxCall43() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase43",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 43, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 43, responseBody, table);

        });
        return "completed";

}

async function ajaxCall88() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase88",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 88, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 88, responseBody, table);

        });
        return "completed";

}

async function ajaxCall89() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase89",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 89, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 89, responseBody, table);

        });
        return "completed";

}

async function ajaxCall90() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase90",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343671); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 90, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 90, responseBody, table);
        });
        return "completed";

}
//ZCQL CASES
async function ajaxCall44() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase44",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 44, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 44, responseBody, table);

        });
        return "completed";

}

async function ajaxCall45() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase45",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 45, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 45, responseBody, table);

        });
        return "completed";

}

async function ajaxCall46() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase46",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 46, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 46, responseBody, table);

        });
        return "completed";

}

async function ajaxCall47() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase47",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 47, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 47, responseBody, table);

        });
        return "completed";

}

async function ajaxCall48() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase48",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 48, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 48, responseBody, table);

        });
        return "completed";

}

async function ajaxCall49() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase49",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 49, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 49, responseBody, table);

        });
        return "completed";

}

async function ajaxCall50() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase50",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 50, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 50, responseBody, table);

        });
        return "completed";

}

async function ajaxCall51() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase51",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 51, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 51, responseBody, table);

        });
        return "completed";

}

async function ajaxCall52() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase52",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 52, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 52, responseBody, table);

        });
        return "completed";

}

async function ajaxCall53() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase53",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 53, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 53, responseBody, table);

        });
        return "completed";

}

async function ajaxCall54() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase54",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 54, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 54, responseBody, table);
        });
        return "completed";

}

async function ajaxCall63() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase63",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 63, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 63, responseBody, table);

        });
        return "completed";

}

async function ajaxCall64() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase64",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 64, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 64, responseBody, table);

        });
        return "completed";

}

async function ajaxCall65() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase65",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 65, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 65, responseBody, table);

        });
        return "completed";

}

async function ajaxCall66() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase66",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 66, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 66, responseBody, table);

        });
        return "completed";

}

async function ajaxCall67() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase67",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 67, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 67, responseBody, table);

        });
        return "completed";

}

async function ajaxCall68() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase68",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 68, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 68, responseBody, table);

        });
        return "completed";

}

async function ajaxCall69() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase69",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 69, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 69, responseBody, table);

        });
        return "completed";

}

async function ajaxCall70() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase70",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 70, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 70, responseBody, table);

        });
        return "completed";

}

async function ajaxCall71() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase71",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 71, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 71, responseBody, table);

        });
        return "completed";

}

async function ajaxCall72() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase72",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 72, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 72, responseBody, table);

        });
        return "completed";

}

async function ajaxCall73() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase73",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 73, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 73, responseBody, table);

        });
        return "completed";

}

async function ajaxCall74() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase74",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 74, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 74, responseBody, table);

        });
        return "completed";

}

async function ajaxCall75() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase75",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 75, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 75, responseBody, table);

        });
        return "completed";

}

async function ajaxCall76() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase76",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 76, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 76, responseBody, table);

        });
        return "completed";

}

async function ajaxCall77() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase77",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 77, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 77, responseBody, table);

        });
        return "completed";

}

async function ajaxCall78() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase78",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 78, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 78, responseBody, table);

        });
        return "completed";

}

async function ajaxCall79() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase79",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 79, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 79, responseBody, table);

        });
        return "completed";

}

async function ajaxCall80() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase80",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 80, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 80, responseBody, table);

        });
        return "completed";

}

async function ajaxCall81() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase81",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 81, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 81, responseBody, table);

        });
        return "completed";

}

async function ajaxCall82() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase82",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 82, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 82, responseBody, table);

        });
        return "completed";
}

async function ajaxCall83() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase83",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 83, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 83, responseBody, table);

        });
        return "completed";
}

async function ajaxCall84() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase84",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 84, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 84, responseBody, table);

        });
        return "completed";
}

async function ajaxCall85() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase85",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 85, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 85, responseBody, table);

        });
        return "completed";
}

async function ajaxCall86() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase86",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 86, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 86, responseBody, table);

        });
        return "completed";

}

async function ajaxCall87() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase87",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 87, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 87, responseBody, table);

        });
        return "completed";

}

async function ajaxCall91() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase91",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 91, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 91, responseBody, table);

        });
        return "completed";

}

async function ajaxCall92() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase92",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 92, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 92, responseBody, table);
        });
        return "completed";

}

async function ajaxCall93() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase93",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 93, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 93, responseBody, table);

        });
        return "completed";

}

async function ajaxCall94() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase94",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 94, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 94, responseBody, table);

        });
        return "completed";

}

async function ajaxCall95() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase95",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343692); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 95, table);
                //    checkAllCasesRun();
              //  countCalculation();

            });
        })
        .catch((err) => {
            errorPrint(err, 95, responseBody, table);
            //  checkAllCasesRun();
          //  countCalculation();

        });
        return "completed";

}
//ZIA CASES
async function ajaxCall55() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase55",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 55, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 55, responseBody, table);

        });
        return "completed";

}

async function ajaxCall56() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase56",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 56, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 56, responseBody, table);

        });
        return "completed";

}

async function ajaxCall57() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase57",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 57, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 57, responseBody, table);

        });
        return "completed";

}

async function ajaxCall58() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase58",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 58, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 58, responseBody, table);

        });
        return "completed";

}

async function ajaxCall59() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase59",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 59, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 59, responseBody, table);

        });
        return "completed";

}

async function ajaxCall60() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase60",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 60, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 60, responseBody, table);

        });
        return "completed";

}

async function ajaxCall61() {
    var config = {
        "method": "POST",
        "args": {
            "case": "testCase61",
            "name": name
        }
    };
    var functions = catalyst.function;
    var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
    var functionPromise = functionObject.execute(config); await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 61, table);

            });
        })
        .catch((err) => {
            errorPrint(err, 61, responseBody, table);

        });
        return "completed";

}


 async function ajaxCall99() {
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
    await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 99, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 99, responseBody, table);
        });
        return "completed";
}
 async function ajaxCall100() {
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
    await functionPromise;
    functionPromise
        .then((response) => {
            response.json().then(responseBody => {
                responseValidation(responseBody, 100, table);
            });
        })
        .catch((err) => {
            errorPrint(err, 100, responseBody, table);
        });
        return "completed";
}

async function ajaxCall101() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase101",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 101, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 101, responseBody, table);
       });
       return "completed";
}
async function ajaxCall102() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase102",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 102, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 102, responseBody, table);
       });
       return "completed";
}
async function ajaxCall103() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase103",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 103, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 103, responseBody, table);
       });
       return "completed";
}
async function ajaxCall104() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase104",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 104, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 104, responseBody, table);
       });
       return "completed";
}
async function ajaxCall105() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase105",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 105, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 105, responseBody, table);
       });
       return "completed";
}
async function ajaxCall106() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase106",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 106, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 106, responseBody, table);
       });
       return "completed";
}
async function ajaxCall107() {
   var config = {
       "method": "POST",
       "args": {
           "case": "testCase107",
           "name": name
       }
   };
   var functions = catalyst.function;
   var functionObject = functions.functionId(1926000004343650); //can pass Function Id or Function Name as argument
   var functionPromise = functionObject.execute(config);
   await functionPromise;
   functionPromise
       .then((response) => {
           response.json().then(responseBody => {
               responseValidation(responseBody, 107, table);
           });
       })
       .catch((err) => {
           errorPrint(err, 107, responseBody, table);
       });
       return "completed";
}
async function validateFunction() {
    window.alert("Please enter a valid email address");
}

async function fillTestCases(){
  var temp="";
  var val1="";
  var val2="";
  console.log("inside fillTestCases");
  catalyst.auth.isUserAuthenticated().then(result => {
    console.log("auth check");
      var first_name = "First Name: " + result.content.first_name;
      console.log(first_name);
      document.getElementById("fname").innerHTML = first_name;
    //  document.getElementById("fname").style.display="block";
  }).catch(err => {});
  var table = document.getElementById("data_table");
  var query="Select * from TestcaseTable ORDER BY ID ;";
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

async function caseOrder(){
  for(var itr=1;itr<=table.rows.length-1;itr++){
    var functionName="ajaxCall"+itr;
    functionsArray.push(window[functionName]);
  }
  console.log(functionsArray);
  for (var func of functionsArray) {
        await func();
    }
    countCalculation();
    console.log("All functions completed");
}
function countCalculation() {
    timeEnd();
    var flag=false;
    var value = "";
    var failCount = 0;
    var passPercentage = 0;
    var table = document.getElementById("data_table");
    for (var i = 1; i <= table.rows.length - 1; i++) {
        value = "row" + i;
        if (document.getElementById(value).style.color != 'green') {
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
    document.getElementById("percentage").innerHTML = "Cases passed percentage - "+passPercentage;
    mailSend();
    totalTime();
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
