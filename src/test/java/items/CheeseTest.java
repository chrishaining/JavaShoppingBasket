package items;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CheeseTest {

    Cheese cheese;

    @Before
    public void before() {
        cheese = new Cheese(3.50, true);
    }

    @Test
    public void hasPrice() {
        assertEquals(3.50, cheese.getPrice(), 0.00);
    }

    @Test
    public void canCheckBuyOneGetOneFreeStatus() {
        assertTrue(cheese.checkBuyOneGetOneFreeStatus());
    }

}
