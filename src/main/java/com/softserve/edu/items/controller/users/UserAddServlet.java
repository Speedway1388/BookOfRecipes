package com.softserve.edu.items.controller.users;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.dto.RegisterDto;
import com.softserve.edu.items.dto.UserDto;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet({"/register"})
public class UserAddServlet extends HttpServlet {
    UserService userService;

    public UserAddServlet() {
        this.userService = IocContainer.get().getUserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession(false);
//            UserDto userDto = userService.getUserDto((LoginDto) session.getAttribute("loginDto"));
        if (
                request.getParameter("addEmail").length() < 5 ||
                request.getParameter("addPassword1").length() < 4 ||
                request.getParameter("addUsername").length() < 1||
                !request.getParameter("addPassword1").equals(request.getParameter("addPassword2"))){
                    request.setAttribute("error", "Can't Create User with such credentials");
                    getServletConfig()
                        .getServletContext()
                        .getRequestDispatcher(ViewUrls.ADD_USER_PROFILE.toString())
                        .forward(request, response);
        }else{
            RegisterDto registerDto = new RegisterDto(
                    (String)request.getParameter("addUsername"),
                    (String)request.getParameter("addEmail"),
                    (String)request.getParameter("addPassword1"));
            userService.setRegisterDto(registerDto);
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.LOGIN_JSP.toString())
                    .forward(request, response);
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.ADD_USER_PROFILE.toString())
                .forward(request, response);
    }
}

