package coreservlets;

import repository.CatalogDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/** Base class for pages showing catalog entries.
 *  Servlets that extend this class must specify
 *  the catalog entries that they are selling and the page
 *  title <I>before</I> the servlet is ever accessed. This
 *  is done by putting calls to setItems and setTitle
 *  in init.
 */

public abstract class CatalogPage extends HttpServlet {
    private String title;

    private List<CatalogItem> catalogItems;

    protected void setItems(String type) {
        try {
            this.catalogItems = CatalogDao.getCatelogItemsByType(type);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void setTitle(String title) {
        this.title = title;
    }


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if (catalogItems == null) {
            response.sendError(response.SC_NOT_FOUND,
                    "Missing Items.");
            return;
        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String docType =
                "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                        "Transitional//EN\">\n";
        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H1 ALIGN=\"CENTER\">" + title + "</H1>");
        CatalogItem item;
        for(CatalogItem catalogItem : catalogItems) {
            out.println("<HR>");
            item = catalogItem;
            // Show error message if subclass lists item ID
            // that's not in the catalog.
            if (item == null) {
                out.println("<FONT COLOR=\"RED\">" +
                        "Unknown item ID " +
                        "</FONT>");
            } else {
                out.println();
                String formURL =
                        "/orders";
                // Pass URLs that reference own site through encodeURL.
                formURL = response.encodeURL(formURL);
                out.println
                        ("<FORM ACTION=\"" + formURL + "\">\n" +
                                "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
                                "       VALUE=\"" + item.getItemID() + "\">\n" +
                                "<H2>" + item.getShortDescription() +
                                " ($" + item.getCost() + ")</H2>\n" +
                                item.getLongDescription() + "\n" +
                                "<P>\n<CENTER>\n" +
                                "<INPUT TYPE=\"SUBMIT\" " +
                                "VALUE=\"Add to Shopping Cart\">\n" +
                                "</CENTER>\n<P>\n</FORM>");
            }
        }
        out.println("<HR>\n</BODY></HTML>");
    }
}

