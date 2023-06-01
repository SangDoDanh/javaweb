package controller;

import model.User;
import repository.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(value = "/users", name = "UserServlet")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "add":
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "":
                getAllUsers(req, resp);
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
                break;
            case "update":
                updateUser(req, resp);
                break;
            case "delete":
                break;
            case "":
                getAllUsers(req, resp);
                break;
        }
    }

    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
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

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



    }

    private void getAllUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<User> users = UserDao.getAllRecords();
//        req.setAttribute("users", users);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("./views/viewusers.jsp");
//        dispatcher.forward(req, resp);
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>User List</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Name</th>");
        out.println("<th>Email</th>");
        out.println("<th>Sex</th>");
        out.println("<th>Country</th>");
        out.println("<th>Action</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");

        for (User user : users) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getSex() + "</td>");
            out.println("<td>" + user.getCountry() + "</td>");
            out.println("<td>");
            out.println("<a href=\"./views/editUser.jsp?id=" + user.getId() + "&action=edit\">Edit</a>");
            out.println("<a href=\"deleteUser.jsp?id=" + user.getId() + "\">Delete</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</tbody>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

        out.close();

    }
}
