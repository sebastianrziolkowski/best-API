function logout() {
    sessionStorage.clear();
    window.location.replace('/');
}

var theUrl = "/users";

window.addEventListener('load', function () {
    const xmlhttp = new XMLHttpRequest();
    xmlhttp.open("GET", theUrl);
    xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xmlhttp.addEventListener('load', function () {
        if (xmlhttp.status === 200) {
            const rows = JSON.parse(xmlhttp.response);

            var html = '<table>';
            html += '<tr>';
            for( var j in rows[0] ) {
                html += '<th>' + j + '</th>';
            }
            html += '</tr>';
            for( var i = 0; i < rows.length; i++) {
                html += '<tr>';
                for( var j in rows[i] ) {
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