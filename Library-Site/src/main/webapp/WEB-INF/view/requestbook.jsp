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
    <table>
    	<tr>
    		<td>
    			<form method="post" action="/availbook">
			    	<input type="submit" value="Available Books"/>
			    </form>
    		</td>
    		<td>
    			<form method="post" action="/allbook">
			    	<input type="submit" value="All Books"/>
			    </form>
    		</td>
    		<td>
    			<form action="/login" method="get">   
		        <input type="submit" value="Logout">       
	    	</form>
    		</td>
    	</tr>
    </table>    
    
    
    <table>
    	<tr>
    		<td>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</td>
    		<td>
    			
    			<form method="post" action="/usersearchbook">
					<h4>Search books</h4><br><br>
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
			   </form>
    		</td>
    		
    		<td>
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    		</td>
    		
    		<td>
    			<form method="post" action="/lendbook">
					<h4>Lend books</h4><br><br>
			        Book Name : <input type="text" name="bookname" required/><br><br>
			        Provide your ID: <input type="text" name="uid" required/><br><br>
			        <input type="submit" value="Lend"/>
			        <h3>${bookstatus}</h3>
			   </form>
    		</td>
    	</tr>
    </table>
    
   
        
        
        <br><br>
        <table class="table">
		  <tbody>
		  <c:if test = "${allbookdetails.size() > 0}">
		  		<tr>
		    		<th>Book Name</th>
		    		<th>Book Category</th>
		    		<th>Book Author</th>
		    		<th>Book Publisher</th>
		    		<th>Book Status</th>
		    	</tr>
		    
		    <c:forEach items="${allbookdetails}" var="book">
		        <tr>
		            <td><c:out value="${book.getBookname()}" /></td>
		            <td><c:out value="${book.getBookcat()}" /></td>
		            <td><c:out value="${book.getBookauth()}" /></td>
		            <td><c:out value="${book.getBookpub()}" /></td>
		            <td><c:out value="${book.getBookstat()}" /></td>
		        </tr>
		    </c:forEach>
		    
		    </c:if>
		    
		    <c:if test = "${allbookdetails.size() == 0}">
		  		<h5>No records found</h5> <br><br>
		    </c:if>
		    
		  </tbody>
		</table>
        
</body>

</html>