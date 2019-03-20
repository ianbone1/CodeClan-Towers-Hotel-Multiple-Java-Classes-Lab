import java.util.ArrayList;

public class BedRoom {

    private RoomType roomType;
    private ArrayList<Guest> guests;

    public BedRoom(RoomType roomType){
        this.roomType=roomType;
        this.guests = new ArrayList<Guest>();

    }

    public int getOccupancy() {
        return this.guests.size();
    }


    public int getCapacity() {
        return roomType.getCapacity();
    }

    public RoomType getRoomType(){
        return this.roomType;
    }

    public void addGuest(Guest guest) {
        if (this.getOccupancy() < this.getCapacity()){
            this.guests.add(guest);
        }
    }

    public boolean isEmpty(){
        if (this.getOccupancy()==0){
            return true;
        }
        return false;
    }

    public void checkout(Guest guest) {
        this.guests.remove(guest);
    }

    public void checkoutAll() {
        this.guests.clear();
    }
}
