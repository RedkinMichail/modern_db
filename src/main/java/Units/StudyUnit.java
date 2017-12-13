package Units;

public class StudyUnit {
    private int id;
    private int departmentId;
    private int peopleCount;
    private int parentId;

    public StudyUnit(int id, int departmentId, int peopleCount, int parentId) {
        this.id = id;
        this.departmentId = departmentId;
        this.peopleCount = peopleCount;
        this.parentId = parentId;
    }
    public StudyUnit(int id, int departmentId, int peopleCount) {
        this.id = id;
        this.departmentId = departmentId;
        this.peopleCount = peopleCount;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof StudyUnit))
            return false;
        StudyUnit studyUnit = (StudyUnit)other;
        if (this.id != studyUnit.id)
            return false;
        if (this.departmentId != studyUnit.departmentId)
            return false;
        if (this.peopleCount != studyUnit.peopleCount)
            return false;
        if (this.parentId != studyUnit.parentId)
            return false;
        return true;
    }
}
