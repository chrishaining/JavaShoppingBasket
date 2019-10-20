import items.Cheese;
import items.Milk;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Cheese cheese;
    Cheese poshCheese;
    Milk milk;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
        cheese = new Cheese(3.50, true);
        poshCheese = new Cheese(7.50, false);
        milk = new Milk(1.20, false);
    }

    @Test
    public void totalValueStartsAtZero() {
        assertEquals(0, shoppingBasket.getTotalValue(), 0.01);
    }

    @Test
    public void basketStartsEmpty () {
        assertEquals(0, shoppingBasket.countItems());
    }

    @Test
    public void discountBasketStartsEmpty() {
        assertEquals(0, shoppingBasket.countDiscountedItems());
    }

    @Test
    public void canAddItem() {
        shoppingBasket.addItem(cheese);
        assertEquals(0, shoppingBasket.countItems());
        assertEquals(1, shoppingBasket.countDiscountedItems());

    }

    @Test
    public void canRemoveItem() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.removeItem(cheese);
        assertEquals(0, shoppingBasket.countItems());
    }

    @Test
    public void canRemoveItemFromDiscountBasket() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.removeDiscountedItem(cheese);
        assertEquals(0, shoppingBasket.countDiscountedItems());
    }

    @Test
    public void canEmptyBasket() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(poshCheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.emptyTheBasket();
        assertEquals(0, shoppingBasket.countItems());
    }

    @Test
    public void canEmptyTheWholeBasket() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(poshCheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.emptyTheWholeBasket();
        assertEquals(0, shoppingBasket.countItems());
        assertEquals(0, shoppingBasket.countDiscountedItems());
    }

    @Test
    public void canEmptyTheDiscountBasket() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.emptyTheDiscountBasket();
        assertEquals(0, shoppingBasket.countDiscountedItems());
    }

    @Test
    public void loyaltyCardStartsFalse() {
        assertEquals(false, shoppingBasket.checkLoyalty());
    }

    @Test
    public void canAddLoyaltyCard() {
        shoppingBasket.addLoyaltyCard();
        assertEquals(true, shoppingBasket.checkLoyalty());
    }

    @Test
    public void canCalculateTotalOfNormalAndDiscountedItems() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(poshCheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(milk);
        assertEquals(16.90, shoppingBasket.calculateTotalOfNormalAndDiscountedItems(), 0.01);

    }

    @Test
    public void canCalculateTotalLessTenPercent() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(poshCheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(milk);
        assertEquals(15.20, shoppingBasket.calculateTotalLessTenPercent(), 0.01);
    }

    @Test
    public void canCalculateTotalWithAllDiscounts() {
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(poshCheese);
        shoppingBasket.addItem(milk);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(cheese);
        shoppingBasket.addItem(milk);
        assertEquals(14.90, shoppingBasket.calculateTotalWithAllDiscounts(), 0.01);
    }
}
