package sbm;

import java.util.*;

public class LiveOrderBoard {
    private final LinkedHashMap<OrderId, Order> orders = new LinkedHashMap<>();

    public OrderId register(Order order) {
        OrderId orderId = new OrderId();
        orders.put(orderId, order);
        return orderId;
    }

    public Map<Price, Quantity> summaryOf(Order.Type type) {
        Map<Price, Quantity> summary = new HashMap<>();
        for (Order order : orders.values()) {
            if (order.type != type) continue;
            Quantity quantity = summary.getOrDefault(order.price, Quantity.ZERO);
            summary.put(order.price, order.quantity.add(quantity));
        }
        return summary;
    }

    public void cancel(OrderId orderId) {
        orders.remove(orderId);
    }
}
