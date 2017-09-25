package pl.gorczak.cashregister.model;

/**
 * Created by Piotr Gorczak.
 */
public class ReceiptItem {

    Item item;
    Integer numberOfItems;

    public ReceiptItem(Item item) {
        this.item = item;
        this.numberOfItems = 1;
    }

    public ReceiptItem(Item item, Integer numberOfItems) {
        this.item = item;
        this.numberOfItems = numberOfItems;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
