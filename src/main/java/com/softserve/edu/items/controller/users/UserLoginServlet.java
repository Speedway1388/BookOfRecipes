package com.softserve.edu.items.controller.users;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.controller.ControllerUrls;
import com.softserve.edu.items.controller.ViewUrls;
import com.softserve.edu.items.controller.common.Security;
import com.softserve.edu.items.dto.LoginDto;
import com.softserve.edu.items.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/", "/login"})
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
        userService = IocContainer.get().getUserService();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        getServletConfig()
                .getServletContext()
                .getRequestDispatcher(ViewUrls.LOGIN_JSP.toString())
                .forward(request, response);
    }



    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //doGet(request, response);
        //String login
        //String password
        LoginDto loginDto = new LoginDto(
                request.getParameter("login"),
                request.getParameter("password"));
//        System.out.println("loginDto = " + loginDto);
        if (userService.isValid(loginDto)) {
            // Create session
            HttpSession session = request.getSession(true);
            session.setAttribute("loginDto", loginDto);
            session.setMaxInactiveInterval(300000);
            if (Security.isAdminCurrent(request, response)) {
                session.setAttribute("admin", true);
            }
            // Add Cookie
            Cookie cookie = new Cookie("id_session", session.getId());
            response.addCookie(cookie);
            //
            response.sendRedirect(request.getContextPath()
                    + ControllerUrls.LIST_RECIPES_SERVLET.toString());
//			getServletConfig()
//				.getServletContext()
//				.getRequestDispatcher(ControllerUrls.LIST_RECIPES_SERVLET.toString())
//				.forward(request, response);
        } else {
            // Show Error Validator
            request.setAttribute("error", "Bad Login or Password");
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher(ViewUrls.LOGIN_JSP.toString())
                    .forward(request, response);
        }
    }

}
