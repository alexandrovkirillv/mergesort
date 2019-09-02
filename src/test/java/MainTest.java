import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void number() {

        Main m = new Main();

        int expected = m.number(2);

        int actual = 2;

        assertEquals(expected,actual);

    }
}