package com.softserve.edu.items.controller.common;

import com.softserve.edu.items.IocContainer;
import com.softserve.edu.items.dto.LoginDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Security {

	public static boolean isActiveSession(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false); // Do not Create new Session
		Cookie idSessionCookie = null;
		for (Cookie currentCookie : request.getCookies()) {
			if (currentCookie.getName().equals("id_session")) {
				idSessionCookie = currentCookie;
				break;
			}
		}
		return (session != null)
				&& (session.getAttribute("loginDto") != null)
				&& (((LoginDto) (session.getAttribute("loginDto"))).getUsername() != null)
				&& (idSessionCookie != null)
				&& (idSessionCookie.getValue().equals(session.getId()));
	}
	public static boolean isAdminCurrent(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession(false);
		session.getAttribute("loginDto");
		int isAdmin= IocContainer.get().getUserService().getUserDto((LoginDto)session.getAttribute("loginDto")).getIsadmin();
		if(isAdmin==0){
			return false;
		}else {
			return true;
		}
	}

}
