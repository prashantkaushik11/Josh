<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 08-04-2020
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@include file="/WEB-INF/views/template/navigationhome.jsp" %>
<div class="row" style="margin-top:100px">
    <div class="col-3">

    </div>
    <div class="col-6">
    <section id="eventjumbotron2" class="jumbotron">
        <c:set var = "studentName" scope = "session" value = "${gameInfo.registeredStudentName}"/>
        <c:if test="${pageContext.request.userPrincipal.name==studentName}">
            <h2 class="text-success text-center">REGISTERED SUCCESSFULLY!</h2>
            <p class="card-text text-center">The Team is Registered SuccessFully. For this Event, Each Course has a year wise Separate Team. No Merging and no more than 1 team from a particular course from particular year is entertained </p>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name!=studentName}">
            <p class="card-text text-center">The Team of This Course With the same year is Already Registered. For this Event, Each Course has a year wise Separate Team. No Merging and no more than 1 team from a particular course from particular year is entertained </p>
        </c:if>
        <h2 class="text-center">Team Information</h2>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">TeamId:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${TeamId}</div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">TeamName:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${gameInfo.teamName}</div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">CourseName:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${gameInfo.course.courseId.courseName}</div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">Year:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${gameInfo.course.courseId.year}</div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">Team Registered By:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${gameInfo.registeredStudentName}</div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-6">
                <div class="text-left">Phone No:</div>
            </div>
            <div class="col-6">
                <div class="text-right">${gameInfo.firstPhoneNumber}</div>
            </div>
        </div>
        <hr>
        <div class="row">

            <div class="text-center col-12">

                <c:if test="${pageContext.request.userPrincipal.name==studentName}">
                    <a href="<c:url value="removeteam/${TeamId}"/>"><button class="btn btn-danger btn-lg">Remove Team</button></a>
                </c:if>
            </div>

        </div>
    </section>
    </div>
    <div class="col-3">

    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
