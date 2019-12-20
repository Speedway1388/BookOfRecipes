
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" type="text/css" media="screen" href="${hostContext}/resources/css/style.css">
</head>

<body>
<div class="container">
	<div class="row">
	<h2><strong>Welcome to the recipes Book! Here You can find many useful recipes <br/></h2><br/>
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<c:if test="${error ne null}">
        		<p>
        			<font color="red">${error}</font>
        		</p>
        	</c:if>
			<!-- Start form -->
                    <form action="${pageContext.request.contextPath}/login" method="post">
                      <div class="form-group">
                        <label for="exampleInputEmail1">Email address</label>
                        <input type="text" name = "login" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" class="form-control" name="password" id="password">
                      </div>
                      <div class="form-check">
                       <button type="submit" class="btn btn-primary">LOGIN</button>
                        <a class = "btn btn-info" href="${pageContext.request.contextPath}/register">REGISTER</a>
                      </div>
                    </form>

			<!-- End form -->
		</div>
	</div>
</div>

	<br><br>
	<script type="text/javascript">
	<%@include file="../Functions.js" %>
	</script>
<script async src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" type="text/javascript"></script>
<script async src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" type="text/javascript"></script>
</body>
</html>
