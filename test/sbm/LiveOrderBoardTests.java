package sbm;

import org.junit.Test;

import java.math.BigDecimal;

import static sbm.Order.Type.SELL;

public class LiveOrderBoardTests {
    @Test public void sellSideExample() {
        new Order(new UserId("user1"), new Quantity("3.5"), new Price(306), SELL);
        new Order(new UserId("user2"), new Quantity("1.2"), new Price(310), SELL);
        new Order(new UserId("user3"), new Quantity("1.5"), new Price(307), SELL);
        new Order(new UserId("user4"), new Quantity("2.0"), new Price(306), SELL);
        // TODO
    }
}
