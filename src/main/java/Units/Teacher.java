package Units;

public class Teacher {
    private String fullName;
    private int passportSeries;
    private int passportNumber;
    private int departmentId;

    public Teacher (String fullName, int passportSeries, int passportNumber, int departmentId) {
        this.fullName = fullName;
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.departmentId = departmentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (passportSeries != teacher.passportSeries) return false;
        if (passportNumber != teacher.passportNumber) return false;
        if (departmentId != teacher.departmentId) return false;
        return fullName != null ? fullName.equals(teacher.fullName) : teacher.fullName == null;
    }
}
