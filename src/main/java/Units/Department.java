package Units;

public class Department {
    private int id;
    private String name;
    private int parentId;

    public Department(int id, String name, int parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Department))return false;
        Department department = (Department)other;
        if (this.id != department.id)
            return false;
        if (!this.name.equals(department.name))
            return false;
        if (this.parentId != department.parentId)
            return false;
        return true;
    }
}
