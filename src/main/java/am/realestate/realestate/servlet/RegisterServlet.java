package am.realestate.realestate.servlet;


import am.realestate.realestate.manager.UserManager;
import am.realestate.realestate.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg")
public class RegisterServlet extends HttpServlet {

    UserManager userManager = new UserManager();

    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .build();
        userManager.addUser(user);

    }
}
