import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestBedRoom {
    private BedRoom room0;
    private Guest guest0;

    @Before
    public void setup(){
        this.room0 = new BedRoom(RoomType.SINGLE);
        this.guest0 = new Guest("Ian");
    }

    @Test
    public void testRoomEmpty() {
        assertEquals(0, room0.getOccupancy());
        assertEquals(true, room0.isEmpty());
    }

    @Test
    public void testRoomCapacity() {
        assertEquals(1, room0.getCapacity());
    }

    @Test
    public void testAddGuestToRoom() {
        this.room0.addGuest(guest0);
        assertEquals(1, this.room0.getOccupancy());
    }

    @Test
    public void testCanNotOverOccupy() {
        for (int i = 0; i< 5; i++){
            room0.addGuest(guest0);
        }
        assertEquals(1, this.room0.getOccupancy());
    }
}
