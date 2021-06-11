<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700"
	rel="stylesheet">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/signup.css">
</head>
<body>
	<div class="signup-form">

		<h2 style="color: white">Home</h2>

		<div style="margin:100px">
			<div class="form-group">
				
					<a class="btn btn-success btn-lg btn-block" style="text-decoration: none;" href="author.jsp">Author</a>
				
			</div>
			<div class="form-group">
				<a class="btn btn-success btn-lg btn-block" style="text-decoration: none;" href="book.jsp">Book</a>
			</div>
			<div class="form-group">
				<button id="loginbtn" class="btn btn-success btn-lg btn-block">
					<a style="text-decoration: none;" href="./UserServlet?action=logout">Logout</a>
				</button>
			</div>

		</div>


	</div>
</body>

<script type="text/javascript">
	$(document).ready(function() {

		$("#loginbtn").on('click', function() {

			var username = $('#username').val();
			var password = $('#password').val();

			console.log(username);
			console.log(password);

		});

	});
</script>
</html>