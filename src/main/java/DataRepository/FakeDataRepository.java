package DataRepository;

import Units.Departure;
import Units.Room;

import java.util.ArrayList;

public class FakeDataRepository implements IDataRepository {
    ArrayList<Room> rooms;
    public FakeDataRepository(){
        rooms = new ArrayList<>();
    }
    @Override
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public ArrayList<Departure> getAllDepartures() {
        return null;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }
}
