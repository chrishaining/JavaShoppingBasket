import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private double totalValue;

    public ShoppingBasket() {
        this.items = new ArrayList<Item>();
        this.totalValue = 0;
    }

    public double countItems() {
        return this.items.size();
    }

    public double getTotalValue() {
        return this.totalValue;
    }
}
