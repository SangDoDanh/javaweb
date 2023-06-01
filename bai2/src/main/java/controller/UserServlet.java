package controller;

import model.User;
import repository.UserDao;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/users", name = "UserServlet")
public class UserServlet extends HttpServlet {
    private static IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "delete":
                userService.deleteUser(req, resp);
                break;
            case "":
                userService.getAll(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add":
                userService.addUser(req, resp);
                break;
            case "update":
                userService.updateUser(req, resp);
                break;
            case "":
                userService.getAll(req, resp);
                break;
        }
    }
}
