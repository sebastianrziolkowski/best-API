var getDeviceListUrl = "/devices";
var addDeviceUrl = "/addDevice";
var rentDeviceUrl = "/addDeviceRental";
var unavailableDeviceUrl = "/setDeviceUnavailable";
var getUserByIdUrl = "/userByLoginName";
var getDeviceByIdUrl = "/deviceById";

var GET_METHOD = "GET";
var POST_METHOD = "POST";

function logout() {
    sessionStorage.clear();
    window.location.replace('/');
}

function rentDevice() {
    var deviceId = parseInt(document.getElementById("deviceToRentId").value);
    unavailableDevice(deviceId);
    rentDeviceService(deviceId);
}

function unavailableDevice(deviceId) {
    sendXmlHttpRequest(unavailableDeviceUrl, POST_METHOD, deviceId)
}

function rentDeviceService(deviceId) {
    var loginName = sessionStorage.getItem('loginName');

    var user = sendXmlHttpRequestTakeResponse(getUserByIdUrl, POST_METHOD, loginName);
    var device = sendXmlHttpRequestTakeResponse(getDeviceByIdUrl, POST_METHOD, deviceId);
    sendXmlHttpRequest(rentDeviceUrl, POST_METHOD, {user: user}, {device: device})
}

function sendXmlHttpRequest(url, method, message) {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open(method, url);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.send(JSON.stringify(message));
}


function sendXmlHttpRequestTakeResponse(url, method, message) {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open(method, url);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            console.log(xmlhttp);
            return xmlhttp.response;
        } else {
            return xmlhttp.status;
        }
    });

    xmlhttp.send(message);
}

function addDevice() {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", addDeviceUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            if (xmlhttp.response === "true")
                location.reload()
            else console.log("Can't add device.")
        }
    });
    xmlhttp.send();
}


window.addEventListener('load', function () {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", getDeviceListUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            const rows = JSON.parse(xmlhttp.response);

            var html = '<table>';
            html += '<tr>';
            for (var j in rows[0]) {
                html += '<th>' + j + '</th>';
            }
            html += '</tr>';
            for (var i = 0; i < rows.length; i++) {
                html += '<tr>';
                for (var j in rows[i]) {
                    html += '<td>' + rows[i][j] + '</td>';
                }
                html += '</tr>';
            }
            html += '</table>';
            document.getElementById('container').innerHTML = html;


        }
    });
    xmlhttp.send();
});