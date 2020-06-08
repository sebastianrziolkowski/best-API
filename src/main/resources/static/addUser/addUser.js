var loginName;
var password;
var name;
var surname;
var age;
var addInfoText;

function getFieldInput() {
    loginName = document.getElementById('loginName');
    password = document.getElementById('password');
    name = document.getElementById('name');
    surname = document.getElementById('surname');
    age = document.getElementById('age');
    addInfoText = document.getElementById('addInfo');
}

function cleanFields() {
    getFieldInput();
    loginName.value = "";
    password.value = "";
    document.getElementById('name').value = "";
    surname.value = "";
    age.value = "";
    addInfoText.innerHTML = "";
}

function addUser() {
    var xmlhttp = new XMLHttpRequest();
    var theUrl = "/addUser";
    getFieldInput();
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            addInfoText.innerHTML = "User " + loginName.value + " correct added.";
            cleanFields();
        } else {
            addInfoText.innerHTML = "Something goes wrong!"
        }
    });
    xmlhttp.send(JSON.stringify({
        "loginName": loginName.value,
        "password": password.value,
        "name": document.getElementById('name').value,
        "surname": surname.value,
        "age": age.value
    }));
}

function addUserAndGoList() {
    addUser();
    window.location = "userList";
}

function logout() {
    sessionStorage.clear();
    window.location.replace('/');
}
