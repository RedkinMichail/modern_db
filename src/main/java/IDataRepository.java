import Units.Departure;
import Units.Room;

import java.util.ArrayList;

public interface IDataRepository {
    ArrayList<Room> getAllRooms();//возвращает все комнаты
    ArrayList<Departure> getAllDepartures();//возвращает все департаменты
}
