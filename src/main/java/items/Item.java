package items;

public abstract class Item {

    private double price;
    private boolean buyOneGetOneFreeStatus;

    public Item(double price, boolean buyOneGetOneFreeStatus) {
        this.price = price;
        this.buyOneGetOneFreeStatus = buyOneGetOneFreeStatus;
    }

    public double getPrice() {
        return this.price;
    }

    public boolean checkBuyOneGetOneFreeStatus() {
        return this.buyOneGetOneFreeStatus;
    }

}
