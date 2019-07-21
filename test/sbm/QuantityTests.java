package sbm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class QuantityTests {
    @Test public void addition() {
        assertThat(new Quantity("0").plus(new Quantity("0")), equalTo(new Quantity("0")));
        assertThat(new Quantity("1").plus(new Quantity("2")), equalTo(new Quantity("3")));
        assertThat(new Quantity("1.1").plus(new Quantity("2.1")), equalTo(new Quantity("3.2")));
        assertThat(new Quantity("1.1").plus(new Quantity("-1.0")), equalTo(new Quantity("0.1")));
    }

    @Test public void subtraction() {
        assertThat(new Quantity("0").minus(new Quantity("0")), equalTo(new Quantity("0")));
        assertThat(new Quantity("3").minus(new Quantity("2")), equalTo(new Quantity("1")));
        assertThat(new Quantity("3.2").minus(new Quantity("1.1")), equalTo(new Quantity("2.1")));
        assertThat(new Quantity("1.1").minus(new Quantity("1.0")), equalTo(new Quantity("0.1")));
    }

    @Test public void equality() {
        assertThat(new Quantity("0"), equalTo(Quantity.ZERO));
        assertThat(new Quantity("0.0"), equalTo(Quantity.ZERO));
    }
}