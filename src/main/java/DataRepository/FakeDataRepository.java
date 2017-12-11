package DataRepository;

import Units.Departure;
import Units.Room;

import java.util.ArrayList;

public class FakeDataRepository implements IDataRepository {
    ArrayList<Room> rooms;
    ArrayList<Departure> departures;
    public FakeDataRepository(){
        rooms = new ArrayList<>();
        departures = new ArrayList<>();
    }
    @Override
    public ArrayList<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public ArrayList<Departure> getAllDepartures() {
        return departures;
    }

    @Override
    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void addDeparture(Departure departure) throws Exception {
        if(departure.getParentId() != 0) {
            getDepartureById(departure.getParentId());
        }
        departures.add(departure);
    }

    public Departure getDepartureById(int id) throws Exception {
        for (int i = 0; i < departures.size(); i++){
            if(departures.get(i).getId() == id)
                return departures.get(i);
        }
        throw new Exception("Not found departure with same id");
    }
}
