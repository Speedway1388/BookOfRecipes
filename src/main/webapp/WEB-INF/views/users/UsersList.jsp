<%@include file="../Header.jsp" %>
	<h1>UsersList</h1>

<ul>
</ul>
<br>
	<table border="1">
    			<tr>
    				<th>username</th>
    				<th>email</th>
    				<th>password</th>
    				<th>isAdmin</th>
    				<th>isActive</th>
    			</tr>
    			<c:forEach var="row" items="${allUsers.userDtos}">
    				<tr>
    					<td>${row.username}</td>
    					<td>${row.email}</td>
    					<td>${row.password}</td>
    					<c:if test = "${row.isadmin>0}">
    					 <td><input type="checkbox" checked></td>
    					 </c:if>
    					 <c:if test = "${row.isadmin<1}">
                            <td><input type="checkbox"></td>
                         </c:if>
    					<c:if test = "${row.isactive>0}">
    					 <td><input type="checkbox" checked></td>
    					 </c:if>
    					 <c:if test = "${row.isactive<1}">
                            <td><input type="checkbox"></td>
                         </c:if>
    					<!--<td>${row.isadmin}</td>-->
    					<!--<td>${row.isactive}</td>-->
    				</tr>
    			</c:forEach>
    		</table>
</body>
</html>
