package Units;

import java.time.LocalDateTime;

public class Lesson {
    private int studyUnitId;
    private String name;
    private int teacherId;
    private int roomId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    public Lesson(int studyUnitId, String name, LocalDateTime startDate){
        this.studyUnitId = studyUnitId;
        this.name = name;
        this.startDate = startDate;
        this.endDate = startDate.plusHours(1).plusMinutes(30);
    }

    public int getStudyUnitId() {
        return studyUnitId;
    }

    public void setStudyUnitId(int studyUnitId) {
        this.studyUnitId = studyUnitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
