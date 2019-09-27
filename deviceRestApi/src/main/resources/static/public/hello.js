$(document).ready(function() {
    $.ajax({
        url: "http://localhost:8080/getDevices"
    }).then(function(data, status, jqxhr) {
       $('.device-id').append(data.id);
       $('.device-model').append(data.content);
       console.log(jqxhr);
    });
});
