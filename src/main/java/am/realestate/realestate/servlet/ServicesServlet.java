package am.realestate.realestate.servlet;

import am.realestate.realestate.manager.UserManager;
import am.realestate.realestate.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/serv")
public class ServicesServlet extends HttpServlet {
    private UserManager userManager = new UserManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userManager.getUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/WEB-INF/services.jsp").forward(req, resp);
    }
}
