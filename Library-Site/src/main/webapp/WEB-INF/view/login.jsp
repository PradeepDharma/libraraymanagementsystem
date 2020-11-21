<html>
	
	<head>
		<title>Library Site</title>
		<style><%@include file="/WEB-INF/view/appstyle.css"%></style>
	</head>
	
	<body>
		<h1>Library Management System</h1>
		<hr>
		<form method="post">   
			<br><br> 
			<h4>${errormessage}</h4>
			<br><br>
	        <input type="text" name="uid" id="uid" placeholder="User ID" required>    
	        <br><br>    
	        <input type="password" name="password" id="password" placeholder="Password" required>    
	        <br><br>    
	        <input type="submit" value="Login">       
	        <br><br>    
    	</form> 
	</body>
	
</html>