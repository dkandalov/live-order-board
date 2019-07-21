package sbm;

import java.util.Objects;

public class Price implements Comparable<Price> {
    private final int value;

    public Price(int value) {
        this.value = value;
    }

    @Override public int compareTo(Price that) {
        return Integer.compare(value, that.value);
    }

    @Override public String toString() {
        return "Price{value=" + value + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value == price.value;
    }

    @Override public int hashCode() {
        return Objects.hash(value);
    }
}
