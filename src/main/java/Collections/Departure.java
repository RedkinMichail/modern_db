package Collections;

import com.mongodb.client.MongoCursor;
import mongoDB.Consts;
import mongoDB.MongoDBWorker;
import org.bson.Document;

import java.util.Collection;
import java.util.UUID;

public class Departure extends MongoDBWorker {

    public void addDeparture(String nameOfDeparture, String nameOfParent, String headOfTheDeparture) {
        //хардкод имён полей, надо как-то править
        Document newDeparture = new Document("CodeOfDeparture", UUID.randomUUID().toString().substring(0, 7))
                .append("NameOfDeparture", nameOfDeparture)
                .append("NameOfParent", nameOfParent)
                .append("NeadOfTheDeparture", headOfTheDeparture);

        addNewField(Consts.DEPARTURE_COLLECTION, newDeparture);
    }

    public void deleteDepartureByName(String nameOfDeparture) {
        //продумать надо, как грамотнее удалять по имени поля, а точнее не хардкодить имя поля, по которому будет идти поиск
        //я сейчас про "NameOfDeparture"
        deleteField(Consts.DEPARTURE_COLLECTION, new Document("NameOfDeparture", nameOfDeparture));
    }

    public void updateDeparture(String nameOfDeparture) {
        updateDocument(Consts.DEPARTURE_COLLECTION, new Document("NameOfDepartures", nameOfDeparture));
    }

    public Document findDepartureByName(String nameOfDeparture) {
        return findAll(Consts.DEPARTURE_COLLECTION, new Document("NameOfDeparture", nameOfDeparture)).first();
    }

    public MongoCursor<Document> findAllDepartures(String nameOfField, String nameOfObject) {
        return findAll(Consts.DEPARTURE_COLLECTION, new Document(nameOfField, nameOfObject)).iterator();
    }
}
