package com.softserve.edu.items.controller;

public enum ViewUrls {
	LOGIN_JSP("/WEB-INF/views/users/Login.jsp"),
	USER_PROFILE_JSP("/WEB-INF/views/users/UserProfile.jsp"),
	ONE_RECIPE_JSP("/WEB-INF/views/recipes/OneRecipe.jsp"),
	RECIPE_LIST_JSP("/WEB-INF/views/recipes/ListRecipes.jsp"),
	ERROR_JSP("/WEB-INF/views/commons/Error.jsp"),
	REGISTER_JSP("/WEB-INF/views/users/UserRegister.jsp"),
	USERS_LIST_JSP("/WEB-INF/views/users/UsersList.jsp"),
	USER_EDIT_JSP("/WEB-INF/views/users/UserEdit.jsp"),
	ADD_USER_PROFILE("/WEB-INF/views/users/AddUser.jsp"),
	EDIT_USER_PROFILE("/WEB-INF/views/users/EditUserProfile.jsp"),
	RECIPE_ADD_JSP("/WEB-INF/views/recipes/AddRecipe.jsp"),
	RECIPE_EDIT_JSP("/WEB-INF/views/recipes/EditRecipe.jsp");

	//
	private String url;

	private ViewUrls(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url;
	}
}
