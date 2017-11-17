package mongoDB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Collection;

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

    protected void deleteField(String collectionName, Document doc) {
        getCollection(collectionName).deleteOne(doc);
    }


    public void updateDocument(String collectionName, Document doc) {
//        getCollection(collectionName).updateOne();

    }

    protected FindIterable<Document> findAll(String collectionName, Document doc) {
        return getCollection(collectionName).find(doc);
    }
}
