<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 06-04-2020
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/register.css"/>">
</head>
<body>

<form:form action="${pageContext.request.contextPath}/student/football/register" method="post" commandName = "football" >

<div class="container">
    <h1>Register FootBall Team</h1>
    <p class="lead">Please fill in this form to create an account.</p>
    <hr>

    <label for="teamName"><b>Team Name</b></label>
    <form:errors path="teamName" cssStyle="color: #ff0000"/>
    <form:input path="teamName" id="teamName" class="form-Control-element"/>

    <label for="registerStudent"><b>Registered Student User Name</b></label>
    <form:input path="registeredStudentName" id="registerStudent" readonly="true" class="form-Control-element"/>

    <label for="courseName"><b>Course Name</b></label>
    <input type="text" value="${sessionScope.course.courseId.courseName}" readonly="true" id="courseName" class="form-Control-element">

    <label for="year"><b>Year</b></label>
    <input type="text" value="${sessionScope.course.courseId.year}" readonly="true" id="year" class="form-Control-element">

    <label for="phoneNo1"><b>Phone Number 1.</b></label>
    <form:errors path="firstPhoneNumber" cssStyle="color: #ff0000"/>
    <form:input path="firstPhoneNumber" id="phoneNo1" readonly="true" class="form-Control-element"/>

    <label for="phoneNo2"><b>Phone Number 2.</b></label>
    <form:errors path="secondPhoneNumber" cssStyle="color: #ff0000"/>
    <form:input path="secondPhoneNumber" id="phoneNo2" class="form-Control-element"/>

    <hr>
    <p>Remember This is the Course Game Only One Team Across Every Course </p>

    <button type="submit" class="registerbtn">Register</button>
</div>
</form:form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>