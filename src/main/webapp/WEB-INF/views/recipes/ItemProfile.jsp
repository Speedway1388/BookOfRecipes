<%@include file="../Header.jsp" %>
	<h1>ItemProfile</h1>
	<br><br>
	<form action="${pageContext.request.contextPath}/itemedit" method="post">
		id: <input type="text" name="idItem" value="${itemDto.idItem}" readonly />
		<br><br>
		name: <input type="text" name="nameItem" value="${itemDto.name}" />
		<br><br>
		description: <input type="text" name="descriptionItem" value="${itemDto.description}" />
		<br><br>
		<input type="submit" value="Ok" />
		<a href="${pageContext.request.contextPath}/useritems">Cancel</a>
	</form>
</body>
</html>