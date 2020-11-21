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
		  <li><a href="/author">Author Details</a></li>
		  <li class="active"><a href="/viewauthor">Search Author</a></li>
		  <li><a href="/addauthor">Add Author</a></li>
		  <li><a href="/updateauthor">Update Author</a></li>
		  <li><a href="/deleteauthor">Delete Author</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
        Author Name : <input type="text" name="authorname" required/><br><br>
        <input type="submit" value="Search"/>
        
        <br><br>
        <table class="table">
		  <tbody>
		  <c:if test = "${authordetails.size() > 0}">
		  		<h5>Author status is ${authorstatus}</h5> <br><br>
		  		<tr>
		    		<th>Book Name</th>
		    		<th>Book Category</th>
		    		<th>Book Publisher</th>
		    		<th>Book Status</th>
		    	</tr>
		    
		    <c:forEach items="${authordetails}" var="author">
		        <tr>
		            <td><c:out value="${author.getBookname()}" /></td>
		            <td><c:out value="${author.getBookcat()}" /></td>
		            <td><c:out value="${author.getBookpub()}" /></td>
		            <td><c:out value="${author.getBookstat()}" /></td>
		        </tr>
		    </c:forEach>
		    
		    </c:if>
		    
		    <c:if test = "${authordetails.size() == 0}">
		  		<h5>No records found</h5> <br><br>
		    </c:if>
		    
		    
		  </tbody>
		</table>
        
    </form>
</body>

</html>