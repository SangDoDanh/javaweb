package coreservlets;

import javax.servlet.annotation.WebServlet;

/** A specialization of the CatalogPage servlet that
 *  displays a page selling two famous computer books.
 *  Orders are sent to the OrderPage servlet.
 */
@WebServlet(value = "/techbooks", name = "TechBooksPage")
public class TechBooksPage extends CatalogPage {
    public void init() {
        setItems("tech");
        setTitle("All-Time Best Computer Books");
    }
}
