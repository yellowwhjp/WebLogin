<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>HomePage</title>
  </head>
  <style>
	.div1{border:2px solid #000;padding:10px;width:400}
  </style>
  <body>
  <br>
    <div align="center" class="div1">
      <form action="Login.jsp" method="get">
        <button type="submit" style="width:150px;">Login</button>
      </form><br>
      <form action="Register.jsp" method="get">
        <button type="submit" style="width:150px;">Register</button>
      </form>
<%--      <button onclick="indow.location.href='/Register.jsp'">Register</button>--%>
    </div>
  </body>
</html>