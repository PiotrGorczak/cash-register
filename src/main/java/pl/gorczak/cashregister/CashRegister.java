package pl.gorczak.cashregister;

import pl.gorczak.cashregister.model.Item;
import pl.gorczak.cashregister.model.Receipt;
import pl.gorczak.cashregister.model.ReceiptItem;
import pl.gorczak.cashregister.model.SpecialOffer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Piotr Gorczak.
 */
public class CashRegister {

    private static final Map<String, Item> itemPriceRegistry;
    static {
        Map<String, Item> tempMap = new HashMap<>();

        SpecialOffer specialOfferForFirstItem = new SpecialOffer(70, 3);
        Item firstItem = new Item("A", 40, specialOfferForFirstItem);

        SpecialOffer specialOfferForSecondItem = new SpecialOffer(15, 2);
        Item secondItem = new Item("B", 10, specialOfferForSecondItem);

        Item thirdItem = new Item("C", 30);

        tempMap.put(firstItem.getName(), firstItem);
        tempMap.put(secondItem.getName(), secondItem);
        tempMap.put(thirdItem.getName(), thirdItem);
        itemPriceRegistry = Collections.unmodifiableMap(tempMap);
    }

    private static Receipt receipt;

    public static int addItemToReceipt(final String itemName) {

        final Item item = itemPriceRegistry.get(itemName);

        Map<String, ReceiptItem> receiptItems = receipt.getReceiptItems();

        if(item != null) {

            ReceiptItem receiptItem;
            if (receiptItems.containsKey(item.getName())) {
                receiptItem = receiptItems.get(item.getName());

                Integer numberOfItems = receiptItem.getNumberOfItems();
                Integer updatedNumberOfItems = numberOfItems + 1;
                receiptItem.setNumberOfItems(updatedNumberOfItems);

            } else {
                receiptItem = new ReceiptItem(item);
            }

            receiptItems.put(item.getName(), receiptItem);
            updateReceiptSum(item, receiptItem.getNumberOfItems());
        }

        return receipt.getSum();
    }

    private static void updateReceiptSum(final Item item, final Integer updatedNumberOfItems) {
        Integer sum = receipt.getSum();
        final SpecialOffer specialOffer = item.getSpecialOffer();

        if(specialOffer != null && isSpecialOfferApplicable(item, updatedNumberOfItems)) {
            sum -= (specialOffer.getNumberOfItems() - 1) * item.getPrice();
            sum += specialOffer.getPrice();
        } else {
            sum += item.getPrice();
        }

        receipt.setSum(sum);
    }

    private static boolean isSpecialOfferApplicable(Item item, Integer updatedNumberOfItems) {
        return updatedNumberOfItems % item.getSpecialOffer().getNumberOfItems() == 0;
    }

    public static void createNewReceipt() {
        receipt = new Receipt();
    }
}
