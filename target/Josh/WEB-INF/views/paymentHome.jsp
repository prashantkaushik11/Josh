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

<form:form action="${pageContext.request.contextPath}/payment/newPayment" method="post" commandName="transactionalDetail" >
<div class="container">
    <h1>Initiate Contribution! To Make This Event One Step Ahead Of Being Better</h1>
    <p class="lead">All This Contributed Money will be used on Prizes and Refreshments.</p>
    <hr>
    <form:hidden  path="name"  value="${transactionalDetail.name}" />
    <form:hidden  path="email"  value="${transactionalDetail.email}" />
    <form:hidden  path="phoneNo"  value="${transactionalDetail.phoneNo}" />
    <label for="name"><b>User Name</b></label>
    <input type="text" value="${transactionalDetail.name}" readonly="true" id="name" class="form-Control-element">

    <label for="email"><b>E: Mail</b></label>
    <input type="text" value="${transactionalDetail.email}" readonly="true" id="email" class="form-Control-element">

    <label for="phoneNo"><b>Phone No:</b></label>
    <input type="text" value="${transactionalDetail.phoneNo}" readonly="true" id="phoneNo" class="form-Control-element">

   <label for="amount"><b>Amount</b></label>
    <form:errors path="amount" cssStyle="color: #ff0000"/>
    <form:input path="amount" id="amount" class="form-Control-element"/>

    <label for="description"><b>Description</b></label>
    <form:errors path="description" cssStyle="color: #ff0000"/>
    <form:input path="description" id="description" class="form-Control-element"/>

    <hr>
    <button type="submit" class="registerbtn">Initiate Payment</button>
</div>
</form:form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>