<html>
	
	<head>
		<title>Library Site</title>
		
		  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		  <style><%@include file="/WEB-INF/view/appstyle.css"%></style>
	</head>
	
	<body>
		<h1>Library Management System</h1>
		<hr>
		<div class="container">
		  <ul class="nav nav-tabs">
		    <li class="active"><a data-toggle="tab" href="#book">Book</a></li>
		    <li><a data-toggle="tab" href="#author">Author</a></li>
		    <li><a data-toggle="tab" href="#publisher">Publisher</a></li>
		    <li><a data-toggle="tab" href="#user">Users</a></li>
		  </ul>
			  
			  <div class="tab-content">
			  	
			  	<div id="book" class="tab-pane fade in active">
					<br><br>
			  		<div class="container">
			  			<ul class="nav nav-tabs col-md-1">
						    <li class="active"><a data-toggle="tab" href="#searchbook">Search</a></li>
						    <li><a data-toggle="tab" href="#addbook">Add</a></li>
						    <li><a data-toggle="tab" href="#updatebook">Update</a></li>
						    <li><a data-toggle="tab" href="#deletebook">Delete</a></li>
						</ul>
						
						<div class="tab-content col-md-10">
					        <div id="searchbook" class="tab-pane fade in active" >
					                <form action="/searchbook" method="post">
					                Search By : 
									<input type="radio" id="bookname" name="searchtype" value="bookname">
									<label for="bookname">Book Name</label>
									<input type="radio" id="bookcategory" name="searchtype" value="bookcategory">
									<label for="bookcategory">Book Category</label>
									<input type="radio" id="authorname" name="searchtype" value="authorname">
									<label for="authorname">Author Name</label>
									<input type="radio" id="publishername" name="searchtype" value="publishername">
									<label for="publishername">Publisher Name</label><br><br>
							        Search keyword : <input type="text" name="keyword" /><br><br>
							        <input type="submit" value="Search"/>
							        </form>
					        </div>
					        <div id="addbook" class="tab-pane fade">
					                <form action="/addbook" method="post">
					                Book Name : <input type="text" name="bookname" /><br><br>
							        Book Category : 
							        <input type="radio" id="novel" name="bookcat" value="novel">
									<label for="novel">Novel</label>
									<input type="radio" id="story" name="bookcat" value="story">
									<label for="story">Story</label>
									<input type="radio" id="series" name="bookcat" value="series">
									<label for="series">Series</label><br><br>
							        Book Author : <input type="text" name="bookauth" /><br><br>
							        Book Publisher : <input type="text" name="bookpub" /><br><br>
							        <input type="submit" value="Add"/>
							        </form>
					        </div>
					        <div id="updatebook" class="tab-pane fade">
					             Book Name : <input type="text" name="bookname" /><br><br>
							        Book Category : 
							        <input type="radio" id="novel" name="bookcat" value="novel">
									<label for="novel">Novel</label>
									<input type="radio" id="story" name="bookcat" value="story">
									<label for="story">Story</label>
									<input type="radio" id="series" name="bookcat" value="series">
									<label for="series">Series</label><br><br>
							        Book Author : <input type="text" name="bookauth" /><br><br>
							        Book Publisher : <input type="text" name="bookpub" /><br><br>
							        <input type="submit" value="Update"/>
					        </div>
					        <div id="deletebook" class="tab-pane fade">
					             Book Name : <input type="text" name="bookname" /><br><br>
       						 	<input type="submit" value="Delete"/>
					        </div>
						</div>
			  		</div>
    			</div>
    			
    			<div id="author" class="tab-pane fade">
      				<h3>AUTHOR</h3>
    			</div>
    			
    			<div id="publisher" class="tab-pane fade">
      				<h3>PUB</h3>
    			</div>
    			
    			<div id="user" class="tab-pane fade">
      				<h3>USER</h3>
    			</div>
    			
  			 </div>
  			 
		</div>
	</body>
	
</html>