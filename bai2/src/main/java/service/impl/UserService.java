package service.impl;

import model.User;
import repository.UserDao;
import service.IUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserService implements IUserService {
    @Override
    public void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));

        User u = UserDao.getRecordById(id);
        if (u != null) {
            int statusDel = UserDao.delete(u);
            if(statusDel > 0) {
                req.setAttribute("message", "Delete Success");
            }
        } else {
            req.setAttribute("message", "Delete fail!");
        }
        List<User> users =UserDao.getAllRecords();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./views/listUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = UserDao.getAllRecords();
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("./views/listUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String Country = req.getParameter("country");
        String sex = req.getParameter("sex");
        User user = new User(null, name, password, email, Country, sex);
        if(UserDao.save(user) > 0) {
            req.setAttribute("message", "add new OK");
        } else {
            req.setAttribute("message", "add Fail");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/addUser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String Country = req.getParameter("country");
        String sex = req.getParameter("sex");
        User user = new User(id, name, password, email, Country, sex);

        if (UserDao.update(user) > 0 ) {
            req.setAttribute("message", "Update success OK");
        } else {
            req.setAttribute("message", "");
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/editUser.jsp");
        dispatcher.forward(req, resp);
    }
}
