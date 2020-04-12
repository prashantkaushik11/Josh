<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 11-04-2020
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/register.css"/>">
</head>
<body>
<form:form action="${pageContext.request.contextPath}/admin/addDocument" method="post" commandName="document" enctype="multipart/form-data">
<div class="container">
    <h1>Register Document</h1>
    <p class="lead">Please fill in this form to create a Document.</p>
    <hr>

    <label for="name"><b>Document Name</b></label>
    <form:errors path="documentName" cssStyle="color: #ff0000"/>
    <form:input path="documentName" id="name" class="form-Control-element"/>

    <label for="type"><b>Document Type </b></label>
    <form:errors path="documentType" cssStyle="color: #ff0000"/>
    <form:select  path="documentType" id="type" class="form-Control-element">
        <form:options items="${types}"></form:options>
    </form:select>

    <label for="uploadFile"><b>Upload File Here</b></label>
    <form:errors path="document" cssStyle="color: #ff0000"/>
    <form:input path="document" id="uploadFile" type="file"  class="form-Control-element"/>

    <button type="submit" class="registerbtn">Register Document</button>
</div>
</form:form>
<%@include file="/WEB-INF/views/template/footer.jsp"%>