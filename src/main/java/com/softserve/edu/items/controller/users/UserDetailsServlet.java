package com.softserve.edu.items.controller.users;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.RecipeDto;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/userdetails"})
public class UserDetailsServlet extends HttpServlet {

    UserService userService;

    public UserDetailsServlet() {
        this.userService = IocContainer.get().getUserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!Security.isActiveSession(request,response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        } else {
            HttpSession session = request.getSession(false);

        }
        HttpSession session = request.getSession(false);
        LoginDto loginDto = (LoginDto) session.getAttribute("loginDto");
        request.setAttribute("currentUser",userService.getUserDto(loginDto));
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.USER_PROFILE_JSP.toString())
                .forward(request, response);
    }
}

