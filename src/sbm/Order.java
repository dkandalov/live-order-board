package sbm;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private final UserId userId;
    private final BigDecimal quantity;
    private final Price price;
    private final Type type;

    public Order(UserId userId, BigDecimal quantity, Price price, Type type) {
        this.userId = userId;
        this.quantity = quantity;
        this.price = price;
        this.type = type;
    }

    public enum Type {
        SELL, BUY
    }

    @Override public String toString() {
        return "Order{" +
                "userId=" + userId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", type=" + type +
                '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return userId.equals(order.userId) &&
                quantity.equals(order.quantity) &&
                price.equals(order.price) &&
                type == order.type;
    }

    @Override public int hashCode() {
        return Objects.hash(userId, quantity, price, type);
    }
}
