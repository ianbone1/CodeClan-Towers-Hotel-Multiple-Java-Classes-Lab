import java.util.ArrayList;

public class Hotel {

    private String name;
    private int numSingleRooms;
    private int numDoubleRooms;
    private int numFamilyRooms;
    private int numConferenceRooms;
    private int conferenceRoomCapacity;
    private int numFunctionRooms;
    private int functionRoomCapacity;

    private ArrayList<BedRoom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<FunctionRoom> functionRooms;

    public Hotel(String name, int numSingleRooms, int numDoubleRooms, int numFamilyRooms, int numConferenceRooms, int conferenceRoomCapacity, int numFunctionRooms, int functionRoomCapacity){
        this.name = name;

        this.bedrooms=new ArrayList<BedRoom>();
        this.conferenceRooms= new ArrayList<ConferenceRoom>();
        this.functionRooms= new ArrayList<FunctionRoom>();

        this.numSingleRooms=numSingleRooms;
        this.numDoubleRooms=numDoubleRooms;
        this.numFamilyRooms=numFamilyRooms;
        this.numConferenceRooms=numConferenceRooms;
        this.conferenceRoomCapacity=conferenceRoomCapacity;
        this.numFunctionRooms=numFunctionRooms;
        this.functionRoomCapacity=functionRoomCapacity;

        for (int i = 0; i < this.numSingleRooms; i++){
            this.bedrooms.add(new BedRoom(RoomType.SINGLE));
        }
        for (int i = 0; i < this.numDoubleRooms; i++){
            this.bedrooms.add(new BedRoom(RoomType.DOUBLE));
        }
        for (int i = 0; i < this.numFamilyRooms; i++){
            this.bedrooms.add(new BedRoom(RoomType.FAMILY));
        }
        for (int i = 0; i < this.numConferenceRooms; i++){
            this.conferenceRooms.add(new ConferenceRoom("Conference Room " + (i+1), this.conferenceRoomCapacity));
        }
        for (int i = 0; i < this.numFunctionRooms; i++){
            this.functionRooms.add(new FunctionRoom("Function Room " + (i+1), this.functionRoomCapacity));
        }

    }

    public int vacantBedrooms() {
        int emptyRooms=0;
        for (BedRoom room : this.bedrooms){
            if (room.isEmpty()){
                emptyRooms++;
            }
        }
        return emptyRooms;
    }

    public int vacantBedrooms(RoomType roomType) {
        int emptyRooms=0;
        for (BedRoom room : this.bedrooms){
            if (room.getRoomType() == roomType) {
                if (room.isEmpty()) {
                    emptyRooms++;
                }
            }
        }
        return emptyRooms;
    }

    public BedRoom checkin(Guest guest, RoomType roomType) {
        for (BedRoom room : this.bedrooms){
            if ((room.getRoomType() == roomType) && (room.isEmpty())){
                room.addGuest(guest);
                return room;
            }
        }
        return null;
    }

    public int getOccupancy() {
        int guests=0;
        for (BedRoom room : this.bedrooms){
            guests+=room.getOccupancy();
        }
        return guests;
    }


    public int vacantConferenceRooms() {
        int emptyRooms=0;
        for (ConferenceRoom room : this.conferenceRooms){
            if (room.isEmpty()) {
                    emptyRooms++;
            }
        }
        return emptyRooms;
    }

    public ConferenceRoom getVacantConferenceRoom() {
        for (ConferenceRoom room : this.conferenceRooms){
            if (room.isEmpty()){
                return room;
            }
        }
        return null;
    }

    public ConferenceRoom checkin(Guest guest) {
        for (ConferenceRoom room : this.conferenceRooms){
            if (room.isEmpty()){
                room.add(guest);
                return room;
            }
        }
        return null;
    }

    public int vacantFunctionRooms() {
        int emptyRooms=0;
        for (FunctionRoom room : this.functionRooms){
            if (room.isEmpty()) {
                emptyRooms++;
            }
        }
        return emptyRooms;
    }

    public FunctionRoom getVacantFunctionRoom() {
        for (FunctionRoom room : this.functionRooms){
            if (room.isEmpty()){
                return room;
            }
        }
        return null;
    }



}
