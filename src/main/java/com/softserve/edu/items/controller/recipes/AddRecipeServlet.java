package com.softserve.edu.items.controller.recipes;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.service.RecipeService;
import com.softserve.edu.items.service.RecipeUserService;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/addRecipe"})
public class AddRecipeServlet extends HttpServlet{
    RecipeService recipeService;
    RecipeUserService recipeUserService;
    UserService userService;

    public AddRecipeServlet() {
        this.recipeService = IocContainer.get().getRecipeService();
        recipeUserService = IocContainer.get().getRecipeUserService();
        userService=IocContainer.get().getUserService();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!Security.isActiveSession(request, response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        } else {
            HttpSession session = request.getSession(false);
            LoginDto loginDto =(LoginDto)session.getAttribute("loginDto");
            String authorUsername = loginDto.getUsername();
            RecipeDto recipeDto=new RecipeDto(
                    (long)0,
                    (String)request.getParameter("addName"),
                    (String)request.getParameter("addComposition"),
                    (String)request.getParameter("addDescription"),
                    Integer.valueOf((String)request.getParameter("addDifficulty")),
                    Integer.valueOf((String)request.getParameter("addTime")),
                    authorUsername);
            recipeService.setRecipeDTO(recipeDto,userService.getIdUserByUsername(authorUsername));
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LIST_RECIPES_SERVLET.toString())
                    .forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Security.isActiveSession(request, response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        } else {
//            HttpSession session = request.getSession(false);
//            RecipeDto recipeDto = recipeUserService.getRecipeDto(request.getParameter("recipeName"));
//            request.setAttribute("recipeDto",recipeDto);

            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.RECIPE_ADD_JSP.toString())
                    .forward(request, response);
        }
    }
}
