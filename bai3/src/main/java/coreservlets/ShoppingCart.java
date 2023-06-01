package coreservlets;

import repository.CartDao;

import java.util.List;

/** A shopping cart data structure used to track orders.
 *  The OrderPage servlet associates one of these carts
 *  with each user session.
 */

public class ShoppingCart {
    private List<ItemOrder> itemsOrdered;


    public ShoppingCart() {
        itemsOrdered = CartDao.getAll();
    }


    public List getItemsOrdered() {
        return CartDao.getAll();
    }

    public synchronized void addItem(String itemID) {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++) {
            order = itemsOrdered.get(i);
            if (order.getItemID().equals(itemID)) {
                order.incrementNumItems();
                CartDao.updateNumItem(order);
                return;
            }
        }
        ItemOrder newOrder = new ItemOrder(Catalog.getItem(itemID));
        itemsOrdered.add(newOrder);
        CartDao.addItem(newOrder);

    }

    public synchronized void setNumOrdered(String itemID, int numOrdered) {
        ItemOrder order;
        for(int i=0; i<itemsOrdered.size(); i++) {
            order = itemsOrdered.get(i);
            if (order.getItemID().equals(itemID)) {
                if (numOrdered <= 0) {
                    itemsOrdered.remove(i);
                    CartDao.deleteCatalogItem(order);
                } else {
                    order.setNumItems(numOrdered);
                    CartDao.updateNumItem(order);
                }
                return;
            }
        }
        ItemOrder newOrder =
                new ItemOrder(Catalog.getItem(itemID));
        itemsOrdered.add(newOrder);
        CartDao.addItem(newOrder);
    }
}

