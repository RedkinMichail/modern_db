package DataRepository;

import Units.*;

import java.util.ArrayList;

public class FakeDataRepository implements IDataRepository {
    ArrayList<Room> rooms;
    ArrayList<Department> departments;
    public FakeDataRepository(){
        rooms = new ArrayList<>();
        departments = new ArrayList<>();
    }
    @Override
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        return departments;
    }

    @Override
    public ArrayList<StudyUnit> getAllStudyUnits() {
        return null;
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void addDepartment(Department department) throws Exception {
        if(department.getParentId() != 0) {
            getDepartmentById(department.getParentId());
        }
        departments.add(department);
    }

    @Override
    public void addStudyUnit(StudyUnit studyUnit) throws Exception {

    }

    @Override
    public Department getDepartmentById(int id) throws Exception {
        for (int i = 0; i < departments.size(); i++){
            if(departments.get(i).getId() == id)
                return departments.get(i);
        }
        throw new Exception("Not found departure with same id");
    }

    @Override
    public StudyUnit getStudyUnitById(int id) throws Exception {
        return null;
    }

    @Override
    public void addTeacher(Teacher teacher) {

    }

    @Override
    public Teacher getTeacherByPassportSeriesAndPassportNumber(int passportSeries, int passportNumber) throws Exception {
        return null;
    }

    @Override
    public void addLesson(Lesson lesson) {

    }

    @Override
    public ArrayList<Lesson> getLessonsByStudyUnitId(int id) {
        return null;
    }
}
