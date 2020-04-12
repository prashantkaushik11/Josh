<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/front.css"/>">
</head>
<body>
<div class="container-wrapper">
    <div class="login-container">
        <div id="login-box">

            <h2>Login with Username and Password</h2>

            <c:if test="${not empty msg}">
                <div class="msg text-danger">${msg}</div>
            </c:if>

            <form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
                <c:if test="${not empty error}">
                    <div class="error" style="color: #ff0000;">${error}</div>
                </c:if>
                <div class="form-group">
                    <label for="username">User: </label>
                    <input type="text" id="username" name="username" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" class="form-control" />
                </div>

                <input type="submit" value="Submit" class="btn btn-default">

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>

        </div>
    </div>
    <div class="container">
        <div class="row">
            <div id="joshbanner" class="col-lg-12 ">
                <div class="content mb-2">
                    <h1>NEW USER-></h1>
                    <a href="<c:url value="/register"/>"><button class="btn btn-default btn-lg">REGISTER HERE!</button></a>
                    <hr>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp" %>
