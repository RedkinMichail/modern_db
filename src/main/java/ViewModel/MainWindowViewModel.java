package ViewModel;

import UnitModels.RoomModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class MainWindowViewModel {
    private StringProperty corpusNumber;
    private StringProperty roomNumber;
    private IntegerProperty maxPeople;
    public ObservableList<RoomModel> getRoomsList() {
        System.out.println("getRoomsList button");
        ArrayList<RoomModel> rooms = new ArrayList<RoomModel>();
        String[] equipments = {"computer", "desk"};
        rooms.add(new RoomModel(1,2,22,equipments));
        ObservableList<RoomModel> observableList = FXCollections.observableList(rooms);
        return observableList;
    }
}
