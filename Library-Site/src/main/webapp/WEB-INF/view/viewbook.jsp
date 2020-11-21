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
		  <li><a href="/book">Book Details</a></li>
		  <li class="active"><a href="/viewbook">Search Book</a></li>
		  <li><a href="/addbook">Add Book</a></li>
		  <li><a href="/updatebook">Update Book</a></li>
		  <li><a href="/deletebook">Delete Book</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
		Search By : 
		<input type="radio" id="bookname" name="searchtype" value="bookname" required>
		<label for="bookname">Book Name</label>
		<input type="radio" id="bookcategory" name="searchtype" value="bookcategory" required>
		<label for="bookcategory">Book Category</label>
		<input type="radio" id="authorname" name="searchtype" value="authorname" required>
		<label for="authorname">Author Name</label>
		<input type="radio" id="publishername" name="searchtype" value="publishername" required>
		<label for="publishername">Publisher Name</label><br><br>
        Search keyword : <input type="text" name="keyword" required/><br><br>
        <input type="submit" value="Search"/>
        
        <br><br>
        <table class="table">
		  <tbody>
		  <c:if test = "${bookdetails.size() > 0}">
		  		<tr>
		    		<th>Book Name</th>
		    		<th>Book Category</th>
		    		<th>Book Author</th>
		    		<th>Book Publisher</th>
		    		<th>Book Status</th>
		    	</tr>
		    
		    <c:forEach items="${bookdetails}" var="book">
		        <tr>
		            <td><c:out value="${book.getBookname()}" /></td>
		            <td><c:out value="${book.getBookcat()}" /></td>
		            <td><c:out value="${book.getBookauth()}" /></td>
		            <td><c:out value="${book.getBookpub()}" /></td>
		            <td><c:out value="${book.getBookstat()}" /></td>
		        </tr>
		    </c:forEach>
		    
		    </c:if>
		    
		    <c:if test = "${bookdetails.size() == 0}">
		  		<h5>No records found</h5> <br><br>
		    </c:if>
		    
		  </tbody>
		</table>
        
        
        
        
    </form>
</body>

</html>