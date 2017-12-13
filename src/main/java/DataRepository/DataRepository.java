package DataRepository;

import Units.Departure;
import Units.Room;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.UUID;

public class DataRepository implements IDataRepository {
    private MongoDatabase database;
    public DataRepository() {
        MongoClientURI uri = new MongoClientURI("mongodb://admin:admin@ds255455.mlab.com:55455/schedule");
        MongoClient client = new MongoClient(uri);
        database = client.getDatabase(uri.getDatabase());
        InitializeDataBase();
    }

    private void InitializeDataBase() {
        database.drop();
        database.getCollection(CollectionNames.ROOM_COLLECTION).createIndex(new Document("CorpusNumber", 1)
                .append("RoomNumber", 1),new IndexOptions().unique(true));
        database.getCollection(CollectionNames.DEPARTURE_COLLECTION).createIndex(new Document("Id", 1),new IndexOptions().unique(true));
        database.getCollection(CollectionNames.DEPARTURE_COLLECTION).createIndex(new Document("Name", 1),new IndexOptions().unique(true));
    }

    protected void addNewField(String collectionName, Document document) {
        try {
            database.getCollection(collectionName).insertOne(document);
        } catch (MongoWriteException mwx) {
            System.out.println("I can't add new document into \"" + collectionName
                    + "\" collection, because the document with the same name already exists");
        }
    }

    protected void deleteField(String collectionName, String nameOfField, Object nameOfObject) {
        Bson condition = new Document(nameOfField, nameOfObject);
        database.getCollection(collectionName).deleteOne(condition);
    }




    protected void deleteField(String collectionName, Document doc) {
        database.getCollection(collectionName).deleteOne(doc);
    }


    public void updateDocument(String collectionName, Document doc) {
//        getCollection(collectionName).updateOne();
    }

    public void deleteRoom(int roomNumber) {
        deleteField(CollectionNames.ROOM_COLLECTION, "RoomNumber", roomNumber);
    }

    protected FindIterable<Document> findAll(String collectionName, String nameOfField, String nameOfObject) {
        Bson condition = new Document(nameOfField, nameOfObject);
        return database.getCollection(collectionName).find(condition);
    }

    protected FindIterable<Document> findAll(String collectionName, Document doc) {
        return database.getCollection(collectionName).find(doc);
    }

    public void addDeparture(String nameOfDeparture, String nameOfParent, String headOfTheDeparture) {
        //хардкод имён полей, надо как-то править
        Document newDeparture = new Document("CodeOfDeparture", UUID.randomUUID().toString().substring(0, 7))
                .append("NameOfDeparture", nameOfDeparture)
                .append("NameOfParent", nameOfParent)
                .append("NeadOfTheDeparture", headOfTheDeparture);

        addNewField(CollectionNames.DEPARTURE_COLLECTION, newDeparture);
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.ROOM_COLLECTION).find().iterator();
        ArrayList<Room> rooms = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Room room = new Room(doc.getInteger("CorpusNumber")
            ,doc.getInteger("RoomNumber")
            ,doc.getInteger("MaxPeople")
            ,doc.get("Equipments").toString());
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public ArrayList<Departure> getAllDepartures() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.DEPARTURE_COLLECTION).find().iterator();
        ArrayList<Departure> departures = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Departure departure = new Departure(doc.getInteger("Id")
                    ,doc.getString("Name")
                    ,doc.getInteger("ParentId"));
            departures.add(departure);
        }
        return departures;
    }

    @Override
    public void addRoom(Room room){
        Document newRoom = new Document("CorpusNumber", room.getCorpusNumber())
                .append("RoomNumber", room.getRoomNumber())
                .append("MaxPeople", room.getMaxPeople())
                .append("Equipments", room.getEquipments());
            database.getCollection(CollectionNames.ROOM_COLLECTION).insertOne(newRoom);
    }

    @Override
    public void addDeparture(Departure departure) throws Exception{
        if(departure.getParentId() != 0) {
            getDepartureById(departure.getParentId());
        }
        Document newDepartment = new Document("Id", departure.getId())
                .append("Name", departure.getName())
                .append("ParentId", departure.getParentId());
        database.getCollection(CollectionNames.DEPARTURE_COLLECTION).insertOne(newDepartment);
    }

    @Override
    public Departure getDepartureById(int id) throws Exception {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.DEPARTURE_COLLECTION).find(new Document("Id", id)).iterator();
        if (cursor.hasNext()){
            Document document = cursor.next();
            return new Departure(document.getInteger("Id"),document.getString("Name"), document.getInteger("ParentId"));
        }
        throw new Exception("Departure with sush id doesn't exist");
    }
}
