package com.softserve.edu.items.controller.recipes;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.service.RecipeUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/oneRecipe"})
public class OneRecipeServlet extends HttpServlet {
    RecipeUserService recipeUserService;

    public OneRecipeServlet() {
        this.recipeUserService = IocContainer.get().getRecipeUserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String recipeName = request.getParameter("recipeName");
        RecipeDto recipeDto = IocContainer.get().getRecipeUserService().getRecipeDto(recipeName);
        request.setAttribute("recipeDto",recipeDto);
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.ONE_RECIPE_JSP.toString())
                .forward(request, response);
    }
}
