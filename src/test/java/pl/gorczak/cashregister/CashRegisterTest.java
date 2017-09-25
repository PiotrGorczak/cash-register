package pl.gorczak.cashregister;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Piotr Gorczak.
 */
public class CashRegisterTest {

    @Test
    public void whenOneItemIsAddedThenReturnPriceOfThatItem() {
        Assert.assertEquals(40, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenTwoItemsAreAddedThenReturnSumOfThem() {
        CashRegister.addItemToReceipt("A");
        Assert.assertEquals(80, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenTheNumberOfItemsSatisfyDiscountTermsThenReturnSumWithSpecialPriceApplied() {
        CashRegister.addItemToReceipt("A");
        CashRegister.addItemToReceipt("A");
        Assert.assertEquals(70, CashRegister.addItemToReceipt("A"));
    }

}
