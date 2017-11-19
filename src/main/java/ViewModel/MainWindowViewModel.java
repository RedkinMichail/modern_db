package ViewModel;

import Units.Room;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class MainWindowViewModel {
    private StringProperty corpusNumber;
    private StringProperty roomNumber;
    private IntegerProperty maxPeople;
    public ObservableList<Room> getRoomsList() {
        System.out.println("getRoomsList button");
        ArrayList<Room> rooms = new ArrayList<Room>();
        String[] equipments = {"computer", "desk"};
        rooms.add(new Room(1,2,22,equipments));
        ObservableList<Room> observableList = FXCollections.observableList(rooms);
        return observableList;
    }
}
