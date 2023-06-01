package coreservlets;

import javax.servlet.annotation.WebServlet;

/** A specialization of the CatalogPage servlet that
 *  displays a page selling three famous kids-book series.
 *  Orders are sent to the OrderPage servlet.
 */
@WebServlet(value = "/kidbooks", name = "KidsBooksPage")
public class KidsBooksPage extends CatalogPage {
    public void init() {
        setItems("kid");
        setTitle("All-Time Best Children's Fantasy Books");
    }
}
