<html>
	
	<head>
		<title>Library Site</title>
		<style><%@include file="/WEB-INF/view/appstyle.css"%></style>
	</head>
	
	<body>
		<h1>Library Management System</h1>
		<hr>
		<br><br>
		<form action="/book" method="post">   
	        <input type="submit" value="Book Details">       
    	</form> 
    	<br><br>
		<form action="/author" method="post">   
	        <input type="submit" value="Author Details">       
    	</form> 
    	<br><br>
		<form action="/publisher" method="post">   
	        <input type="submit" value="Publisher Details">       
    	</form> 
    	<br><br>
		<form action="/user" method="post">   
	        <input type="submit" value="User Details">       
    	</form> 
    	<br><br>
    	<form action="/login" method="get">   
	        <input type="submit" value="Logout">       
    	</form>
	</body>
	
</html>