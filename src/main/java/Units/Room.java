package Units;

public class Room {
    private int corpusNumber;
    private int roomNumber;
    private int maxPeople;
    private String equipments;

    public Room(int _corpusNumber, int _roomNumber, int _maxPeople, String _equipments){
        corpusNumber = _corpusNumber;
        roomNumber = _roomNumber;
        maxPeople = _maxPeople;
        equipments =  _equipments;
    }
    public int getCorpusNumber() {
        return corpusNumber;
    }

    public void setCorpusNumber(int corpusNumber) {
        this.corpusNumber = corpusNumber;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getEquipments() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments = equipments;
    }
    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Room))return false;
        Room room = (Room)other;
        if (this.roomNumber != room.roomNumber)
            return false;
        if (this.corpusNumber != room.corpusNumber)
            return false;
        if (this.maxPeople != room.maxPeople)
            return false;
        if (!this.equipments.equals(room.equipments))
            return false;
        return true;
    }
}
