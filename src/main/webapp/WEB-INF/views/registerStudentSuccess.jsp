<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 07-04-2020
  Time: 01:42
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/front.css"/>">
</head>
</body>
<div class="display-2 text-success d-flex justify-content-center">REGISTERED SUCCESSFULLY.</div>
<div class="container">
    <div class="row">
        <div id="joshbanner" class="col-lg-12 ">
            <div class="content mb-2">
                <h1>HOME-></h1>
                <a href="<c:url value="/"/>"><button class="btn btn-default btn-lg">Click Here!</button></a>
                <hr>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div id="joshbanner" class="col-lg-12 ">
            <div class="content mb-2">
                <h1>LOGIN-></h1>
                <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">LOGIN!</button></a>
                <hr>
            </div>
        </div>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>