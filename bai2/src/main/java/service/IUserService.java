package service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IUserService {
    void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
