import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;

    @Before
    public void before() {
        shoppingBasket = new ShoppingBasket();
    }

    @Test
    public void totalValueStartsAtZero() {
        assertEquals(0, shoppingBasket.getTotalValue(), 0.00);
    }

    @Test
    public void basketStartsEmpty () {
        assertEquals(0, shoppingBasket.countItems());
    }
}
