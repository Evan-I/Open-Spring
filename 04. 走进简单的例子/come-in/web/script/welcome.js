window.onload = function() {
    let requestData = "personId=" + encodeURIComponent(getParam("personId"));
    let request = new XMLHttpRequest();
    request.onload = requestPersonInfoHandler;
    request.open("POST", "person_info");
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(requestData);
}

function requestPersonInfoHandler() {
    if(this.status == 200 && this.responseText != null) {
        let responseJson = JSON.parse(this.responseText);
        if(responseJson && responseJson.errorCode === "SUCCESS") {
            let personInfoBox = document.getElementById("person-info-box");
            personInfoBox.innerHTML = "<p>您好，" + responseJson.personName + "！</p>";
        } else {
            let personInfoBox = document.getElementById("person-info-box");
            personInfoBox.innerHTML = "<p>页面发生了严重错误，请重新登录！</p>";
        }
    }
}

function getParam(paramName) {
    let query = window.location.search.substring(1);
    let paramArray = query.split("&");
    for (let i = 0; i < paramArray.length; i++) {
        let paramPair = paramArray[i].split("=");
        if(paramPair[0] === paramName) {
            return paramPair[1];
        }
    }
    return null;
}