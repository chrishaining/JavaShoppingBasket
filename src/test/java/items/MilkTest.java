package items;

import items.Milk;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MilkTest {

    Milk milk;

    @Before
    public void before() {
        milk = new Milk(1.20, false);
    }

    @Test
    public void hasPrice() {
        assertEquals(1.20, milk.getPrice(), 0.00);
    }

    @Test
    public void canCheckBuyOneGetOneFreeStatus() {
        assertFalse(milk.checkBuyOneGetOneFreeStatus());
    }

}