<%@ page import="java.util.List" %>
<%@ page import="com.dream.service.ServicePersonInfoResult" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>人的信息</title>
</head>
<body style="background: #eee;">
<%
    List<ServicePersonInfoResult> personList = (List<ServicePersonInfoResult>)request.getAttribute("personList");
    for(ServicePersonInfoResult person: personList) {
        out.print("<p>您好！我是" + person.getName() + "，是个" + person.getGender() + "！</p>");
    }
%>
</body>
</html>