package in.blogspot.randomcompiler.model.view.controller.pattern.controllers;

import in.blogspot.randomcompiler.model.view.controller.pattern.models.Authenticator;
import in.blogspot.randomcompiler.model.view.controller.pattern.models.User;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public LoginController() {
        super();
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
 
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;
 
        Authenticator authenticator = new Authenticator();
        boolean authenticated = authenticator.authenticate(username, password);
        if (authenticated) {
            rd = request.getRequestDispatcher("/success.jsp");
            User user = new User(username, password);
            request.setAttribute("user", user);
        } else {
            rd = request.getRequestDispatcher("/error.jsp");
        }
        rd.forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
