<%@include file="../Header.jsp" %>
	<h1 class="centerAlign">UserProfile</h1>
	<br><br>
	<c:if test="${error ne null}">
    		<p>
    			<font color="red">${error}</font>
    		</p>
    	</c:if>
		<br><br>
		<div class = "autoMargin">
		<form action="${pageContext.request.contextPath}/userdetails" method="get">
            	<input type = "submit" name = "cancel" value="CANCEL" class="addButton floatLeft marginLeft100 nomarginbottom addButtonSize">
        </form>
		 <form action="${pageContext.request.contextPath}/editUser" method="post">
		 <input type="submit" class="addButton nomarginbottom addButtonSize marginLeft100" name="EDIT" value="EDIT">
		 </div>
		<table border="1" class="responstable centerAlign nomargintop">
            	<tr>
            	    <th>Username</th>
            	    <th>Email</th>
            	    <th>Password</th>
                </tr>
                <tr>
                    <td><input type="text" name="username" value = "${loginDto.username}" readonly></td>
                    <td><input type="email" value="${email}" name="editEmail"></td>
                    <td><input type="password" value="${loginDto.password}" name="editPassword"></td>

                </tr>
                <tr>
                    <td>This field is not editable</td>
                    <td>Please enter correct email</td>
                    <td>length must be at least 4 characters</td>
                </tr>
        </table>
        </form>
    	<br><br>
<%@include file="../Footer.jsp" %>