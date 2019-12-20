<%@include file="../Header.jsp" %>
	<h1>Edit Recipe</h1>
	<br><br>
	<c:if test="${error ne null}">
    		<p>
    			<font color="red">${error}</font>
    		</p>
    	</c:if>
		<br><br>
    	<form action="${pageContext.request.contextPath}/editRecipe?recipeName=${recipeDto.name}" method="post">
    		<br>
    		Name:        <input type="text" value="${recipeDto.name}" name="editName">
    		Difficulty:  <input type="text" value="${recipeDto.difficulty}" name="editDifficulty">
    		Time:        <input type="text" value="${recipeDto.time}" name="editTime"><br>
    		Composition: <textarea class="bigArea" type="text" value="" name="editComposition">${recipeDto.composition}</textarea><br>
    		Description: <textarea class ="bigArea" type="text" value="" name="editDescription">${recipeDto.description}</textarea>


    		Author:      <input type="text" value="${recipeDto.authorUsername}" name="editAuthor" readonly><br>
    		<input class="addButton addButtonSize  floatLeft margin23 margintop20" type="submit" name="EDIT" value="EDIT"> <br>
    	</form>
        <form action="${pageContext.request.contextPath}/listrecipes" method="get">
           <input class="addButton nomargin addButtonSize marginLeft100 " type = "submit" name = "cancel" value="CANCEL">
        </form>


</body>
</html>