import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestConferenceRoom {

    ConferenceRoom croom0;
    Guest guest0;

    @Before
    public void setup(){
        croom0 = new ConferenceRoom("Gleddoch",10);
        guest0 = new Guest("Ian");
    }

    @Test
    public void testCapacity() {
        assertEquals(10, croom0.getCapacity());
    }

    @Test
    public void testOccupancy() {
        assertEquals(0, croom0.getOccupancy());
    }

    @Test
    public void TestCanAddGuest() {
        croom0.add(guest0);
        assertEquals(1, croom0.getOccupancy());
    }

    @Test
    public void testCanOnlyAdd10() {
        for (int i = 0; i<15; i++){
            croom0.add(guest0);
        }
        assertEquals(10, croom0.getOccupancy());

    }
}
