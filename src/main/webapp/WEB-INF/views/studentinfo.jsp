<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 10-04-2020
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@include file="/WEB-INF/views/template/navigationhome.jsp" %>
<div class="row" style=" width:80%; margin: 100px 10px auto;">
    <div class="col-2">

    </div>
    <div class="col-5">
        <button class="btn btn-default btn-lg" onclick="displayForm()">Change Profile Picture!</button>
        <div id="photoUpload" style="display: none">
            <form:form action="${pageContext.request.contextPath}/student/studentInfo" method="post"
               commandName="student" enctype="multipart/form-data">

                <form:hidden  path="studentId"  value="${student.studentId}" />

                <div class="form-group">
                    <label class="control-label" for="studentImage">Set Profile Picture</label>
                    <form:input id="studentImage" path="studentImage" type="file" class="form:input-large" />
                </div>
                <input type="submit" value="submit" class="btn btn-default btn-lg">
            </form:form>
        </div>
    </div>
    <div class="col-5">
        <img src="<c:url value="/resources/images/${student.studentId}.png" /> " alt="image"
                 style="width:40%; margin: auto " class="border border-success"/>
    </div>
    <div class="col-2">

    </div>
</div>
<div class="row" style="margin-top:10px">
    <div class="col-2">

    </div>
    <div class="col-8">
        <section id="eventjumbotron2" class="jumbotron">
            <h2 class="text-center">Student Information</h2>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">StudentId:</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.studentId}</div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">StudentName:</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.studentName}</div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">CourseName:</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.course.courseId.courseName}</div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Year:</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.course.courseId.year}</div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Student Email</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.studentEmail}</div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Phone No:</div>
                </div>
                <div class="col-6">
                    <div class="text-right">${student.studentPhone}</div>
                </div>
            </div>
            <hr>
        </section>
    </div>
    <div class="col-2">

    </div>
</div>
<%@ include file="/WEB-INF/views/template/footer.jsp"%>


