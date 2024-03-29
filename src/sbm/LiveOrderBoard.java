package sbm;

import java.util.*;

public class LiveOrderBoard {
    private final Map<OrderId, Order> orders = new HashMap<>();
    private final TreeMap<Price, Quantity> sellSummary = new TreeMap<>();
    private final TreeMap<Price, Quantity> buySummary = new TreeMap<>(Comparator.reverseOrder());

    public OrderId register(Order order) {
        OrderId orderId = new OrderId();
        orders.put(orderId, order);
        addTo(summaryOf(order.type), order);
        return orderId;
    }

    public void cancel(OrderId orderId) {
        Order order = orders.remove(orderId);
        removeFrom(summaryOf(order.type), order);
    }

    public Map<Price, Quantity> summaryOf(Order.Type type) {
        if (type == Order.Type.SELL) return sellSummary;
        else if (type == Order.Type.BUY) return buySummary;
        else throw new IllegalStateException();
    }

    private void addTo(Map<Price, Quantity> summary, Order order) {
        Quantity quantity = summary.getOrDefault(order.price, Quantity.ZERO);
        summary.put(order.price, quantity.plus(order.quantity));
    }

    private void removeFrom(Map<Price, Quantity> summary, Order order) {
        Quantity quantity = summary.get(order.price);
        Quantity newQuantity = quantity.minus(order.quantity);
        if (newQuantity.equals(Quantity.ZERO)) {
            summary.remove(order.price);
        } else {
            summary.put(order.price, newQuantity);
        }
    }
}
