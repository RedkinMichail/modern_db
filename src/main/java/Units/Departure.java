package Units;

public class Departure {
    private int id;
    private String name;
    private int parentId;
    private int leaderId;

    public Departure(int id, String name, int parentId, int leaderId){
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.leaderId = leaderId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }
}
