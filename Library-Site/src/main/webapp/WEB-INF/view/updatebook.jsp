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
		  <li><a href="/viewbook">Search Book</a></li>
		  <li><a href="/addbook">Add Book</a></li>
		  <li class="active"><a href="/updatebook">Update Book</a></li>
		  <li><a href="/deletebook">Delete Book</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
		Book Name : <input type="text" name="bookname" required/><br><br>
        Book Status : 
        <input type="radio" id="avail" name="bookstatus" value="AVAILABLE" required>
		<label for="avail">Available</label>
		<input type="radio" id="notavail" name="bookstatus" value="NOT-AVAILABLE" required>
		<label for="notavail">Not Available</label><br><br>
        <input type="submit" value="Update"/>
        <br><br>
        <h3>${updateresult}</h3>
    </form>
</body>

</html>