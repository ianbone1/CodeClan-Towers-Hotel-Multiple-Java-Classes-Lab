import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFunctionRoom {

    FunctionRoom froom;
    Guest guest0;

    @Before
    public void setup(){
        froom = new FunctionRoom("Ball Room", 200);
        guest0 = new Guest("Ian");
    }

    @Test
    public void testCapacity() {
        assertEquals(200, froom.getCapacity());
    }

    @Test
    public void testOccupancyStartsEmpty() {
        assertEquals(0, froom.getOccupancy());
    }

    @Test
    public void testAddGuest() {
        froom.add(guest0);
        assertEquals(1, froom.getOccupancy());
    }

    @Test
    public void testCanNotOverOccupy() {
        for (int i =0; i< 250; i++){
            froom.add(guest0);
        }
        assertEquals(200, froom.getOccupancy());
    }
}
