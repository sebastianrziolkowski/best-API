var theUrl = "/loggedUser";


function logout() {
    sessionStorage.clear();
    window.location.replace('/');
}

window.addEventListener('load', function () {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            const user = JSON.parse(xmlhttp.response);
            document.getElementById('loginName').innerHTML = "Login: " + user.loginName;
            document.getElementById('name').innerHTML = "Name: " + user.name;
            document.getElementById('surname').innerHTML = "Surname: " + user.surname;
            document.getElementById('age').innerHTML = "Age: " + user.age;
        }
    });
    xmlhttp.send(sessionStorage.getItem('loginName'));
});
