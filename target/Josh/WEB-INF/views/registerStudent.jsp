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

<form:form action="${pageContext.request.contextPath}/register" method="post" commandName="wrapper" >
    <div class="container">
        <h1>Register Student</h1>
        <p class="lead">Please fill in this form to create an account.</p>
        <hr>

        <label for="name"><b>Name</b></label>
        <form:errors path="student.studentName" cssStyle="color: #ff0000"/>
        <form:input path="student.studentName" id="name" class="form-Control-element"/>

        <label for="username"><b>User Name</b></label>
        <span style="color: #ff0000">${usernameMsg}</span><form:errors path="student.username" cssStyle="color: #ff0000"/>
        <form:input path="student.username" id="username" class="form-Control-element"/>

        <label for="email"><b>E:mail</b></label>
        <span style="color: #ff0000">${emailMsg}</span><form:errors path="student.studentEmail" cssStyle="color: #ff0000"/>
        <form:input path="student.studentEmail" id="email" class="form-Control-element"/>

        <label for="courseName"><b>Course Name</b></label>
        <form:errors path="courseId.courseName" cssStyle="color: #ff0000"/>
        <form:select  path="courseId.courseName" id="courseName" class="form-Control-element">
            <form:options items="${coursesName}"></form:options>
        </form:select>

        <label for="yearsName"><b>Years Name</b></label>
        <form:errors path="courseId.year" cssStyle="color: #ff0000"/>
        <form:select  path="courseId.year" id="yearsName" class="form-Control-element">
            <form:options items="${yearsName}"></form:options>
        </form:select>

        <label for="phoneNo"><b>Phone Number</b></label>
        <form:errors path="student.studentPhone" cssStyle="color: #ff0000"/>
        <form:input path="student.studentPhone" id="phoneNo" class="form-Control-element"/>

        <label for="password"><b>Password</b></label>
        <form:errors path="student.password" cssStyle="color: #ff0000"/>
        <form:password path="student.password" id="password" class="form-Control-element"/>

        <label for="reTypePassword"><b>ReType:Password</b></label>
        <span style="color: #ff0000">${reTypePassword}</span> <form:errors path="student.reTypePassword" cssStyle="color: #ff0000"/>
        <form:password path="student.reTypePassword" id="reTypePassword" class="form-Control-element"/>

        <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="<c:url value="/login/" />">Login</a>.</p>
    </div>
</form:form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>