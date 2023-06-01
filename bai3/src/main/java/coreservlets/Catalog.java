package coreservlets;

import repository.CatalogDao;

import java.sql.SQLException;
import java.util.List;

/**
 * A catalog that lists the items available in inventory.
 */

public class Catalog {
    // This would come from a database in real life.
    // We use a static table for ease of testing and deployment.
    // See JDBC chapters for info on using databases in
    // servlets and JSP pages.
    private static List<CatalogItem> items;

    static {
        try {
            items = CatalogDao.getAllCatalog();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static CatalogItem getItem(String itemID) {
        CatalogItem item;
        if (itemID == null) {
            return (null);
        }
        for (CatalogItem catalogItem : items) {
            item = catalogItem;
            if (itemID.equals(item.getItemID())) {
                return (item);
            }
        }
        return (null);
    }
}

