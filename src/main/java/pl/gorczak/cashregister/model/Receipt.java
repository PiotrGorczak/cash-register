package pl.gorczak.cashregister.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotr Gorczak.
 */
public class Receipt {

    Map<String, ReceiptItem> receiptItems;
    Integer sum;

    public Receipt() {
        this.receiptItems = new HashMap<>();
        this.sum = new Integer("0");
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Map<String, ReceiptItem> getReceiptItems() {
        return receiptItems;
    }
}
