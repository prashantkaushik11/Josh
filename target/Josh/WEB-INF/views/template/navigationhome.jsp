<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 06-04-2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<link rel="stylesheet" href="<c:url value="/resources/css/front.css"/>">
<script>
    function openSlideMenu(){
        document.getElementById('menu').style.width = '250px';
    }
    function closeSlideMenu(){
        document.getElementById('menu').style.width = '0';
    }
    function displayForm(){
        document.getElementById('photoUpload').style.display='block';
    }
</script>
</head>
<body>
<nav id="mainNavbar" class="navbar navbar-light py-0 fixed-top">
    <a href="#" class="navbar-brand slide " >
        <button class="navbar-toggler" data-toggle="collapse"  onclick="openSlideMenu()">
            <span class="navbar-toggler-icon"></span>
        </button>
        JOSH
    </a>
    <div class="Nav" id="menu">
        <a href="#" class="close" onclick="closeSlideMenu()">
            <i class="fa fa-times"></i>
        </a>
        <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
            <a href="<c:url value="/"/>">Home</a>
            <a href="<c:url  value="/admin/document/display"/>">Display Documents</a>
            <a href="<c:url  value="/admin/document/addDocument"/>">Add Document</a>
            <a href="<c:url  value="/admin/document/deleteDocument"/>">Delete Document</a>
            <a href="#">Portfolio</a>
            <a href="#">Contact</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
            <a href="<c:url value="/"/>">Home</a>
            <a href="#">My Info</a>
            <a href="<c:url  value="/student/document/display"/>">Downloads</a>
            <a href="#">Portfolio</a>
            <a href="#">Contact</a>
        </c:if>

    </div>
    <div class="pull-right">
        <c:if test="${pageContext.request.userPrincipal.name!=null}">
            <a href="<c:url value="/student/studentInfo" />">Welcome: ${pageContext.request.userPrincipal.name}</a>
            <a href="<c:url value="/j_spring_security_logout" />" style="color:#003366;"> Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name  == null}">
            <i class="fa fa-user-circle-o" aria-hidden="true"></i> <a href="<c:url value="/login/"/>"> LOGIN/REGISTER</a>
        </c:if>
    </div>
</nav>