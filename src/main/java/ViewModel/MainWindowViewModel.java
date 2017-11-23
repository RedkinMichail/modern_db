package ViewModel;

import UnitModels.DepartureModel;
import UnitModels.RoomModel;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mongoDB.DataRepository;
import org.bson.Document;

import java.util.ArrayList;

public class MainWindowViewModel {
    public ObservableList<RoomModel> getRoomsList() {
        System.out.println("getRoomsList button");
        ArrayList<RoomModel> rooms = new ArrayList<RoomModel>();
        String[] equipments = {"computer", "desk"};
        rooms.add(new RoomModel(1,2,22,equipments));
        rooms.add(new RoomModel(1,3,23,equipments));
        ObservableList<RoomModel> observableList = FXCollections.observableList(rooms);
        return observableList;
    }

    public ObservableList<DepartureModel> getDepartureList() {
        System.out.println("getDepartureList button");
        ArrayList<DepartureModel> departures = new ArrayList<DepartureModel>();
        departures.add(new DepartureModel(2,"ФИИТ",1, 3));
        ObservableList<DepartureModel> observableList = FXCollections.observableList(departures);
        return observableList;
    }
}
