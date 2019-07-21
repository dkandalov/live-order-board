package sbm;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static sbm.Order.Type.BUY;
import static sbm.Order.Type.SELL;

public class LiveOrderBoardTests {
    private final UserId user1 = new UserId("user1");
    private final UserId user2 = new UserId("user2");
    private final UserId user3 = new UserId("user3");
    private final UserId user4 = new UserId("user4");
    private final LiveOrderBoard orderBoard = new LiveOrderBoard();

    @Test public void emptyOrderBoardSummary() {
        assertThat(orderBoard.summaryOf(SELL), equalTo(emptyMap()));
        assertThat(orderBoard.summaryOf(BUY), equalTo(emptyMap()));
    }

    @Test public void exampleOfCellSideSummary() {
        List.of(
                new Order(user1, new Quantity("3.5"), new Price(306), SELL),
                new Order(user2, new Quantity("1.2"), new Price(310), SELL),
                new Order(user3, new Quantity("1.5"), new Price(307), SELL),
                new Order(user4, new Quantity("2.0"), new Price(306), SELL)
        ).forEach(orderBoard::register);

        assertThat(
                orderBoard.summaryOf(SELL),
                equalTo(Map.of(
                        new Price(306), new Quantity("5.5"),
                        new Price(307), new Quantity("1.5"),
                        new Price(310), new Quantity("1.2")
                ))
        );
        assertThat(orderBoard.summaryOf(BUY), equalTo(emptyMap()));
    }

    @Test public void exampleOfBuyAndSellSummary() {
        List.of(
                new Order(new UserId("user1"), new Quantity("3.5"), new Price(306), BUY),
                new Order(user2, new Quantity("1.2"), new Price(310), SELL),
                new Order(user3, new Quantity("1.5"), new Price(307), BUY),
                new Order(user4, new Quantity("2.0"), new Price(306), BUY)
        ).forEach(orderBoard::register);

        assertThat(
                orderBoard.summaryOf(BUY),
                equalTo(Map.of(
                        new Price(306), new Quantity("5.5"),
                        new Price(307), new Quantity("1.5")
                ))
        );
        assertThat(
                orderBoard.summaryOf(SELL),
                equalTo(Map.of(new Price(310), new Quantity("1.2")))
        );
    }

    @Test public void cancellingOrderIsReflectedInSummary() {
        OrderId buyOrderId = orderBoard.register(new Order(new UserId("user1"), new Quantity("3.5"), new Price(306), BUY));
        orderBoard.cancel(buyOrderId);

        OrderId sellOrderId = orderBoard.register(new Order(new UserId("user1"), new Quantity("3.5"), new Price(306), SELL));
        orderBoard.cancel(sellOrderId);

        assertThat(orderBoard.summaryOf(SELL), equalTo(emptyMap()));
        assertThat(orderBoard.summaryOf(BUY), equalTo(emptyMap()));
    }
}
