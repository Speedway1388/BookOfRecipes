package com.softserve.edu.items.controller.recipes;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.dto.UserDto;
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
@WebServlet({"/editRecipe"})
public class RecipeEditServlet extends HttpServlet {
    RecipeService recipeService;
    RecipeUserService recipeUserService;
    UserService userService;

    public RecipeEditServlet() {
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
            RecipeDto recipeDto = recipeUserService.getRecipeDto((String) request.getParameter("recipeName"));
            recipeDto.setName((String)request.getParameter("editName"));
            recipeDto.setComposition((String)request.getParameter("editComposition"));
            recipeDto.setDescription((String)request.getParameter("editDescription"));
            recipeDto.setDifficulty(Integer.valueOf((String) request.getParameter("editDifficulty")));
            recipeDto.setTime(Integer.valueOf((String)request.getParameter("editTime")));
            recipeService.setRecipeDTO(recipeDto,userService.getIdUserByUsername((String) request.getParameter("editAuthor")));
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
            HttpSession session = request.getSession(false);
            RecipeDto recipeDto = recipeUserService.getRecipeDto(request.getParameter("recipeName"));
            request.setAttribute("recipeDto",recipeDto);
//            UserDto userDto = userService.getUserDto((LoginDto) session.getAttribute("loginDto"));
//            request.setAttribute("email", userDto.getEmail());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.RECIPE_EDIT_JSP.toString())
                    .forward(request, response);
        }
    }
}
