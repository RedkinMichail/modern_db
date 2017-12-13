package ViewModel;

import DataRepository.IDataRepository;
import Units.Room;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class DataViewModel {
    public IDataRepository dataRepository;
    public ObservableList<RowModel> getRoomsList() {
        System.out.println("getRoomsList button");
        ArrayList<RowModel> rooms = new ArrayList<RowModel>();
        String equipments = "computer,desk";
        rooms.add(new RowModel(new Room(1,3,23,equipments)));
        rooms.add(new RowModel(new Room(1,1,30,equipments)));
        ObservableList<RowModel> observableList = FXCollections.observableList(rooms);
        return observableList;
    }

}
