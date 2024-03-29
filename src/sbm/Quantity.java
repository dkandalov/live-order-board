package sbm;

import java.math.BigDecimal;
import java.util.Objects;

public class Quantity {
    public static final Quantity ZERO = new Quantity(BigDecimal.ZERO);
    private final BigDecimal value;

    public Quantity(String value) {
        this(new BigDecimal(value));
    }

    public Quantity(BigDecimal value) {
        this.value = value;
    }

    public Quantity plus(Quantity that) {
        return new Quantity(value.add(that.value));
    }

    public Quantity minus(Quantity that) {
        return new Quantity(value.subtract(that.value));
    }

    @Override public String toString() {
        return "Quantity{value=" + value + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quantity quantity = (Quantity) o;
        return value.unscaledValue().equals(quantity.value.unscaledValue());
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
