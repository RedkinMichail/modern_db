package mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Collection;
import java.util.UUID;

public class MongoDBWorker {

    private static MongoCollection<Document> getCollection(String collectionName){
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin@ds255455.mlab.com:55455/schedule");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        return db.getCollection(collectionName);
    }

    protected static void addNewField(String collectionName, Document document) {
        try {
            getCollection(collectionName).insertOne(document);
        } catch (MongoWriteException mwx) {
            System.out.println("I can't add new document into \"" + collectionName
                    + "\" collection, because the document with the same name already exists");
        }
    }

    public static void addRoom(int corpusNumber, int roomNumber, int maxPeople) {
        Document newRoom = new Document("CorpusNumber", corpusNumber)
                .append("RoomNumber", roomNumber)
                .append("MaxPeople", maxPeople);

        addNewField(Consts.ROOM_COLLECTION, newRoom);
    }

    protected static void deleteField(String collectionName, String nameOfField, Object nameOfObject) {
        Bson condition = new Document(nameOfField, nameOfObject);
        getCollection(collectionName).deleteOne(condition);
    }


    public static void updateDocument(String nameOfDeparture) {

    }

    public static void deleteRoom(int roomNumber) {
        deleteField(Consts.ROOM_COLLECTION, "RoomNumber", roomNumber);
    }

    public static void updateRoom(String nameOfDeparture) {
        updateDocument(nameOfDeparture);
    }

    protected static FindIterable<Document> findAll(String collectionName, String nameOfField, String nameOfObject) {
        Bson condition = new Document(nameOfField, nameOfObject);
        return getCollection(collectionName).find(condition);
    }

    public static void addDeparture(String nameOfDeparture, String nameOfParent, String headOfTheDeparture) {
        //хардкод имён полей, надо как-то править
        Document newDeparture = new Document("CodeOfDeparture", UUID.randomUUID().toString().substring(0, 7))
                .append("NameOfDeparture", nameOfDeparture)
                .append("NameOfParent", nameOfParent)
                .append("NeadOfTheDeparture", headOfTheDeparture);

        addNewField(Consts.DEPARTURE_COLLECTION, newDeparture);
    }

    public static void deleteDeparture(String nameOfDeparture) {
        //продумать надо, как грамотнее удалять по имени поля, а точнее не хардкодить имя поля, по которому будет идти поиск
        //я сейчас про "NameOfDeparture"
        deleteField(Consts.DEPARTURE_COLLECTION, "NameOfDeparture", nameOfDeparture);
    }

    public static void updateDeparture(String nameOfDeparture) {
        updateDocument(nameOfDeparture);
    }

    public static Document findDepartureByName(String nameOfDeparture) {
        return findAll(Consts.DEPARTURE_COLLECTION, "NameOfDeparture", nameOfDeparture).first();
    }

    public static MongoCursor<Document> findAllDepartures(String nameOfField, String nameOfObject) {
        return findAll(Consts.DEPARTURE_COLLECTION, nameOfField, nameOfObject).iterator();
    }
}
