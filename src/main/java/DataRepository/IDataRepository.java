package DataRepository;

import Units.Departure;
import Units.Room;

import java.util.ArrayList;

public interface IDataRepository {
    ArrayList<Room> getAllRooms();//возвращает все комнаты
    ArrayList<Departure> getAllDepartures();//возвращает все департаменты

    void addRoom(Room room);

    void addDeparture(Departure departure) throws Exception;

    Departure getDepartureById(int id) throws Exception;
}
