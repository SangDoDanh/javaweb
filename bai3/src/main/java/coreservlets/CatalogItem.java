package coreservlets;

public class CatalogItem {
    private String itemID;
    private String shortDescription;
    private String longDescription;
    private double cost;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CatalogItem(String itemID, String shortDescription,
                       String longDescription, double cost) {
        setItemID(itemID);
        setShortDescription(shortDescription);
        setLongDescription(longDescription);
        setCost(cost);
    }

    public CatalogItem() {
    }


    public String getItemID() {
        return(itemID);
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getShortDescription() {
        return(shortDescription);
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return(longDescription);
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public double getCost() {
        return(cost);
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

