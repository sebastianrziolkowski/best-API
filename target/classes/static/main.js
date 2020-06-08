function checkPassword() {
    var loginName = document.getElementById("loginName").value;
    var password = document.getElementById("password").value;

    var xmlhttp = new XMLHttpRequest();
    var theUrl = "/authorization";
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.onload  = function() {
        if(xmlhttp.response === "true"){
            sessionStorage.setItem('loginName', loginName);
            sessionStorage.setItem('password', password);
            window.location = "panel";
        }
        else{
            console.log("Wrong password or login name!");
            document.querySelector("span").innerText = "Wrong password or login name!";
        }
    };
    xmlhttp.send(JSON.stringify({"loginName":loginName,"password":password}));
}