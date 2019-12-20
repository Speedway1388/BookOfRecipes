<%@include file="../Header.jsp" %>
	<br><br><h1>OneRecipe</h1><br><br><br><br><br>
     <a class="addButton  marginLeft100 nomarginbottom" href = "${pageContext.request.contextPath}/editRecipe?recipeName=${recipeDto.name}">EDIT</a>
	<table border="1"class="nomargin">
    			<tr>
    				<th>Name</th>
    				<th>Composition</th>
    				<th>Description_Item</th>
    				<th>Difficulty</th>
    				<th>Time</th>
    				<th>Author</th>
    			</tr>
    				<tr>
    					<td>${recipeDto.name}</td>
    					<td>${recipeDto.composition}</td>
    					<td>${recipeDto.description}</td>
    					<td>${recipeDto.difficulty}</td>
    					<td>${recipeDto.time}</td>
    					<td>${recipeDto.authorUsername}</td>
    				</tr>
    		</table>

</body>
</html>
