package sbm;

import java.util.Objects;
import java.util.UUID;

public class OrderId {
    private final UUID value;

    public OrderId() {
        this(UUID.randomUUID());
    }

    public OrderId(UUID value) {
        this.value = value;
    }

    @Override public String toString() {
        return "OrderId{value='" + value + '\'' + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderId orderId = (OrderId) o;
        return value.equals(orderId.value);
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
