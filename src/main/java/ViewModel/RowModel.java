package ViewModel;

import Units.Department;
import Units.Room;
import Units.StudyUnit;
import javafx.beans.property.SimpleStringProperty;

public class RowModel {
    private SimpleStringProperty column1;
    private SimpleStringProperty column2;
    private SimpleStringProperty column3;
    private SimpleStringProperty column4;
    public RowModel(Room room){
        column1 = new SimpleStringProperty(String.valueOf(room.getCorpusNumber()));
        column2 = new SimpleStringProperty(String.valueOf(room.getRoomNumber()));
        column3 = new SimpleStringProperty(String.valueOf(room.getMaxPeople()));
        column4 = new SimpleStringProperty(String.join(",", room.getEquipments()));
    }

    public RowModel(Department department){
        column1 = new SimpleStringProperty(String.valueOf(department.getId()));
        column2 = new SimpleStringProperty(String.valueOf(department.getName()));
        column3 = new SimpleStringProperty(String.valueOf(department.getParentId()));
    }

    public RowModel(StudyUnit studyUnit){
        column1 = new SimpleStringProperty(String.valueOf(studyUnit.getId()));
        column2 = new SimpleStringProperty(String.valueOf(studyUnit.getParentId()));
        column3 = new SimpleStringProperty(String.valueOf(studyUnit.getPeopleCount()));
    }

    public String getColumn1() {
        return column1.get();
    }

    public SimpleStringProperty column1Property() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1.set(column1);
    }

    public String getColumn2() {
        return column2.get();
    }

    public SimpleStringProperty column2Property() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2.set(column2);
    }

    public String getColumn3() {
        return column3.get();
    }

    public SimpleStringProperty column3Property() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3.set(column3);
    }

    public String getColumn4() {
        return column4.get();
    }

    public SimpleStringProperty column4Property() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4.set(column4);
    }
}
