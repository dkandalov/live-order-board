package sbm;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static sbm.Order.Type.SELL;

public class LiveOrderBoardTests {
    @Test public void sellSideExample() {
        List<Order> orders = List.of(
                new Order(new UserId("user1"), new Quantity("3.5"), new Price(306), SELL),
                new Order(new UserId("user2"), new Quantity("1.2"), new Price(310), SELL),
                new Order(new UserId("user3"), new Quantity("1.5"), new Price(307), SELL),
                new Order(new UserId("user4"), new Quantity("2.0"), new Price(306), SELL)
        );
        LiveOrderBoard orderBoard = new LiveOrderBoard();
        orders.forEach(orderBoard::register);

        assertThat(
                orderBoard.summaryOf(SELL),
                equalTo(Map.of(
                        new Price(306), new Quantity("5.5"),
                        new Price(307), new Quantity("1.5"),
                        new Price(310), new Quantity("1.2")
                ))
        );
    }
}
