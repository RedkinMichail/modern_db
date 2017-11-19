package ViewModel;

import javafx.beans.property.StringProperty;

public class MainWindowViewModel {
    private StringProperty corpusNumber;
    private StringProperty roomNumber;
    private StringProperty maxPeople;
    public void viewRooms() {
        System.out.println("viewRooms button");
    }
}
