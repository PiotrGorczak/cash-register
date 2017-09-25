package pl.gorczak.cashregister.model;

/**
 * Created by Piotr Gorczak.
 */
public class Item {

    String name;
    Integer price;
    SpecialOffer specialOffer;

    public Item(String name, Integer price, SpecialOffer specialOffer) {
        this.name = name;
        this.price = price;
        this.specialOffer = specialOffer;
    }

    public Item(String name, Integer price) {
        this.name = name;
        this.price = price;
        this.specialOffer = null;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public SpecialOffer getSpecialOffer() {
        return specialOffer;
    }
}
