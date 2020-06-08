var loginName;
var password;
var name;
var surname;
var age;
var id;


function editUser() {
    var xmlhttp = new XMLHttpRequest();
    var theUrl = "/addUser";
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            console.log(xmlhttp.status)
            sessionStorage.clear();
            sessionStorage.setItem('loginName', loginName.value);
            sessionStorage.setItem('password', password.value);
            document.querySelector("span").innerText = "User was updated!";
        } else {
            addInfoText.innerHTML = "Something goes wrong!"
        }
    });
    xmlhttp.send(JSON.stringify({
        "id": id.value,
        "loginName": loginName.value,
        "password": password.value,
        "name": document.getElementById('name').value,
        "surname": surname.value,
        "age": age.value
    }));
}

function goPanel() {
    window.location = "panel";
}


function editUserAndGo() {
    editUser();
}


window.addEventListener('load', function () {

    loginName = document.getElementById('loginName');
    password = document.getElementById('password');
    name = document.getElementById('name');
    surname = document.getElementById('surname');
    age = document.getElementById('age');
    id = document.getElementById('id');

    var xmlhttp = new XMLHttpRequest();
    var theUrl = "/loggedUser";
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            const user = JSON.parse(xmlhttp.response);

            id.value = user.id;
            loginName.value = user.loginName;
            name.value = user.name;
            surname.value = user.surname;
            password.value = user.password;
            age.value = user.age;
        }
    });
    xmlhttp.send(sessionStorage.getItem('loginName'));
});