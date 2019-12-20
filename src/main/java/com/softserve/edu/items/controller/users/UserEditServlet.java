package com.softserve.edu.items.controller.users;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet({"/editUser"})
public class UserEditServlet extends HttpServlet {
    UserService userService;

    public UserEditServlet() {
        this.userService = IocContainer.get().getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!Security.isActiveSession(request, response)) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ControllerUrls.LOGOUT_SERVLET.toString())
                    .forward(request, response);
        } else {
            HttpSession session = request.getSession(false);
            UserDto userDto = userService.getUserDto((LoginDto) session.getAttribute("loginDto"));
            if(request.getParameter("editEmail").length()<5||request.getParameter("editPassword").length()<4){
                request.setAttribute("error", "your password length is too small");
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(ViewUrls.EDIT_USER_PROFILE.toString())
                        .forward(request, response);
            }else {
                userDto.setEmail(request.getParameter("editEmail"));
                userDto.setPassword(request.getParameter("editPassword"));
                userService.setUserDto(userDto);
                request.setAttribute("error", "USER SAVED!");
                getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(ViewUrls.EDIT_USER_PROFILE.toString())
                        .forward(request, response);
            }
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
            UserDto userDto = userService.getUserDto((LoginDto) session.getAttribute("loginDto"));
            request.setAttribute("email",userDto.getEmail());
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.EDIT_USER_PROFILE.toString())
                    .forward(request, response);
        }
    }
}

