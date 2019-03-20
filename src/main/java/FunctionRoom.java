import java.util.ArrayList;

public class FunctionRoom {

    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public FunctionRoom(String name, int capacity){
        this.name=name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupancy() {
        return guests.size();
    }

    public void add(Guest guest) {
        if (this.getOccupancy() < this.getCapacity()){
            this.guests.add(guest);
        }
    }


    public boolean isEmpty() {
        if (this.getOccupancy() == 0){
            return true;
        }
        return false;
    }

    public void checkout(Guest guest){
        this.guests.remove(guest);
    }

    public void checkoutAll(){
        this.guests.clear();
    }
}
