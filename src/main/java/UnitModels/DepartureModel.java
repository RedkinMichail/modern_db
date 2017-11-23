package UnitModels;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class DepartureModel {
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty parentId;
    private final SimpleIntegerProperty leaderId;

    public DepartureModel(int id, String name, int parentId, int leaderId){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.parentId = new SimpleIntegerProperty(parentId);
        this.leaderId = new SimpleIntegerProperty(leaderId);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getParentId() {
        return parentId.get();
    }

    public SimpleIntegerProperty parentIdProperty() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId.set(parentId);
    }

    public int getLeaderId() {
        return leaderId.get();
    }

    public SimpleIntegerProperty leaderIdProperty() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId.set(leaderId);
    }
}
