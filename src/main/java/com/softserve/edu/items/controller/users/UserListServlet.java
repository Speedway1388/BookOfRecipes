package com.softserve.edu.items.controller.users;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/listUsers"})
public class UserListServlet extends HttpServlet {
    private UserService userService;

    public UserListServlet() {
        this.userService = IocContainer.get().getUserService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Security.isActiveSession(request, response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        } else if(!Security.isAdminCurrent(request,response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LIST_RECIPES_SERVLET.toString())
                    .forward(request, response);
        }else {
            request.setAttribute("allUsers",userService.getUsersDto(6));
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.USERS_LIST_JSP.toString())
                    .forward(request,response);
        }
    }
}
