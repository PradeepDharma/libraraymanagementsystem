<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
<title>Library Management System</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style><%@include file="/WEB-INF/view/appstyle.css"%></style>
</head>

<body>
	<h1>Library Management System</h1>
        <hr>
        <br>
    <form method="post">
		<ul class="nav nav-tabs">
		  <li><a href="/user">User Details</a></li>
		  <li class="active"><a href="/viewuser">Search User</a></li>
		  <li><a href="/adduser">Add User</a></li>
		  <li><a href="/updateuser">Update User</a></li>
		  <li><a href="/deleteuser">Delete User</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
		User ID : <input type="text" name="userid" required/><br><br>
        <input type="submit" value="Search"/>
        
        <br><br>
        <table class="table">
		  <tbody>
		  <c:if test = "${userdetails.size() > 0}">
		  		<tr>
		    		<th>User Name</th>
		    		<th>Book Name</th>
		    		<th>User Contact</th>
		    	</tr>
		    
		    <c:forEach items="${userdetails}" var="user">
		        <tr>
		            <td><c:out value="${user.getUsername()}" /></td>
		            <td><c:out value="${user.getBookname()}" /></td>
		            <td><c:out value="${user.getContact()}" /></td>
		        </tr>
		    </c:forEach>
		    
		    </c:if>
		    
		    <c:if test = "${userdetails.size() == 0}">
		  		<h5>No records found</h5> <br><br>
		    </c:if>
		    
		  </tbody>
		</table>
        
    </form>
</body>

</html>