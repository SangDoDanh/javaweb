package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/** Base class for pages showing catalog entries.
 *  Servlets that extend this class must specify
 *  the catalog entries that they are selling and the page
 *  title <I>before</I> the servlet is ever accessed. This
 *  is done by putting calls to setItems and setTitle
 *  in init.
 */

public abstract class CatalogPage extends HttpServlet {
    private CatalogItem[] items;
    private String[] itemIDs;
    private String title;

    protected void setItems(String[] itemIDs) {
        this.itemIDs = itemIDs;
        items = new CatalogItem[itemIDs.length];
        for(int i=0; i<items.length; i++) {
            items[i] = Catalog.getItem(itemIDs[i]);
        }
    }

    /** Sets the page title, which is displayed in
     *  an H1 heading in resultant page.
     *  <P>
     *  Servlets that extend CatalogPage <B>must</B> call
     *  this method (usually from init) before the servlet
     *  is accessed.
     */

    protected void setTitle(String title) {
        this.title = title;
    }

    /** First display title, then, for each catalog item,
     *  put its short description in a level-two (H2) heading
     *  with the price in parentheses and long description
     *  below. Below each entry, put an order button
     *  that submits info to the OrderPage servlet for
     *  the associated catalog entry.
     *  <P>
     *  To see the HTML that results from this method, do
     *  "View Source" on KidsBooksPage or TechBooksPage, two
     *  concrete classes that extend this abstract class.
     */

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        if (items == null) {
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
        for(int i=0; i<items.length; i++) {
            out.println("<HR>");
            item = items[i];
            // Show error message if subclass lists item ID
            // that's not in the catalog.
            if (item == null) {
                out.println("<FONT COLOR=\"RED\">" +
                        "Unknown item ID " + itemIDs[i] +
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

