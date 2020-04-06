<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 06-04-2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/resources/css/front.css"/>">
<script>
    function openSlideMenu(){
        document.getElementById('menu').style.width = '250px';
    }
    function closeSlideMenu(){
        document.getElementById('menu').style.width = '0';
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
        <a href="#">Home</a>
        <a href="#">About</a>
        <a href="#">Services</a>
        <a href="#">Portfolio</a>
        <a href="#">Contact</a>
    </div>
    <div class="pull-right">
       <i class="fa fa-user-circle-o" aria-hidden="true"></i> <a href="#"> LOGIN/REGISTER</a>
    </div>
</nav>