window.onload = function() {
    requestPersonInfo();
}
function requestPersonInfo() {
    var request = new XMLHttpRequest();
    request.onload = requestPersonInfoHandler;
    request.open("GET", "person_info");
    request.send();
}
function requestPersonInfoHandler() {
    if(this.status == 200 && this.responseText != null) {
        var responseJson = JSON.parse(this.responseText);
        var personInfoPanel = document.getElementById("personInfoPanel");
        if (personInfoPanel) {
            personInfoPanel.innerHTML = processPersonInfo(responseJson);
        }
    }
}
function processPersonInfo(personInfoJson) {
    var personInfo = "";
    for(var i = 0; i < personInfoJson.length; i++) {
        var person = personInfoJson[i];
        personInfo += "<p>您好！我是" + person.name + "，是个" + person.gender + "！</p>";
    }
    return personInfo;
}