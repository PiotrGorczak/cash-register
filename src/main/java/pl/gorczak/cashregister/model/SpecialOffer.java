package pl.gorczak.cashregister.model;

/**
 * Created by Piotr Gorczak.
 */
public class SpecialOffer {

    Integer price;
    Integer numberOfItems;

    public SpecialOffer(Integer price, Integer numberOfItems) {
        this.price = price;
        this.numberOfItems = numberOfItems;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }
}
