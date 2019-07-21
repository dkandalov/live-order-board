package sbm;

import org.junit.Test;

import java.math.BigDecimal;

public class LiveOrderBoardTests {
    @Test public void sellSideExample() {
        new Order(new UserId("some-user"), new BigDecimal("3.5"), new Price(303), Order.Type.SELL);
        // TODO
    }
}
