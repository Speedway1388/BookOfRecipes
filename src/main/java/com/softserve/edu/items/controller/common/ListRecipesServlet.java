package com.softserve.edu.items.controller.common;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.RecipesDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class UserProfileEditServlet
 */
@WebServlet("/listrecipes")
public class ListRecipesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListRecipesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Security.isActiveSession(request,response)) {
			getServletConfig()
				.getServletContext()
				.getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
				.forward(request, response);
		} else {
			RecipesDto recipesDto = IocContainer.get()
					.getRecipeService()
					.getRecipesDto(10);
			request.setAttribute("recipesDto",recipesDto);
			getServletConfig()
				.getServletContext()
				.getRequestDispatcher(ViewUrls.RECIPE_LIST_JSP.toString())
				.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("\t/useritems doPost");
		doGet(request, response);
	}

}
