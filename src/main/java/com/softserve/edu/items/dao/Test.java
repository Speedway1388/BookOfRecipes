package com.softserve.edu.items.dao;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.dto.OneRecipeDto;
import com.softserve.edu.items.dto.RecipesDto;
import com.softserve.edu.items.entity.Recipe;
import com.softserve.edu.items.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        RecipeDao recipeDao = new RecipeDao();
//        User user = new User((long) 7,"Yura","yura3@gmail.com","IAmYura");
//        System.out.println();
//        User user= userDao.getUserEntityByUsername("vasia");
//        System.out.println(user.toString());
//        System.out.println(userDao.getById((long)1));
//        userDao.insert(new User((long) 1,"Ololol2","olo2@gmail.com","IAmOlo"));
//        System.out.println(userDao.getUserEntityByUsername("Yura"));
//        List<String> testlist = new ArrayList<>(5);
//        System.out.println(testlist());
//        userDao.updateByFieldName("email","yura2@gmail.com", "username","Yura");
//        userDao.updateByEntity(user);
        recipeDao.insert(new Recipe((long)0,"Meat","meat","fine meat",1,35, (long) 1));
        System.out.println(recipeDao.getById((long)3));
        RecipesDto recipesDto = IocContainer.get()
                .getRecipeService()
                .getRecipesDto(10);
        List<OneRecipeDto> recipenames = recipesDto.getRecipenames();
        for (OneRecipeDto oneRecipeDto:recipenames ){
            System.out.println(oneRecipeDto.getName());
        }


        List<User> usersList = userDao.getAll();

        for (User user1: usersList
        ) {
            System.out.println(user1);
        }
        System.out.println();
        List<Recipe> recipes = recipeDao.getAll();
        for (Recipe recipe :
                recipes) {
            System.out.println(recipe);
        }
    }
}
