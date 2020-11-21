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
		  <li><a href="/viewauthor">Search Author</a></li>
		  <li class="active"><a href="/addauthor">Add Author</a></li>
		  <li><a href="/updateauthor">Update Author</a></li>
		  <li><a href="/deleteauthor">Delete Author</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
		Author Name : <input type="text" name="authorname" required/><br><br>
		Book Name : <input type="text" name="bookname" required/><br><br>
        Author Status : 
        <input type="radio" id="active" name="authorstatus" value="Active" required>
		<label for="active">Active</label>
		<input type="radio" id="inactive" name="authorstatus" value="Inactive" required>
		<label for="inactive">Inactive</label><br><br>
        <input type="submit" value="Add"/>
        <br><br>
        <h3>${addresult}</h3>
    </form>
</body>

</html>