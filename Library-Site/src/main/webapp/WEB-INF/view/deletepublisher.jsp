\<html>

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
		  <li><a href="/pupblisher">Publisher Details</a></li>
		  <li><a href="/viewpublisher">Search Publisher</a></li>
		  <li><a href="/addpublisher">Add Publisher</a></li>
		  <li><a href="/updatepublisher">Update Publisher</a></li>
		  <li class="active"><a href="/deletepublisher">Delete Publisher</a></li>
		  <li><a href="/home">Return to home page</a></li>
		</ul>
		<br>
		<br>
		Publisher Name : <input type="text" name="publishername" required/><br><br>
        <input type="submit" value="Delete"/>
        <br><br>
        <h3>${deleteresult}</h3>
    </form>
</body>

</html>