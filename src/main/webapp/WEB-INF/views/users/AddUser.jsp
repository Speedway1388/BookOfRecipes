<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%> --%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="hostUrl">${pageContext.request.requestURL}</c:set>
<c:set var="hostUri">${pageContext.request.requestURI}</c:set>
<c:set var="hostContext" value="${fn:substring(hostUrl, 0, fn:length(hostUrl) - fn:length(hostUri))}${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Recipes</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" type="text/css" href="styles.css">
<link rel="stylesheet" type="text/css" media="screen" href="${hostContext}/resources/css/style.css">
<style type="text/css">
<%--<%@include file="bootstrap.min.css" %>--%>
<%@include file="../recipes/Recipes.css" %>
</style>

</head>
<body>
<div class="container">
	<div class="row">
	<h2><strong>Welcome to the recipes Book! Here You can find many useful recipes <br/></h2><br/>
	<h3>Please register</h3>
		<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<!-- Start form -->
                    <form action="${pageContext.request.contextPath}/register" method="post">
                      <div class="form-group">
                        <label for="exampleInputUsername">Username</label>
                        <input type="text" name="addUsername" value = "" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                      </div>
                       <div class="form-group">
                         <label for="exampleInputEmail1">Email</label>
                         <input type="email" name="addEmail"class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
                         </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="addPassword1" class="form-control" name="password" id="password">
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword2">Confirm Password</label>
                        <input type="password" name="addPassword2" class="form-control" name="password" id="password">
                      </div>
                      <div class="form-check">

                        <a class="btn btn-info" type="button" href = "${pageContext.request.contextPath}/login">Cancel</a>
                        <button type="submit" class="btn btn-primary">Submit</button>
                      </div>
                    </form>

			<!-- End form -->
		</div>
	</div>
</div>
<br><br>
	<c:if test="${error ne null}">
    		<p>
    			<font color="red">${error}</font>
    		</p>
    	</c:if>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</body>
</html>