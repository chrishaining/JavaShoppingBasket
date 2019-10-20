import items.Item;

import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private double totalValue;
    private boolean hasLoyaltyCard;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
        this.totalValue = 0;
        this.hasLoyaltyCard = false;
    }

    public int countItems() {
        return this.items.size();
    }

    public double getTotalValue() {
        return this.totalValue;
    }

    public void addItem(Item newItem) {
        this.items.add(newItem);
    }

    public void removeItem(Item unwantedItem) {
        this.items.remove(unwantedItem);
    }

    public boolean checkLoyalty() {
        return this.hasLoyaltyCard;
    }

    public void addLoyaltyCard() {
        this.hasLoyaltyCard = true;
    }

    public double calculateTotalValue() {
        for (Item item : items) {
            this.totalValue += item.getPrice();
        }
        return this.getTotalValue();
    }


}
