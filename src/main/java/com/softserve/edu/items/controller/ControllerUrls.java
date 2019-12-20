package com.softserve.edu.items.controller;

public enum ControllerUrls {
	ROOT_SERVLET("/"), 				//для recipelist
	TOLOGIN_SERVLET ("tologin"),  			//get
	LOGIN_OK_SERVLET("loginok"),    //post
	LOGINCANCEL_SERVLET("/logincancel"),	//get ==/
	TOREGISTER_SERVLET("/toregister"),		//get
	REGISTER_SERVLET("/register"),			//post
	REGISTER_CANCEL_SERVLET("/registercancel"), 	//to TOLOGIN /get
	TO_ADD_RECIPE_SERVLET ("/toaddrecipe"),	//get
	TO_EDIT_RECIPE_SERVLET("/toeditrecipe"),// post
	TOACCOUNT_INFO_SERVLET("/toaccountinfo"),//post
	TO_EDIT_ACCOUNT_SERVLET("/toeditaccount"), //post
	LOGOUT_SERVLET("/logout"),				//post
	TO_ONE_RECIPE_SERVLET("/toonerecipe"), 	// get
	ADD_RECIPE_SERVLET("/addrecipe"),		// get
	EDIT_RECIPE_SERVLET("/editrecipe"),		// post
	TOLISTUSERS_SERVLET ("/tolistusers"),	// get
	LIST_USERS_SERVLET ("/listusers"),		//post
	LIST_RECIPES_SERVLET("/listrecipes"), //get
	RECIPE_DELETE_SERVLET("/recipedelete"), //post
	ITEM_COUNT_SERVLET("/itemcount"), // Post
	USER_DETAILS_SERVLET("/userdetails");

	private String url;

	private ControllerUrls(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return url;
	}
}
