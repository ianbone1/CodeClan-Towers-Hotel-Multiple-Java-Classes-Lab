public enum RoomType {
    SINGLE(1),
    DOUBLE(2),
    FAMILY(4);

    final int capacity;

    RoomType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
