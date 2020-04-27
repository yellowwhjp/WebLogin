<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
<style>
	.div1{border:2px solid #000;padding:10px;width:400}
</style>
</head>
<body>
<form method="post" action="RegisterServlet" onsubmit="return (check()&&checkfile())" enctype="multipart/form-data"><br>
    <div align="center" class="div1">
    Username: <input type="text" name="userName" id="checkn"><br><br>
    Password: <input type="password" name="Pwd" id="checkp"><br><br>
    Password again: <input type="password" name="Pwd2" id="checkp2"><br><br>
	Image:<input type="file" name="file" id="checkimg"><br><br>
    <input type="submit" value="Register">&nbsp;&nbsp;&nbsp;<input type="reset" value="Reset">
    </div>
</form>
</body>
<script type="text/javascript" language="JavaScript" >
    function check() {
        var checkname = document.getElementById("checkn").value;
        var checkpwd = document.getElementById("checkp").value;
        var checkpwd2 = document.getElementById("checkp2").value;
        if(checkname==''){
            alert('name is empty');
            return false;
        }else if(checkpwd==''){
            alert('password is empty');
            return false;
        }else if(checkpwd2==''){
            alert('password is empty');
            return false;
        }else{
        	return true;
        }
    }
    function checkfile(){
    	var img_id = document.getElementById("checkimg").value;
    	var index = img_id.indexOf(".");
    	img_id = img_id.substring(index);
    	if(img_id!=".bmp"&&img_id!=".png"&&img_id!=".gif"&&img_id!=".jpg"&&img_id!=".jpeg"){
    		alert('not pic');
    		return false;
    	}
    	else return true;
    }
    <%--    
    var fileObj = '';
    var imgData = '';
    $("#checkimg").change(function(){
    	var reader = new FileReader();
    	fileObj = $(this)[0].file[0];
    	reader.readAsDataURL(fileObj);
    	reader.onload = function(){
    		imgData = reader.result;
    		$("#showImg").attr("src", imdData);
    		$("#showImg").show();
    	}
    });
    --%>
</script>
</html>