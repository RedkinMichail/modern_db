import DataRepository.IDataRepository;
import DataRepository.DataRepository;
import Units.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class WhenAdd {
    private IDataRepository dataRepository;
    private ArrayList<Room> rooms;
    private ArrayList<Department> departments;
    private ArrayList<StudyUnit> studyUnits;
    private ArrayList<Teacher> teachers;
    private ArrayList<Lesson> lessons;
    private Room room;

    @Before
    public void setUp(){
        dataRepository = new DataRepository();
        room = new Room(1,2,20,"desk,computer");
    }

    @Test
    public void RoomAndGetAllRooms_ResultShouldContainThatRoom() throws Exception{
        dataRepository.addRoom(room);
        rooms = dataRepository.getAllRooms();

        Assert.assertTrue(rooms.contains(room));
    }

    @Test(expected = Exception.class)
    public void TwoEqualRooms_ShouldThrowException() throws Exception{
        dataRepository.addRoom(room);
        dataRepository.addRoom(room);
    }

    @Test
    public void DepartmentAndGetAllDepartments_ResultShouldContainThatDepartment() throws Exception {
        Department department = new Department(1,"University");

        dataRepository.addDepartment(department);
        departments = dataRepository.getAllDepartments();

        Assert.assertTrue(departments.contains(department));
    }

    @Test(expected = Exception.class)
    public void GetDepartmentWithUnknownId_ShouldThrowException() throws Exception {
        dataRepository.getDepartmentById(1);
    }

    @Test(expected = Exception.class)
    public void DepartmentWithUnknownParentId_ShouldThrowException() throws Exception {
        Department department = new Department(2,"ITMM", 2);

        dataRepository.addDepartment(department);
    }

    @Test
    public void DepartmentWithKnownParentId_ShouldBeAdded() throws Exception {
        Department parentDepartment = new Department(1,"University");
        Department department = new Department(2,"ITMM", 1);

        dataRepository.addDepartment(parentDepartment);
        dataRepository.addDepartment(department);

        assertEquals(dataRepository.getDepartmentById(department.getId()), department);
    }

    @Test(expected = Exception.class)
    public void StudyUnitWithUnknownId_ShouldThrowException() throws Exception {
        dataRepository.getStudyUnitById(123);
    }

    @Test(expected = Exception.class)
    public void StudyUnitWithUnknownParentId_ShouldThrowException() throws Exception {
        StudyUnit studyUnit = new StudyUnit(1, 2, 10, 3);
        dataRepository.addStudyUnit(studyUnit);
    }

    @Test
    public void StudyUnitWithKnownParentId_ShouldBeAdded() throws Exception {
        StudyUnit parentStudyUnit = new StudyUnit(2, 6, 5);
        StudyUnit studyUnit = new StudyUnit(1, 6, 10, 2);

        dataRepository.addStudyUnit(parentStudyUnit);
        dataRepository.addStudyUnit(studyUnit);

        assertEquals(dataRepository.getStudyUnitById(studyUnit.getId()), studyUnit);
    }

    @Test(expected = Exception.class)
    public void TwoEqualStudyUnits_ShouldThrowException() throws Exception {
        StudyUnit studyUnit = new StudyUnit(2, 6, 5);
        dataRepository.addStudyUnit(studyUnit);
        dataRepository.addStudyUnit(studyUnit);
    }

    @Test
    public void GetAllStudyUnits() throws Exception {
        StudyUnit studyUnit = new StudyUnit(2, 6, 5);

        dataRepository.addStudyUnit(studyUnit);
        studyUnits = dataRepository.getAllStudyUnits();

        Assert.assertTrue(studyUnits.contains(studyUnit));
    }

    @Test
    public void TeacherCanBeAddedAndExists() throws Exception {
        Teacher teacher = new Teacher("Petrov P. A.", 123, 321, 5);

        dataRepository.addTeacher(teacher);

        assertEquals(dataRepository.getTeacherByPassportSeriesAndPassportNumber(teacher.getPassportSeries(), teacher.getPassportNumber()),
                teacher);
    }

    @Test
    public void GetAllTeachers() throws Exception {
        Teacher teacher = new Teacher("Petrov P. A.", 123, 321, 5);

        dataRepository.addTeacher(teacher);
        teachers = dataRepository.getAllTeachers();

        Assert.assertTrue(teachers.contains(teacher));
    }

    @Test(expected = Exception.class)
    public void TwoEqualTeachers_ShouldThrowException() throws Exception {
        Teacher teacher = new Teacher("Petrov P. A.", 123, 321, 5);

        dataRepository.addTeacher(teacher);
        dataRepository.addTeacher(teacher);
    }

    @Test(expected = Exception.class)
    public void LessonWithUnknownStudyUnitId_ShouldThrowException() throws Exception {
        Lesson lesson = new Lesson(1,"Mathematical analysis", LocalDateTime.now());

        dataRepository.addLesson(lesson);
    }

    @Test
    public void LessonAndGetLessons_ResultShouldContainThatLesson() throws Exception{
        StudyUnit studyUnit = new StudyUnit(2, 6, 5);
        Lesson lesson = new Lesson(2,"Mathematical analysis", LocalDateTime.now());

        dataRepository.addStudyUnit(studyUnit);
        dataRepository.addLesson(lesson);
        lessons = dataRepository.getLessonsByStudyUnitId(studyUnit.getId());

    }
}
