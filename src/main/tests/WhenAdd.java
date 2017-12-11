import DataRepository.FakeDataRepository;
import DataRepository.IDataRepository;
import DataRepository.DataRepository;
import Units.Departure;
import Units.Room;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class WhenAdd {
    private IDataRepository dataRepository;
    private ArrayList<Room> rooms;
    private ArrayList<Departure> departures;
    private Room room;
    @Before
    public void setUp(){
        dataRepository =  new FakeDataRepository();
        room = new Room(1,1,20,"desk,computer");
    }

    @Test
    public void RoomAndInvokeGetAllRooms_ResultShouldContainThatRoom(){
        dataRepository.addRoom(room);
        rooms = dataRepository.getAllRooms();

        Assert.assertTrue(rooms.contains(room));
    }

    @Test
    public void DepartureAndInvokeGetAllDepartures_ResultShouldContainThatDeparture(){
        Departure departure = new Departure(1,"University");

        dataRepository.addDeparture(departure);
        departures = dataRepository.getAllDepartures();

        Assert.assertTrue(departures.contains(departure));
    }


}
