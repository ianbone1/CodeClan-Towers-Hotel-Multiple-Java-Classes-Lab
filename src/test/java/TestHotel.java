import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestHotel {

    Hotel hotel;
    Guest guest0;

    @Before
    public void setup(){
        hotel = new Hotel("Ritz", 10, 10, 4, 3,25,2,100);
        guest0 = new Guest("Ian");
    }

    @Test
    public void testCountAllEmptyRooms() {
        assertEquals(24, hotel.vacantBedrooms());
    }

    @Test
    public void testCountSINGLEEmptyRooms() {
        assertEquals(10, hotel.vacantBedrooms(RoomType.SINGLE));
    }

    @Test
    public void testCountDOUBLEEmptyRooms() {
        assertEquals(10, hotel.vacantBedrooms(RoomType.DOUBLE));
    }

    @Test
    public void testCountFAMILYEmptyRooms() {
        assertEquals(4, hotel.vacantBedrooms(RoomType.FAMILY));
    }

    @Test
    public void testCheckinSINGLE() {
        BedRoom room = hotel.checkin(guest0,RoomType.SINGLE);
        assertEquals(9, hotel.vacantBedrooms(RoomType.SINGLE));
        assertNotNull(room);
    }

    @Test
    public void testNoMoreSingles(){
        BedRoom room = new BedRoom(RoomType.SINGLE);
        for (int i=0; i<11; i++) {
            room = hotel.checkin(guest0, RoomType.SINGLE);
        }
        assertEquals(0, hotel.vacantBedrooms(RoomType.SINGLE));
        assertNull(room);
        assertEquals(10, hotel.getOccupancy());
    }

    @Test
    public void testCheckoutGuest() {
        BedRoom room = hotel.checkin(guest0, RoomType.SINGLE);
        room.checkout(guest0);
        assertEquals(0, room.getOccupancy());
    }

    @Test
    public void testCheckoutAll() {
        BedRoom room = hotel.checkin(guest0, RoomType.DOUBLE);
        room.addGuest(guest0);
        assertEquals(2,room.getOccupancy());
        room.checkoutAll();
        assertEquals(0,room.getOccupancy());
    }

    @Test
    public void testConferenceRoomsEmpty() {
        assertEquals(3, hotel.vacantConferenceRooms());
    }

    @Test
    public void testAdd4guestToOneConferenceRoom() {
        ConferenceRoom freeRoom = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom);
        freeRoom.add(guest0);
        freeRoom.add(guest0);
        freeRoom.add(guest0);
        freeRoom.add(guest0);
        assertEquals(2, hotel.vacantConferenceRooms());
        assertEquals(4,freeRoom.getOccupancy());
    }

    @Test
    public void testNoMoreConferenceRooms() {
        ConferenceRoom freeRoom1 = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom1);
        freeRoom1.add(guest0);
        assertEquals(2, hotel.vacantConferenceRooms());
        ConferenceRoom freeRoom2 = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom2);
        freeRoom2.add(guest0);
        assertEquals(1, hotel.vacantConferenceRooms());
        ConferenceRoom freeRoom3 = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom3);
        freeRoom3.add(guest0);
        assertEquals(0, hotel.vacantConferenceRooms());
        ConferenceRoom freeRoom4 = hotel.getVacantConferenceRoom();
        assertNull(freeRoom4);
    }

    @Test
    public void checkoutAGuestFromConferenceRoom() {
        ConferenceRoom freeRoom1 = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom1);
        freeRoom1.add(guest0);
        assertEquals(1, freeRoom1.getOccupancy());
        freeRoom1.checkout(guest0);
        assertEquals(0, freeRoom1.getOccupancy());
    }

    @Test
    public void checkoutAllGuestsFromConferenceRoom() {
        ConferenceRoom freeRoom1 = hotel.getVacantConferenceRoom();
        assertNotNull(freeRoom1);
        freeRoom1.add(guest0);
        freeRoom1.add(guest0);
        freeRoom1.add(guest0);
        freeRoom1.add(guest0);
        freeRoom1.add(guest0);
        assertEquals(5, freeRoom1.getOccupancy());
        freeRoom1.checkoutAll();
        assertEquals(0, freeRoom1.getOccupancy());
    }


    @Test
    public void testFunctionsRoomsStartEmpty() {
        assertEquals(2, hotel.vacantFunctionRooms());
    }

    @Test
    public void testAdd3guestsToFunctionRoom() {
        FunctionRoom room = new FunctionRoom("", 0);
        room = hotel.getVacantFunctionRoom();
        room.add(guest0);
        room.add(guest0);
        room.add(guest0);
        assertEquals(1, hotel.vacantFunctionRooms());
        assertEquals(3, room.getOccupancy());
    }
}
