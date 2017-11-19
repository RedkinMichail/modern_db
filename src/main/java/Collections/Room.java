package Collections;

import mongoDB.Consts;
import mongoDB.MongoDBWorker;
import org.bson.Document;

public class Room  {
    private int corpusNumber;
    private int roomNumber;
    private int maxPeople;

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
}
