package sbm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LiveOrderBoard {
    private final List<Order> orders = new ArrayList<>();

    public void register(Order order) {
        orders.add(order);
    }

    public Map<Price, Quantity> summaryOf(Order.Type type) {
        Map<Price, Quantity> summary = new HashMap<>();
        for (Order order : orders) {
            if (order.type != type) continue;
            Quantity quantity = summary.getOrDefault(order.price, Quantity.ZERO);
            summary.put(order.price, order.quantity.add(quantity));
        }
        return summary;
    }
}
