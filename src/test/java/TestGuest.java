import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGuest {

    Guest guest0;

    @Before
    public void setup(){
        guest0 = new Guest("Ian");
    }

    @Test
    public void testGuestHasName() {
        assertEquals("Ian", guest0.getName());
    }
}
