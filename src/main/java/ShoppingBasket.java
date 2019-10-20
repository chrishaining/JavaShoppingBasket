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

    public double calculateDiscountItemsValue() {
        double totalValueOfDiscountedItems = 0;
        for (Item item : this.discountedItems) {
            int frequency = Collections.frequency(this.discountedItems, item);
            if (frequency > 1) {
                if (frequency % 2 != 0) {
                    totalValueOfDiscountedItems += ((0.5 * item.getPrice()) + 1);
                } else {totalValueOfDiscountedItems += (0.5 * item.getPrice());}
            } else totalValueOfDiscountedItems += item.getPrice();
        }
        return totalValueOfDiscountedItems;
    }

    public double calculateTotalOfNormalAndDiscountedItems() {
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
        if (this.getTotalValue() > 20) {
        this.totalValue = 0.98 * this.calculateTotalLessTenPercent();}
        else {this.totalValue = 0.98 * this.calculateTotalOfNormalAndDiscountedItems();}
        return this.totalValue;
    }

}
