package Collections;

import mongoDB.Consts;
import mongoDB.MongoDBWorker;
import org.bson.Document;

public class Room extends MongoDBWorker {

    public void addRoom(int corpusNumber, int roomNumber, int maxPeople) {
        Document newRoom = new Document("CorpusNumber", corpusNumber)
                .append("RoomNumber", roomNumber)
                .append("MaxPeople", maxPeople);

        addNewField(Consts.ROOM_COLLECTION, newRoom);
    }

    public void deleteRoom(int roomNumber) {
        deleteField(Consts.ROOM_COLLECTION, "RoomNumber", roomNumber);
    }

    public void updateRoom(String nameOfDeparture) {
        updateDocument(nameOfDeparture);
    }

}
