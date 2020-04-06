<%--
  Created by IntelliJ IDEA.
  User: PRASHANT
  Date: 06-04-2020
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/register.css"/>">
</head>
<body>

<form action="/action_page.php">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Name" name="name">

        <label for="userName"><b>User Name</b></label>
        <input type="text" placeholder="Enter User Name" name="userName">

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email">

        <label for="courseName"><b>Course Name</b></label>
        <select class="form-control" id="courseName">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
        </select>

        <label for="phoneNo"><b>Phone Number</b></label>
        <input type="text" placeholder="Enter PhoneNo" name="phoneNo">

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required>

        <label for="psw-repeat"><b>Repeat Password</b></label>
        <input type="password" placeholder="Repeat Password" name="psw-repeat" required>
        <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="#">Sign in</a>.</p>
    </div>
</form>
<%@include file="/WEB-INF/views/template/footer.jsp" %>