package pl.gorczak.cashregister;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Piotr Gorczak.
 */
public class CashRegisterTest {

    @Before
    public void setUp() {
        CashRegister.createNewReceipt();
    }

    @Test
    public void whenOneItemIsAddedThenReturnPriceOfThatItem() {
        Assert.assertEquals(40, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenTwoItemsAreAddedThenReturnSumOfThem() {
        Assert.assertEquals(40, CashRegister.addItemToReceipt("A"));
        Assert.assertEquals(80, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenTheNumberOfItemsSatisfyDiscountTermsThenReturnSumWithSpecialPriceApplied() {
        Assert.assertEquals(40, CashRegister.addItemToReceipt("A"));
        Assert.assertEquals(80, CashRegister.addItemToReceipt("A"));
        Assert.assertEquals(70, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenTheNumberOfItemsAllowToApplyDiscountMultipleTimesThenReturnSumWithMultiDiscountAndItemsWithRegularPrice() {
        for(int i = 1; i < 7; i++) {
            CashRegister.addItemToReceipt("A");
        }
        Assert.assertEquals(180, CashRegister.addItemToReceipt("A"));
    }

    @Test
    public void whenItemIsNullThenShouldReturnSumUnchanged() {
        Assert.assertEquals(40, CashRegister.addItemToReceipt("A"));
        Assert.assertEquals(40, CashRegister.addItemToReceipt(null));
    }

    @Test
    public void whenThereAreManyItemsWithDifferentDiscountsAndWithoutDiscountsThenSumShouldBeCalculateAccordingly() {
        //7 "A" items
        for(int i = 1; i < 8; i++) {
            CashRegister.addItemToReceipt("A");
        }

        //5 "B" items
        for(int i = 1; i < 6; i++) {
            CashRegister.addItemToReceipt("B");
        }

        Assert.assertEquals(250, CashRegister.addItemToReceipt("C"));
    }

}
