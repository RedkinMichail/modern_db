package Collections;

import com.mongodb.client.MongoCursor;
import mongoDB.Consts;
import mongoDB.MongoDBWorker;
import org.bson.Document;

public class Room extends MongoDBWorker {

    public void addRoom(int housingNumber, int roomNumber, int maxPeople) {
        Document newRoom = new Document("HousingNumber", housingNumber)
                .append("RoomNumber", roomNumber)
                .append("MaxPeople", maxPeople);

        addNewField(Consts.ROOM_COLLECTION, newRoom);
    }

    public void deleteRoom(int roomNumber, int housingNumber) {
        deleteField(Consts.ROOM_COLLECTION, new Document("RoomNumber", roomNumber));
    }

    public void updateRoom(String nameOfDeparture) {
        updateDocument(Consts.ROOM_COLLECTION, new Document());
    }

    public Document findRoomInHousing(int roomNumber, int housingNumber) {
        Document room = new Document("RoomNumber", roomNumber)
                .append("HousingNumber", housingNumber);
        return findAll(Consts.ROOM_COLLECTION, room).first();
    }

    public MongoCursor<Document> findAllRooms(int roomNumber) {
        return findAll(Consts.ROOM_COLLECTION, new Document("RoomNumber", roomNumber)).iterator();
    }
}
