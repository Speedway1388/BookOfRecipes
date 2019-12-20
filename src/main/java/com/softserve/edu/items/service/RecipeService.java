package com.softserve.edu.items.service;

import com.softserve.edu.items.dao.RecipeDao;
import com.softserve.edu.items.dao.UserDao;
import com.softserve.edu.items.dto.OneRecipeDto;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.dto.RecipesDto;
import com.softserve.edu.items.entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeService {

    private RecipeDao recipeDao;


    public RecipeService() {
        this.recipeDao = new RecipeDao();
    }

    public RecipeService(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    public RecipesDto getRecipesDto(int pageofset) {
        List<Recipe> recipe = recipeDao.getAll();
        List<OneRecipeDto> recipeNames = new ArrayList<>(recipe.size());
//        OneRecipeDto oneRecipeDto=new OneRecipeDto("");
        for (int i = 0; i < recipe.size(); i++) {
//            oneRecipeDto.setName(recipe.get(i).getName());
            recipeNames.add(new OneRecipeDto(recipe.get(i).getName()));
        }
        return new RecipesDto(recipeNames, pageofset);


    }
//    public boolean setRecipeDto1(RecipeDto recipeDto){
//        boolean result=false;
//        Recipe recipe = new Recipe(
//                recipeDto.getId(),
//                recipeDto.getName(),
//                recipeDto.getComposition(),
//                recipeDto.getDescription(),
//                recipeDto.getDifficulty(),
//                recipeDto.getTime(),
//
//    }
        public boolean setRecipeDTO(RecipeDto recipeDto, Long idUser) {
        boolean result = false;
        Recipe recipe = new Recipe(
                recipeDto.getId(),
                recipeDto.getName(),
                recipeDto.getComposition(),
                recipeDto.getDescription(),
                recipeDto.getDifficulty(),
                recipeDto.getTime(),
                idUser);
        if (recipeDto.getId() > 0) {
            if (isExistRecipe(recipe.getId())) {
                recipeDao.updateByEntity(recipe);
                result = true;
            }
        } else {
            recipeDao.insert(recipe);
            result = true;
        }
        return result;
    }
    public boolean deleteRecipe(Recipe recipe){
        boolean result = true;
        try{
            recipeDao.delete(recipe);
        }catch (RuntimeException e){
            System.out.println("Recipe not found, message: " + e.getMessage());
            result=false;
        }
        return result;

    }

    public boolean isExistRecipe(long id) {
        boolean result = true;
        try {
            recipeDao.getById(id);
        } catch (RuntimeException e) {
            // Logging Exception
            System.out.println("Recipe not found, message: " + e.getMessage());
            result = false;
        }
        return result;
    }

    public boolean deleteRecipe(long id) {
        boolean result = true;
        try {
            result = result && recipeDao.deleteById(id);
        } catch (RuntimeException e) {
            // Logging Exception
            result = false;
        }
        return result;
    }
}