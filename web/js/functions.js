var loader = "loading";
var serverDomain = document.domain;
var serverContext = location.pathname.split('/')[1];
var serverPort = location.port;
var wsUrlAlarms = "ws://" + serverDomain + ":" + serverPort + "/" + serverContext + "/alarms";
var wsAlarms;

$(function() {
    $('table').footable();
});

function footable() {
    $(function() {
        $('table').footable();
    });
}

//==============================================================================
function loadWebSocket(wsPath) {

    try {

        new WebSocket(wsPath);

    } catch (e) {
        alertify.error("error loading ws");
    }

} // end loadWebSocket

//==============================================================================
(function alarms() {

    wsAlarms = new WebSocket(wsUrlAlarms);

    wsAlarms.onopen = function(e) {
    };
    wsAlarms.onclose = function(e) {
        //alertify.error("alerts doesn't work properly<br>the connection with the server has been closed");
    };
    wsAlarms.onmessage = function(e) {
        alertify.log(e.data);
        alarmStatus();
    };
    wsAlarms.onerror = function(e1, e2, e3) {
        alertify.error("error something is wrong, alerts doesn't work properly");
    };

})(); // end alarms

//==============================================================================
function taskTable() {

    $("#taskTableDiv").html(loader);

    $.ajax({
        url: "taskTable",
        type: "POST",
        success: function(data) {
            $("#taskTableDiv").html(data);
        }, error: function() {
            alertify.alert("sorry we have an error");
        }
    });

}

//==============================================================================
function createTask() {

    var name = document.taskForm.name.value;
    var urls = document.taskForm.urls.value;
    var trigger = document.taskForm.trigger.value;
    var method = document.taskForm.method.value;
    var timeout = document.taskForm.timeout.value;
    var period = document.taskForm.period.value;
    var email = document.taskForm.email.value;
    var sms = document.taskForm.sms.value;

    //validation
    if (name == "" || name == undefined) {
        alertify.alert("name is incorrect");
        return;
    }

    if (urls.search("http://") == -1) {
        alertify.alert("url doesn't contains http://");
        return;
    }

    if (urls == "" || urls == undefined) {
        alertify.alert("url is incorrect");
        return;
    }

    if (trigger == "" || trigger == undefined || isNaN(trigger) || trigger < 1) {
        alertify.alert("trigger is incorrect");
        return;
    }

    if (period == "" || period == undefined || isNaN(period) || period < 1) {
        alertify.alert("period is incorrect");
        return;
    }

    if (timeout == "" || timeout == undefined || isNaN(timeout) || timeout < 1) {
        alertify.alert("timeout is incorrect");
        return;
    }

    if (email == "" && sms == "") {
        alertify.alert("please choose a notification way");
        return;
    }

    if (email != "") {
        if (email.search("@") == -1) {
            alertify.alert("e-mail incorrect");
            return;
        }
    }

    if (sms != "") {
        if (sms.length < 8) {
            alertify.alert("sms incorrect");
            return;
        }
    }
    
    $.ajax({
        url: "createTask",
        type: "POST",
        data: {
            name: name,
            url: urls,
            trigger: trigger,
            method: method,
            timeout: timeout,
            period: period,
            email:email,
            sms:sms
        }, success: function(data) {
            document.taskForm.reset();
            alertify.alert(data);
        }, error: function() {
            alertify.alert("sorry we have an error");
        }

    });

}

//==============================================================================
function deleteTask(id) {

    if (id == "" || id == undefined || isNaN(id) || id < 1) {
        alertify.alert("sorry we have an error");
        return;
    }

    alertify.confirm("Are you sure of delete this task", function(e) {
        if (e) {
            $.ajax({
                url: "deleteTask",
                type: "POST",
                data: {
                    id: id
                }, success: function(data) {                    
                    taskTable();
                }, error: function() {
                    alertify.alert("sorry we have an error");
                }

            });
        } else {
            // user clicked "cancel"
        }
    });

}