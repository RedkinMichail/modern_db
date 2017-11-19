package Collections;

import java.util.List;

public class Room  {
    private int corpusNumber;
    private int roomNumber;
    private int maxPeople;
    private List<String> equipments;

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

    public List<String> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<String> equipments) {
        this.equipments = equipments;
    }
}
