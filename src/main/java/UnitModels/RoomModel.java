package UnitModels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class RoomModel {
    private final SimpleIntegerProperty corpusNumber;
    private final SimpleIntegerProperty roomNumber;
    private final SimpleIntegerProperty maxPeople;
    private final SimpleStringProperty equipments;

    public RoomModel(int corpusNumber, int roomNumber, int maxPeople, String[] equipments){
        this.corpusNumber = new SimpleIntegerProperty(corpusNumber);
        this.roomNumber = new SimpleIntegerProperty(roomNumber);
        this.maxPeople = new SimpleIntegerProperty(maxPeople);
        this.equipments = new SimpleStringProperty(String.join(",",equipments));
    }


    public int getCorpusNumber() {
        return corpusNumber.get();
    }

    public SimpleIntegerProperty corpusNumberProperty() {
        return corpusNumber;
    }

    public void setCorpusNumber(int corpusNumber) {
        this.corpusNumber.set(corpusNumber);
    }

    public int getRoomNumber() {
        return roomNumber.get();
    }

    public SimpleIntegerProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public int getMaxPeople() {
        return maxPeople.get();
    }

    public SimpleIntegerProperty maxPeopleProperty() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople.set(maxPeople);
    }

    public String getEquipments() {
        return equipments.get();
    }

    public SimpleStringProperty equipmentsProperty() {
        return equipments;
    }

    public void setEquipments(String equipments) {
        this.equipments.set(equipments);
    }
}
