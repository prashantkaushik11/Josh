<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 12-04-2020
  Time: 00:38
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<%@include file="/WEB-INF/views/template/navigationhome.jsp" %>

<div class="container-wrapper " style="margin-top: 100px">
    <div class="container">
        <div class="page-header">
            <h1>All Documents</h1>

            <p class="lead">Here Are All the Documents for Downloads</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Document</th>
                <th>Document Name</th>
                <th>DocumentType</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${documentList}" var="document">
                <tr>
                    <td><td><embed src="<c:url value="/resources/file/${document.documentId}.pdf" /> " type="application/pdf" style="width:100%"/></td></td>
                    <td>${document.documentName}</td>
                    <td>${document.documentType}</td>
                    <td> <a href="<c:url value="/admin/document/delete/${document.documentId}"/>"><button class="btn btn-danger btn-lg">Delete</button></a> <td>
                </tr>
            </c:forEach>
        </table>

<%@include file="/WEB-INF/views/template/footer.jsp" %>