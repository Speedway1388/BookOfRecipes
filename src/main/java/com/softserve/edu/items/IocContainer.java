package com.softserve.edu.items;

import com.softserve.edu.items.dao.RecipeDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.service.RecipeService;
import com.softserve.edu.items.service.RecipeUserService;
import com.softserve.edu.items.service.UserService;
public final class IocContainer {

	private static volatile IocContainer instance = null;
	//
	private UserDao userDao;
	private RecipeDao recipeDao;
	//
	private UserService userService;
	private RecipeService recipeService;
	private RecipeUserService recipeUserService;
	private IocContainer() {
		initDaos();
		initServices();
	}
	
	private void initDaos() {
		userDao = new UserDao();
		recipeDao = new RecipeDao();
	}

	private void initServices() {
		userService = new UserService(userDao);
		recipeService = new RecipeService(recipeDao);
		recipeUserService = new RecipeUserService(recipeDao,userDao);
	}

	public static IocContainer get() {
		if (instance == null) {
			synchronized (IocContainer.class) {
				if (instance == null) {
					instance = new IocContainer();
				}
			}
		}
		return instance;
	}

	public static IocContainer getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public RecipeDao getRecipeDao() {
		return recipeDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public RecipeService getRecipeService() {
		return recipeService;
	}

	public RecipeUserService getRecipeUserService() {
		return recipeUserService;
	}
}
