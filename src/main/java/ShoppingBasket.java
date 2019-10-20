import items.Item;

import java.util.ArrayList;
import java.util.Collections;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private ArrayList<Item> discountedItems;
    private double totalValue;
    private boolean hasLoyaltyCard;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
        this.discountedItems = new ArrayList<Item>();
        this.totalValue = 0;
        this.hasLoyaltyCard = false;
    }

    public int countItems() {
        return this.items.size();
    }

    public int countDiscountedItems() {return this.discountedItems.size();}

    public double getTotalValue() {
        return this.totalValue;
    }

    public void addItem(Item newItem) {
        if (newItem.checkBuyOneGetOneFreeStatus() == true) {
            this.discountedItems.add(newItem);
        } else {
            this.items.add(newItem);
        }

    }

    public void removeItem(Item unwantedItem) {
        this.items.remove(unwantedItem);
    }

    public void removeDiscountedItem(Item unwantedItem) {
        this.discountedItems.remove(unwantedItem);
    }

    public void emptyTheBasket() {
        this.items.clear();
    }

    public void emptyTheDiscountBasket() {
        this.discountedItems.clear();
    }

    public void emptyTheWholeBasket() {
        this.emptyTheBasket();
        this.emptyTheDiscountBasket();
    }

    public boolean checkLoyalty() {
        return this.hasLoyaltyCard;
    }

    public void addLoyaltyCard() {
        this.hasLoyaltyCard = true;
    }

    public double calculateTotalValueOfNonDiscountedItems() {
        for (Item item : items) {
            this.totalValue += item.getPrice();
        }

        return this.getTotalValue();
    }

//    public void putDiscountItemsIntoSeparateList() {
//        new ArrayList<Item> ();
//        for (Item item : this.items) {
//            if (item.checkBuyOneGetOneFreeStatus() == true) {
//                this.discountedItems.add(item);
//                this.items.remove(item);
//            }
//        }
//    }

//    I can use frequency to count the occurrences of a specified item - e.g. cheese - in discountedItems. So I know that frequency can work.
//    public int frequencyOfCheese(Item item) {
//        int frequency = Collections.frequency(this.discountedItems, item);
//        return frequency;
//    }

    //I now want to use the frequency to do more
    public double calculateDiscountItemsValue() {
        double totalValueOfDiscountedItems = 0;
        for (Item item : this.discountedItems) {
            int frequency = Collections.frequency(this.discountedItems, item);
            if (frequency > 1) {
//                int reducedFrequency = frequency / 2;
//                totalValueOfDiscountedItems += item.getPrice();
                totalValueOfDiscountedItems += (0.5 * item.getPrice());

            } else totalValueOfDiscountedItems += item.getPrice();
        }
        return totalValueOfDiscountedItems;
    }

    public double calculateTotalOfNormalAndDiscountedItems() {
//        this.putDiscountItemsIntoSeparateList();
        double discounts = this.calculateDiscountItemsValue();
        double normals = this.calculateTotalValueOfNonDiscountedItems();
        this.totalValue = discounts + normals;
        return this.totalValue;
    }

public double calculateTotalLessTenPercent() {
        this.totalValue = 0.9 * this.calculateTotalOfNormalAndDiscountedItems();
        return this.totalValue;
}


public double calculateTotalWithAllDiscounts() {
        this.totalValue = 0.98 * this.calculateTotalLessTenPercent();
        return this.totalValue;
}

}
