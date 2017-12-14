package DataRepository;

import Units.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoWriteException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class DataRepository implements IDataRepository {
    private MongoDatabase database;
    public DataRepository() {
        MongoClientURI uri = new MongoClientURI("mongodb://admin:admin@ds255455.mlab.com:55455/schedule");
        MongoClient client = new MongoClient(uri);
        database = client.getDatabase(uri.getDatabase());
        InitializeDataBase();
    }

    private void InitializeDataBase() {
        database.drop();
        database.getCollection(CollectionNames.ROOM_COLLECTION).createIndex(new Document("CorpusNumber", 1)
                .append("RoomNumber", 1), new IndexOptions().unique(true));

        database.getCollection(CollectionNames.DEPARTMENT_COLLECTION).createIndex(new Document("Id", 1), new IndexOptions().unique(true));
        database.getCollection(CollectionNames.DEPARTMENT_COLLECTION).createIndex(new Document("Name", 1), new IndexOptions().unique(true));

        database.getCollection(CollectionNames.STUDYUNIT_COLLECTION).createIndex(new Document("Id",1), new IndexOptions().unique(true));

        database.getCollection(CollectionNames.TEACHER_COLLECTION).createIndex(new Document("PassportSeries", 1)
                .append("PassportNumber", 1), new IndexOptions().unique(true));
    }

    @Override
    public ArrayList<Room> getAllRooms() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.ROOM_COLLECTION).find().iterator();
        ArrayList<Room> rooms = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Room room = new Room(doc.getInteger("CorpusNumber"),
            doc.getInteger("RoomNumber"),
            doc.getInteger("MaxPeople"),
            doc.get("Equipments").toString());
            rooms.add(room);
        }
        return rooms;
    }

    @Override
    public ArrayList<Department> getAllDepartments() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.DEPARTMENT_COLLECTION).find().iterator();
        ArrayList<Department> Departments = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Department Department = new Department(doc.getInteger("Id"),
                    doc.getString("Name"),
                    doc.getInteger("ParentId"));
            Departments.add(Department);
        }
        return Departments;
    }

    @Override
    public ArrayList<StudyUnit> getAllStudyUnits() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.STUDYUNIT_COLLECTION).find().iterator();
        ArrayList<StudyUnit> studyUnits = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            StudyUnit studyUnit = new StudyUnit(doc.getInteger("Id"),
                    doc.getInteger("DepartmentId"),
                    doc.getInteger("PeopleCount"));
            studyUnits.add(studyUnit);
        }
        return studyUnits;
    }

    @Override
    public ArrayList<Teacher> getAllTeachers() {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.TEACHER_COLLECTION).find().iterator();
        ArrayList<Teacher> teachers = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Teacher teacher = new Teacher(doc.getString("FullName"),
                    doc.getInteger("PassportSeries"),
                    doc.getInteger("PassportNumber"),
                    doc.getInteger("DepartmentId"));
            teachers.add(teacher);
        }
        return teachers;
    }

    @Override
    public void addRoom(Room room){
        Document newRoom = new Document("CorpusNumber", room.getCorpusNumber())
                .append("RoomNumber", room.getRoomNumber())
                .append("MaxPeople", room.getMaxPeople())
                .append("Equipments", room.getEquipments());
            database.getCollection(CollectionNames.ROOM_COLLECTION).insertOne(newRoom);
    }

    @Override
    public void addDepartment(Department Department) throws Exception{
        if(Department.getParentId() != 0) {
            getDepartmentById(Department.getParentId());
        }
        Document newDepartment = new Document("Id", Department.getId())
                .append("Name", Department.getName())
                .append("ParentId", Department.getParentId());
        database.getCollection(CollectionNames.DEPARTMENT_COLLECTION).insertOne(newDepartment);
    }

    @Override
    public void addStudyUnit(StudyUnit studyUnit) throws Exception {
        if(studyUnit.getParentId() != 0) {
            getStudyUnitById(studyUnit.getParentId());
        }
        Document newStudyUnit = new Document("Id", studyUnit.getId())
                .append("DepartmentId", studyUnit.getDepartmentId())
                .append("PeopleCount", studyUnit.getPeopleCount())
                .append("ParentId", studyUnit.getParentId());
        database.getCollection(CollectionNames.STUDYUNIT_COLLECTION).insertOne(newStudyUnit);
    }

    @Override
    public Department getDepartmentById(int id) throws Exception {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.DEPARTMENT_COLLECTION).find(new Document("Id", id)).iterator();
        if (cursor.hasNext()){
            Document document = cursor.next();
            return new Department(document.getInteger("Id"), document.getString("Name"), document.getInteger("ParentId"));
        }
        throw new Exception("Department with such id doesn't exist");
    }

    @Override
    public StudyUnit getStudyUnitById(int id) throws Exception {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.STUDYUNIT_COLLECTION).find(new Document("Id", id)).iterator();
        if (cursor.hasNext()){
            Document document = cursor.next();
            return new StudyUnit(document.getInteger("Id"),
                    document.getInteger("DepartmentId"),
                    document.getInteger("PeopleCount"),
                    document.getInteger("ParentId"));
        }
        throw new Exception("StudyUnit with id = " + id + " doesn't exist");
    }

    @Override
    public void addTeacher(Teacher teacher) {
        Document newTeacher = new Document("FullName", teacher.getFullName())
                .append("PassportSeries", teacher.getPassportSeries())
                .append("PassportNumber", teacher.getPassportNumber())
                .append("DepartmentId", teacher.getDepartmentId());
        database.getCollection(CollectionNames.TEACHER_COLLECTION).insertOne(newTeacher);
    }

    @Override
    public Teacher getTeacherByPassportSeriesAndPassportNumber(int passportSeries, int passportNumber) throws Exception {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.TEACHER_COLLECTION)
                .find(new Document("PassportSeries", passportSeries)
                .append("PassportNumber", passportNumber))
                .iterator();

        if (cursor.hasNext()){
            Document document = cursor.next();
            return new Teacher(document.getString("FullName"),
                    document.getInteger("PassportSeries"),
                    document.getInteger("PassportNumber"),
                    document.getInteger("DepartmentId"));
        }
        throw new Exception("Teacher with PassportSeries = " + passportSeries
                + " and PassportNumber = " + passportNumber + " doesn't exist");
    }

    @Override
    public void addLesson(Lesson lesson) throws Exception {
        StudyUnit studyUnit = getStudyUnitById(lesson.getStudyUnitId());
        Document newLesson = new Document("Name", lesson.getName())
                .append("StartDate", lesson.getStartDate().toString())
                .append("EndDate", lesson.getEndDate().toString());
        database.getCollection(CollectionNames.LESSON_COLLECTION).insertOne(newLesson);
    }

    @Override
    public ArrayList<Lesson> getLessonsByStudyUnitId(int id) {
        MongoCursor<Document> cursor = database.getCollection(CollectionNames.LESSON_COLLECTION)
                .find(new Document("StudyUnitId", id)).iterator();
        ArrayList<Lesson> lessons = new ArrayList<>();

        while (cursor.hasNext()){
            Document doc = cursor.next();
            Lesson lesson = new Lesson(doc.getInteger("StudyUnitId")
                    , doc.getString("Name")
                    , LocalDateTime.parse(doc.getString("startDate")));
            lessons.add(lesson);
        }
        return lessons;
    }
}
