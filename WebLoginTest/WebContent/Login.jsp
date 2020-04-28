<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
	.div1{border:2px solid #000;padding:10px;width:400}
	</style>
</head>
<body>
	<form action="LoginServlet" method="post" onsubmit="return check()">
		<br>
		<div align="center" class="div1">
			username: <input type="text" name="userName" id="checkn"><br>
			<br> password: <input type="password" name="Pwd" id="checkp"><br>
			<br> <input type="submit" value="Login">&nbsp;&nbsp;&nbsp;<input
				type="reset" value="Reset">
		</div>
	</form>
</body>
    <script type="text/javascript" language="JavaScript" >
        function check() {
            var checkname = document.getElementById("checkn").value;
            var checkpwd = document.getElementById("checkp").value;
            if(checkname==''){
                alert('name is empty');
                return false;
            }else if(checkpwd=='')
            {
                alert('password is empty');
                return false;
            }else return true;
        }
    </script>
</html>