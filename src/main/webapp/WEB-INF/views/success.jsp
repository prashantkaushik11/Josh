
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

                <h2 class="text-success text-center">Your Payment is Successful! Thanks for Payment</h2>

            <h2 class="text-center">Payment Information</h2>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Payment Id:</div>
                </div>
                <div class="col-6">
                    <div class="text-right"><%=request.getParameter("payment_id")%></div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Payment Status:</div>
                </div>
                <div class="col-6">
                    <div class="text-right"><%=request.getParameter("payment_status")%></div>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-6">
                    <div class="text-left">Transaction Id:</div>
                </div>
                <div class="col-6">
                    <div class="text-right"><%=request.getParameter("transaction_id")%></div>
                </div>
            </div>
            <hr>
            <div class="row">

            <div class="text-center col-12">
                <a href="<c:url value="/"/>"><button class="btn btn-Info btn-lg">Home</button></a>
            </div>

            </div>
        </section>
    </div>
    <div class="col-3">

    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>
