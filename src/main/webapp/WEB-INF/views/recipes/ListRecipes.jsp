<%@include file="../Header.jsp" %>
	<h1 class = "centerAlign"><a>LIST OF ALL RECIPES</a></h1>
	<br><br>
    <a type = "button" class="addButton margin100 nomarginbottom" href="${pageContext.request.contextPath}/addRecipe">ADD RECIPE</a>
    <c:set var="currentrecipes" value="${recipesDto.recipenames}"/>
    <div id = "description">
    <table border="1" class="responstable center nomargintop autoMargin">
    <c:forEach var="oneRecipeDto" items="${currentrecipes}">
    <tr>
        <td>${oneRecipeDto.name}</td>
        <td><a href = "${pageContext.request.contextPath}/oneRecipe?recipeName=${oneRecipeDto.name}">Details</a></td>
        <td><a href = "${pageContext.request.contextPath}/editRecipe?recipeName=${oneRecipeDto.name}">Edit</a></td>
        <td> <a href = "${pageContext.request.contextPath}/deleteRecipe?recipeName=${oneRecipeDto.name}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    </div>
	<br><br>
<%@include file="../Footer.jsp" %>