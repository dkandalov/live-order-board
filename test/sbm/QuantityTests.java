package sbm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class QuantityTests {
    @Test public void addition() {
        assertThat(new Quantity("0").add(new Quantity("1")), equalTo(new Quantity("1")));
        assertThat(new Quantity("1").add(new Quantity("2")), equalTo(new Quantity("3")));
        assertThat(new Quantity("1.1").add(new Quantity("2.1")), equalTo(new Quantity("3.2")));
        assertThat(new Quantity("1.1").add(new Quantity("-1.0")), equalTo(new Quantity("0.1")));
    }
}