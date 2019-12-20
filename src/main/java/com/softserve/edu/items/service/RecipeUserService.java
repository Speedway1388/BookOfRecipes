package com.softserve.edu.items.service;

import com.softserve.edu.items.dao.RecipeDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.OneRecipeDto;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.entity.Recipe;

import java.util.List;

public class RecipeUserService {

    private RecipeDao recipeDao;
    private UserDao userDao;


    public RecipeUserService() {
        this.recipeDao = new RecipeDao();
    }

    public RecipeUserService(RecipeDao recipeDao, UserDao userDao) {
        this.recipeDao = recipeDao;
        this.userDao=userDao;
    }
    public RecipeDto getRecipeDto(String name) {
        List<Recipe> recipes = recipeDao.getByFieldName("name", name);
        return new RecipeDto(
                recipes.get(0).getId(),
                recipes.get(0).getName(),
                recipes.get(0).getComposition(),
                recipes.get(0).getDescription(),
                recipes.get(0).getDifficulty(),
                recipes.get(0).getTime(),
                userDao.getById(recipes.get(0).getAuthor()).getUsername());
//                recipes.get(0).getAuthor()
//                recipe.getName(),
//                recipe.getComposition(),
//                recipe.getDescription(),
//                recipe.getDifficulty(),
//                recipe.getTime(),
//                userDao.getById(recipe.getAuthor()).getUsername());
    }
}
