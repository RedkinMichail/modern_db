package DataRepository;

import Units.Department;
import Units.Room;
import Units.StudyUnit;
import Units.Teacher;

import java.util.ArrayList;

public interface IDataRepository {
    ArrayList<Room> getAllRooms();//return all rooms
    ArrayList<Department> getAllDepartments();//return all departments
    ArrayList<StudyUnit> getAllStudyUnits();
    ArrayList<Teacher> getAllTeachers();

    void addRoom(Room room);

    void addDepartment(Department department) throws Exception;

    void addStudyUnit(StudyUnit studyUnit) throws Exception;

    Department getDepartmentById(int id) throws Exception;

    StudyUnit getStudyUnitById(int id) throws Exception;

    void addTeacher(Teacher teacher);

    Teacher getTeacherByPassportSeriesAndPassportNumber(int passportSeries, int passportNumber) throws Exception;
}
