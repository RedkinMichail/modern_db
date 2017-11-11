package mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBWorker {

    private MongoCollection<Document> getCollection(String collectionName){
        MongoClientURI uri  = new MongoClientURI("mongodb://admin:admin@ds255455.mlab.com:55455/schedule");
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        return db.getCollection(collectionName);
    }

    protected void addNewField(String collectionName, Document document) {
        try {
            getCollection(collectionName).insertOne(document);
        } catch (MongoWriteException mwx) {
            System.out.println("I can't add new document into \"" + collectionName
                    + "\" collection, because the document with the same name already exists");
        }
    }

    protected void deleteField(String collectionName, String nameOfField, Object nameOfObject) {
        Bson condition = new Document(nameOfField, nameOfObject);
        getCollection(collectionName).deleteOne(condition);
    }


    public void updateDocument(String nameOfDeparture) {

    }
}
