window.onload = function() {
    let logonPhoneText = document.getElementById("logon-phone-text");
    let logonPasswordText = document.getElementById("logon-password-text");
    let logonButton = document.getElementById("logon-button");

    logonPhoneText.onfocus = onLogonPhoneTextFocus;
    logonPhoneText.onblur = onLogonPhoneTextBlur;
    logonPasswordText.onfocus = onLogonPasswordTextFocus;
    logonPasswordText.onblur = onLogonPasswordTextBlur;
    logonButton.onclick = onLogonButtonClick;
}

function onLogonPhoneTextFocus() {
    let logonPhoneHint = document.getElementById("logon-phone-hint");
    logonPhoneHint.style.display = "none";
}

function onLogonPhoneTextBlur() {
    let logonPhoneText = document.getElementById("logon-phone-text");
    let logonPhoneHint = document.getElementById("logon-phone-hint");
    logonPhoneHint.style.display = (logonPhoneText.value.length === 0 ? "block" : "none");
}

function onLogonPasswordTextFocus() {
    let logonPasswordHint = document.getElementById("logon-password-hint");
    logonPasswordHint.style.display = "none";
}

function onLogonPasswordTextBlur() {
    let logonPasswordText = document.getElementById("logon-password-text");
    let logonPasswordHint = document.getElementById("logon-password-hint");
    logonPasswordHint.style.display = (logonPasswordText.value.length === 0 ? "block" : "none");
}

function onLogonButtonClick() {
    if(validateLogon()) {
        let phoneText = document.getElementById("logon-phone-text");
        let passwordText = document.getElementById("logon-password-text");
        let phone = eraseSpace(phoneText.value.trim());
        let password = passwordText.value;
        requestLogon(phone, password);
    }
}

function validateLogon() {
    let phoneText = document.getElementById("logon-phone-text");
    let phone = eraseSpace(phoneText.value.trim());
    if (phone.length === 0) {
        showMessage("请输入手机号码！", "知道了", null);
        return false;
    }
    if (!isPhoneValid(phone)) {
        showMessage("手机号码输错了！", "知道了", null);
        return false;
    }

    let passwordText = document.getElementById("logon-password-text");
    let password = passwordText.value;
    if (password.length === 0) {
        showMessage("请输入密码！", "知道了", null);
        return false;
    }
    if (password.length < 6) {
        showMessage("密码输错了！", "知道了", null);
        return false;
    }
    return true;
}

function requestLogon(phone, password) {
    let requestData = "phone=" + encodeURIComponent(phone)
                    + "&password=" + encodeURIComponent(password);
    let request = new XMLHttpRequest();
    request.onload = requestLogonHandler;
    request.open("POST", "logon");
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send(requestData);
}

function requestLogonHandler() {
    if(this.status == 200 && this.responseText != null) {
        let responseJson = JSON.parse(this.responseText);
        if(responseJson && responseJson.errorCode === "SUCCESS") {
            window.location.replace("welcome.html?personId=" + responseJson.personId);
        } else if (responseJson && responseJson.errorCode === "ERROR_CREDENTIAL") {
            showMessage("手机或密码输错了，请重新输入！", "知道了", null);
        } else {
            showMessage("登录失败。页面发生了严重错误，请重试！", "知道了", null);
        }
    }
}

function isPhoneValid(value) {
    return /^1[0-9]{10}$/.test(value);
}

function eraseSpace(value) {
    return value.replace(/ /gi, "");
}

function showMessage(msg, okButtontext, okButtonAction) {
    let messageBox = document.createElement("div");
    messageBox.id = "message-box";
    messageBox.innerHTML = ""
        + "<div class='-modal' style='z-index:900000000'></div>"
        + "<div class='-modal-body' style='top:50%;left:50%;width:492px;height:40px;padding:6px;margin:-58px 0px 0px -255px;border-left:6px solid #3b5999;border-radius:3px 0px 0px 3px;line-height:40px;z-index:910000000;'>"
        + "    <span style='float:left;width:398px;height:40px;'>" + msg + "</span>"
        + "    <input id='message-box-ok-button' type='button' value='" + okButtontext + "' style='float:right;width:88px;height:40px;border-width:0px;font-size:16px;font-weight:bold;line-height:40px;background-color:#558543;color:white;cursor:pointer;'>"
        + "</div>";
    document.body.appendChild(messageBox);

    let messageBoxOkButton = document.getElementById("message-box-ok-button");
    messageBoxOkButton.onmouseenter = function() {
        messageBoxOkButton.style.background = "#699857";
    };
    messageBoxOkButton.onmouseleave = function() {
        messageBoxOkButton.style.background = "#558543";
    };
    messageBoxOkButton.onclick = function() {
        document.body.removeChild(messageBox);
        if(okButtonAction) {
            okButtonAction();
        }
    };
}