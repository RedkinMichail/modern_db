package ViewModel;

import UnitModels.DepartureModel;
import UnitModels.RoomModel;
import Units.Departure;
import Units.Room;
import com.mongodb.client.MongoCursor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import mongoDB.DataRepository;
import org.bson.Document;

import java.util.ArrayList;

public class MainWindowViewModel {
    public ObservableList<RowModel> getRoomsList() {
        System.out.println("getRoomsList button");
        ArrayList<RowModel> rooms = new ArrayList<RowModel>();
        String[] equipments = {"computer", "desk"};
        rooms.add(new RowModel(new Room(1,3,23,equipments)));
        rooms.add(new RowModel(new Room(1,1,30,equipments)));
        ObservableList<RowModel> observableList = FXCollections.observableList(rooms);
        return observableList;
    }

    public ObservableList<RowModel> getDepartureList() {
        System.out.println("getDepartureList button");
        ArrayList<RowModel> departures = new ArrayList<RowModel>();
        departures.add(new RowModel(new Departure(2,"ФИИТ",1, 3)));
        ObservableList<RowModel> observableList = FXCollections.observableList(departures);
        return observableList;
    }
}
