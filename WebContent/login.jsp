<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Bootstrap Simple Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<link rel="stylesheet" href="css/signup.css">
</head>
<body>
<div class="signup-form">
    <form action="./UserServlet?action=login" method="post">
		<h2>Login</h2>
		
        <div class="form-group">       	
        </div>
        <div class="form-group">
        	<input type="text" id="username" class="form-control" name="username" placeholder="User Name" required="required">
        </div>
		<div class="form-group">
            <input type="password" id="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
		
		<div class="form-group">
            <button id="loginbtn" class="btn btn-success btn-lg btn-block">Login</button>
        </div>
    </form>
	<div class="text-center">Don't have an account? <a href="register.jsp">Register here</a></div>
</div>
</body>

<script type="text/javascript">

$(document).ready(function(){


	$("#loginbtn").on('click', function(){

		var username = $('#username').val();
		var password = $('#password').val();
		
		console.log(username);
		console.log(password);

		

		});
	
	
});


</script>
</html>