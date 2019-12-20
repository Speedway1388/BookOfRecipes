<%@include file="../Header.jsp" %>
	<h1>ADD THE RECIPE!</h1>
	<br>
	<c:if test="${error ne null}">
    		<p>
    			<font color="red">${error}</font>
    		</p>
    	</c:if>
		<br>
    	<form action="${pageContext.request.contextPath}/addRecipe" method="post">
    		Name:        <input type="text" value="" name="addName">
    		Difficulty:  <input type="text" value="" name="addDifficulty">
    		Time:        <input type="text" value="" name="addTime"><br>
    		Composition: <textarea class = "bigArea"name = "addComposition"></textarea><br>
    		Description: <textarea class = "bigArea" name = "addDescription" value="" name></textarea><br>

    		<input class="addButton addButtonSize  floatLeft margin23 margintop20" type="submit" name="ADD" value="ADD"> <br>
    	</form>
    	<form action="${pageContext.request.contextPath}/listrecipes" method="get">
    	<input class="addButton nomargin addButtonSize marginLeft100 " type = "submit" name = "cancel" value="CANCEL">
    	</form>
    	<br><br>

</body>
</html>