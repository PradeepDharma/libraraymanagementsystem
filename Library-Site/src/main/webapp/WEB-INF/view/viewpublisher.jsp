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
		  <li><a href="/publisher">Publisher Details</a></li>
		  <li class="active"><a href="/viewpublisher">Search Publisher</a></li>
		  <li><a href="/addpublisher">Add Publisher</a></li>
		  <li><a href="/updatepublisher">Update Publisher</a></li>
		  <li><a href="/deletepublisher">Delete Publisher</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
        Publisher Name : <input type="text" name="publishername" required/><br><br>
        <input type="submit" value="Search"/>
        
        <br><br>
        <table class="table">
		  <tbody>
		  <c:if test = "${publisherdetails.size() > 0}">
		  		<h5>Publisher status is ${publisherstatus}</h5> <br><br>
		  		<tr>
		    		<th>Book Name</th>
		    		<th>Book Category</th>
		    		<th>Book Author</th>
		    		<th>Book Status</th>
		    	</tr>
		    
		    <c:forEach items="${publisherdetails}" var="publisher">
		        <tr>
		            <td><c:out value="${publisher.getBookname()}" /></td>
		            <td><c:out value="${publisher.getBookcat()}" /></td>
		            <td><c:out value="${publisher.getBookauth()}" /></td>
		            <td><c:out value="${publisher.getBookstat()}" /></td>
		        </tr>
		    </c:forEach>
		    
		    </c:if>
		    
		    <c:if test = "${publisherdetails.size() == 0}">
		  		<h5>No records found</h5> <br><br>
		    </c:if>
		    
		    
		  </tbody>
		</table>
        
    </form>
</body>

</html>