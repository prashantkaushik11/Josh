<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@include file="/WEB-INF/views/template/navigationhome.jsp" %>
<div id="carouselExampleIndicators" class="carousel slide carousel-fade mt-5 d-none d-sm-block "data-interval="3000" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="carousel-item active" id="slide1">
        </div>
        <div class="carousel-item" id="slide2">
        </div>
        <div class="carousel-item" id="slide3">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<div class="container">
    <div class="row">
        <div id="joshbanner" class="col-lg-12 ">
            <div class="content mb-2">
                <h1>JOSH'19</h1>
                <h3>The Annual Sports Fest Of MNNIT</h3>
                <hr>
            </div>
        </div>
    </div>
</div>
<section id="eventjumbotron" class="jumbotron text-center mt-0">
    <p class="card-text text-center">MNNIT is equipped with the state of of the art facility in the sector of sports. JOSH organises 22 sports events with a huge participation of both boys and girls from college across the courses. Over 400 students participants take part in a broad spectrum of fine sports events and informal events.</p>
    <h2 class="card-title ">LET's PLAY</h2>
</section>
<section class="container-fluid px-0">
    <div class="row align-items-center content">
        <div class="col-md-6 order-2 order-md-1">
            <img src="<c:url value="/resources/images/cricket.jpg" />" alt="" class="img-fluid">
        </div>
        <div class="col-md-6 text-center order-1 order-md-2">
            <div class="row justify-content-center">
                <div class="col-10 col-lg-8 blurb mb-5 mb-md-0">
                    <h2>CRICKET!</h2>
                    <p class="lead">Give yourself a chance to be a part of the most loved game of India.</p>
                    <c:if test="${pageContext.request.userPrincipal.name!=null}">
                        <a href="<c:url value="/student/cricket/register"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/student/document/display"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name==null}">
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center content">
        <div class="col-md-6 text-center">
            <div class="row justify-content-center">
                <div class="col-10 col-lg-8 blurb mb-5 mb-md-0">
                    <h2>HOCKEY!</h2>
                    <p class="lead">Give yourself a chance to be a part of the field hockey event</p>
                    <c:if test="${pageContext.request.userPrincipal.name!=null}">
                        <a href="<c:url value="/student/hockey/register"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/student/document/display"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name==null}">
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <img src="<c:url value="/resources/images/hockey.jpg" />" alt="" class="img-fluid">
        </div>
    </div>
    <div class="row align-items-center content">
        <div class="col-md-6 order-2 order-md-1">
            <img src="<c:url value="/resources/images/football.jpg" />" alt="" class="img-fluid">
        </div>
        <div class="col-md-6 text-center order-1 order-md-2">
            <div class="row justify-content-center">
                <div class="col-10 col-lg-8 blurb mb-5 mb-md-0">
                    <h2>FOOTBALL!</h2>
                    <p class="lead">Give yourself a chance to be a part of the most played game of world </p>
                    <c:if test="${pageContext.request.userPrincipal.name!=null}">
                        <a href="<c:url value="/student/football/register"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/student/document/display"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name==null}">
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
    <div class="row align-items-center content">
        <div class="col-md-6 text-center">
            <div class="row justify-content-center">
                <div class="col-10 col-lg-8 blurb mb-5 mb-md-0">
                    <h2>KABBADDI!</h2>
                    <p class="lead">Give yourself a chance to be a part of one of the most ancient game of world </p>
                    <c:if test="${pageContext.request.userPrincipal.name!=null}">
                        <a href="<c:url value="/student/kabaddi/register"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/student/document/display"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name==null}">
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Register Here!</button></a>
                        <a href="<c:url value="/login/"/>"><button class="btn btn-default btn-lg">Download Rules!</button></a>
                    </c:if>
                </div>
            </div>
        </div>
        <div class="col-md-6">
            <img src="<c:url value="/resources/images/kabaddi.jpg" />" alt="" class="img-fluid">
        </div>
    </div>
</section>
<%@include file="/WEB-INF/views/template/footer.jsp" %>