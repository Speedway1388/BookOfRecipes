<%@include file="../Header.jsp" %>
	<h1 class="centerAlign">UserProfile</h1>
    	<br><br>
    	<a class= "addButton margin100 nomarginbottom "href = "${pageContext.request.contextPath}/editUser" >EDIT USER</a>
    	<br><br>
    	<table border="1" class="responstable centerAlign nomargintop">
    	<tr>
    	    <th>Username</th>
    	    <th>Email</th>
    	    <th>Password</th>
        </tr>
        <tr>
            <td>${currentUser.username}
            <td>${currentUser.email}
            <td>${currentUser.password}

        </tr>
        <%--
        Name:${currentUser.username}<br>
        Email:${currentUser.email}<br>
        Password:${currentUser.password}<br>
        --%>
<%@include file="../Footer.jsp" %>